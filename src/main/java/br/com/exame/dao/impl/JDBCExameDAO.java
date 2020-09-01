package br.com.exame.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.exame.dao.ExameDAO;
import br.com.exame.ws.client.Exame;

@Repository
public class JDBCExameDAO implements ExameDAO
{

    private Connection abreConexao(){
        try {
        	return DriverManager.getConnection("jdbc:postgresql://localhost/Exames", "postgres", "postgres");
        } catch(SQLException e) {
        	throw new RuntimeException(e);
        }
    }

    public boolean salva(Exame exame)
    {
        
        
        StringBuffer querie = new StringBuffer();
        querie.append("Insert into Exame (id, nome_paciente, status) ");
        querie.append("values (nextval('exame_sequence'), ?, ?)");
        
        Connection conn = abreConexao();
        
        try
        {
            PreparedStatement ps = null;
            ps = conn.prepareStatement(querie.toString());
            
            ps.setString(1, exame.getNome());
            ps.setString(2, exame.getStatus());
            
            return ps.execute();
        }
        catch(SQLException sqlException)
        {
            throw new RuntimeException(sqlException);
        }
        finally {
	        try {
	            conn.close();
	        }
	        catch(Exception e){
	            throw new RuntimeException(e);
	        }
        }
    }

    public boolean altera(Exame exame) {
    	
        StringBuffer querie = new StringBuffer();
        querie.append("Update Exame set nome_paciente = ?, status = ? ");
        querie.append("where id = ?");
        
        Connection conn = abreConexao();
        
        try {
            PreparedStatement ps = null;
            ps = conn.prepareStatement(querie.toString());
            
            ps.setString(1, exame.getNome());
            ps.setString(2, exame.getStatus());
            ps.setLong(3, exame.getId());
            
            return ps.execute();
            
        } catch(SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        finally { 
        	try {
                conn.close();
            }
            catch(Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Exame> lista(){
        List<Exame> exames = new ArrayList<Exame>();;
        
        StringBuffer querie;
        querie = new StringBuffer();
        querie.append("Select * from Exame");
        
        Connection conn = abreConexao();
        
        try{
            PreparedStatement ps = conn.prepareStatement(querie.toString());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
            	Exame exame = new Exame();
                exame.setId(rs.getLong("id"));
                exame.setNome(rs.getString("nome_paciente"));
                exame.setStatus(rs.getString("status"));
                
                exames.add(exame);
            }
        } catch(SQLException sqlException){
			throw new RuntimeException(sqlException);
		}
		finally {
			try{
				conn.close();
			}
			catch(Exception e){
				throw new RuntimeException(e);
			}
		}
        
        return exames;
    }

    public Exame findExame(Long id)
    {
        Exame exameWs = new Exame();;        
        
        StringBuffer querie;
        querie = new StringBuffer();
        querie.append("Select * from Exame where id = ?");
        
        Connection conn = abreConexao();
        
        try
        {
            PreparedStatement ps = null;
            ps = conn.prepareStatement(querie.toString());
            ps.setLong(1, id.longValue());
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                exameWs.setId(rs.getLong("id"));
                exameWs.setNome(rs.getString("nome_paciente"));
                exameWs.setStatus(rs.getString("status"));
            }
        } catch(SQLException sqlException) {
            throw new RuntimeException(sqlException);
        } finally {
			try{
				conn.close();
			}
			catch(Exception e){
				throw new RuntimeException(e);
			}
		}
        
        return exameWs;
    }

    public boolean remove(Exame exame){        
        
    	StringBuffer querie = new StringBuffer();
        querie.append("Delete from Exame ");
        querie.append("where id = ?");
        
        Connection conn = abreConexao();
        
        try {
            PreparedStatement ps = null;
            
            ps = conn.prepareStatement(querie.toString());
            ps.setLong(1, exame.getId());
            
            return ps.execute();
        }
        catch(SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        finally { 
        	try{
				conn.close();
			}
			catch(Exception e){
				throw new RuntimeException(e);
			}       	
        }
    }

    public List<Exame> findAll()
    {
        List<Exame> listaExame = new ArrayList<Exame>();
        
        StringBuffer querie;
        
        querie = new StringBuffer();
        querie.append("Select * from Exame order by id");
        
        Connection conn = abreConexao();
        
        try
        {
            PreparedStatement ps = null;
            ps = conn.prepareStatement(querie.toString());
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
            	
            	Exame exame = new Exame();
                exame.setId(rs.getLong("id"));
                exame.setNome(rs.getString("nome_paciente"));
                exame.setStatus(rs.getString("status"));
                
                listaExame.add(exame);
            }

        } catch(SQLException sqlException) {
            throw new RuntimeException(sqlException);
        } finally { 
        	try{
				conn.close();
			}
			catch(Exception e){
				throw new RuntimeException(e);
			}       	
        }
        
        return listaExame;
    }
}