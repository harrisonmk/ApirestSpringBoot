
package com.projeto.ApirestSpringBoot.modelo;


public class Saudacao {
    
    
    private long id;
    private String conteudo;

    
    
    public Saudacao(long id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public Saudacao() {
    }

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

   
    
    
    
    
    
    
}
