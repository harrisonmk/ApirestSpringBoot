
package com.projeto.ApirestSpringBoot.data.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PessoaVOV2 implements Serializable {
    
     private static final long serialVersionUID = 1L;

    private Long id;

    private String primeiroNome;

    private String ultimoNome;

    private String endereco;

    private String genero;
    
    private Date dataAniversario;
    
    
    

    public PessoaVOV2(Long id, String primeiroNome, String ultimoNome, String endereco, String genero, Date dataAniversario) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.endereco = endereco;
        this.genero = genero;
        this.dataAniversario = dataAniversario;
    }



    public PessoaVOV2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaVOV2 other = (PessoaVOV2) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
