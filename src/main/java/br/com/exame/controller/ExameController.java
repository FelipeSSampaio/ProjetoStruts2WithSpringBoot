package br.com.exame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.exame.service.ExameService;
import br.com.exame.ws.client.Exame;

@Controller
public class ExameController
{
	@Autowired
    ExameService service;
    
    private Long id;
    private String nome;
    private String status;
    private String mensagemErro;
    private List<Exame> listaExame;

    public String cadastraExameForm() {
    	
        try {
            if(!nome.equalsIgnoreCase("") && !status.equalsIgnoreCase("")){
                boolean result = service.cadastrarExame(nome, status);
            } else {
            	this.mensagemErro = "Os campos 'nome' e 'status' são obrigatórios!";
            }
        }
        catch(Exception e) {
            this.mensagemErro = "Ocorreu um erro ao tentar salvar o exame.";
            e.printStackTrace();
            return "erro";
        }
        
        return "success";
    }

    public String alteraExameForm() {
        
        try {
        	
            if(!nome.equalsIgnoreCase("") && !status.equalsIgnoreCase("") && id != null) {
                boolean result = service.alterarExame(id, nome, status);
            }
            else {
            	this.mensagemErro = "Os campos 'nome' e 'status' são obrigatórios!";
            	return "erro";
            }
        }
        catch(Exception e) {
            this.mensagemErro = "Ocorreu um erro ao tentar alterar o exame.";
            e.printStackTrace();
            return "erro";
        }
        
        return "success";
    }

    public String exclueExameForm() {

    	try {
                
    		if(id != null) {
               boolean result = service.excluirExame(id);
               
            } else {
    			this.mensagemErro = "Os campos 'nome' e 'status' são obrigatórios!";
    			return "erro";
    		}
    		
        } catch(Exception e) {
            this.mensagemErro = "Ocorreu um erro ao tentar alterar o exame.";
            e.printStackTrace();
            return "erro";
        }      
    	
        return "success";
    }

    public String listaResultadoExame() {
        
    	if(id == null) {
    		this.mensagemErro = "O ID é obrigatório!";
    		return "erro";
    	}
    	
        try
        {
            Exame result = service.getExameResponse(id).getExame();
         
            if(result.getId() != 0){
                this.nome = result.getNome();
                this.status = result.getStatus();
            } else {
            	this.mensagemErro = "Nenhum resultado foi encontrado!";
                return "erro";
            }
        }
        catch(Exception e){
            this.mensagemErro = "Ocorreu um erro ao tentar buscar um exame.";
            e.printStackTrace();
            return "erro";
        }
        
        return "success";
    }

    public String listaTodosExames()
    {
        listaExame = service.listarTodos();
        
        if(listaExame.isEmpty()){
            this.mensagemErro = "Nenhum exame foi encontrado!";
            return "erro";
        } else {
            return "success";
        }
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getMensagemErro(){
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro){
        this.mensagemErro = mensagemErro;
    }

    public List<Exame> getListaExame(){
        return listaExame;
    }

    public void setListaExame(List<Exame> listaExame){
        this.listaExame = listaExame;
    }
}