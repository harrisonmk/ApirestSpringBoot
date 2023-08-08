package com.projeto.ApirestSpringBoot.servicos;

import com.projeto.ApirestSpringBoot.Excecao.ResourceNotFoundException;
import com.projeto.ApirestSpringBoot.modelo.Pessoa;
import com.projeto.ApirestSpringBoot.repositorio.PessoaRepositorio;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServico {

    
    
    private static final AtomicLong contador = new AtomicLong();
    private Logger logger = Logger.getLogger(PessoaServico.class.getName());

    @Autowired
    PessoaRepositorio pessoaRepositorio;
    
    public Pessoa findById(Long id) {

        logger.info("Encontrar uma pessoa!");


        return pessoaRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("nenhum registro encontrado para Id"));
    }

    
    
    public List<Pessoa> findAll() {

        logger.info("encontrando todas as pessoas!");

 

        return pessoaRepositorio.findAll();
    }

    
    public Pessoa create(Pessoa pessoa) {

        logger.info("criando uma pessoa!");

        return pessoaRepositorio.save(pessoa);
    }
    
    

    public Pessoa update(Pessoa pessoa) {

        logger.info("atualizando uma pessoa!");
        
       Pessoa entidade = pessoaRepositorio.findById(pessoa.getId()).orElseThrow(() -> new ResourceNotFoundException("nenhum registro encontrado para Id"));

       
         
        entidade.setPrimeiroNome(pessoa.getPrimeiroNome());
        entidade.setUltimoNome(pessoa.getUltimoNome());
        entidade.setEndereco(pessoa.getEndereco());
        entidade.setGenero(pessoa.getGenero());
       
        return pessoaRepositorio.save(entidade);
    }

    
    
    public void delete(Long id) {

        logger.info("apagando uma pessoa!");
        
        Pessoa entidade = pessoaRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("nenhum registro encontrado para Id"));
        
        pessoaRepositorio.delete(entidade);

    }

    
    /*
    private Pessoa mockPessoa(int i) {

        Pessoa pessoa = new Pessoa();
        pessoa.setId(contador.incrementAndGet());
        pessoa.setPrimeiroNome("Primeiro Nome: " + i);
        pessoa.setUltimoNome("Ultimo Nome: " + i);
        pessoa.setEndereco("alguns endereços no brasil " + i);
        pessoa.setGenero("Masculino");

        return pessoa;
    }
    */
    
    

}
