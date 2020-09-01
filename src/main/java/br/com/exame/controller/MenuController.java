package br.com.exame.controller;

public class MenuController {
	
    private Long id;
    private String nome;
    private String status;

    public String execute() throws Exception{
        return "success";
    }

    public String cadastraExame(){
        return "success";
    }

    public String alteraExame(){
        return "success";
    }

    public String exclueExame(){
        return "success";
    }

    public String pesquisaExame(){
        return "success";
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
}