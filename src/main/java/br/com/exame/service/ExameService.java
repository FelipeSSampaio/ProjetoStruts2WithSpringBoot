package br.com.exame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import br.com.exame.dao.impl.JDBCExameDAO;
import br.com.exame.ws.client.Exame;
import br.com.exame.ws.client.GetExameRequest;
import br.com.exame.ws.client.GetExameResponse;

public class ExameService extends WebServiceGatewaySupport {

	@Autowired
    private JDBCExameDAO jdbcExameDAO;

    public GetExameResponse getExameResponse(long id){
        GetExameRequest getExameRequest = new GetExameRequest();
        getExameRequest.setId(id);
        
        GetExameResponse response = (GetExameResponse)getWebServiceTemplate().marshalSendAndReceive("http://localhost:8080/ws/exames", getExameRequest, new SoapActionCallback("http://client.ws.exame.com.br/GetExameRequest"));
        
        return response;
    }

    public boolean cadastrarExame(String nome, String status) throws Exception {
        
    	boolean result = false;
        
    	Exame exame = montaExame(nome, status);
        
        try {
            result = jdbcExameDAO.salva(exame);
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        
        return result;
    }

    public boolean alterarExame(Long id, String nome, String status){
    	
        boolean result = false;
        
        Exame exame = montaExame(nome, status);
        exame.setId(id.longValue());
        
        try {
            result = jdbcExameDAO.altera(exame);
        
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        
        return result;
    }

    public boolean excluirExame(Long id) {
        
    	boolean result = false;
        
    	Exame exame = montaExame("", "");
        exame.setId(id.longValue());
        
        try {
            result = jdbcExameDAO.remove(exame);
            
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        
        return result;
    }

    public List<Exame> listarTodos() {
        List<Exame> listaExames;
        
        try {
            listaExames = jdbcExameDAO.findAll();
            
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
        
        return listaExames;
    }

    private Exame montaExame(String nome, String status)
    {
        Exame exame = new Exame();
        exame.setNome(nome);
        exame.setStatus(status);
        return exame;
    }
}