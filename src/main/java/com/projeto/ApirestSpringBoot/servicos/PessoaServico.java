package com.projeto.ApirestSpringBoot.servicos;

import com.projeto.ApirestSpringBoot.modelo.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class PessoaServico {

    
    
    private static final AtomicLong contador = new AtomicLong();
    private Logger logger = Logger.getLogger(PessoaServico.class.getName());

    
    
    public Pessoa findById(String id) {

        logger.info("Encontrar uma pessoa!");

        Pessoa pessoa = new Pessoa();
        pessoa.setId(contador.incrementAndGet());
        pessoa.setPrimeiroNome("Leandro");
        pessoa.setUltimoNome("costa");
        pessoa.setEndereco("Uberlandia - minas gerais - Brasil");
        pessoa.setGenero("Masculino");

        return pessoa;
    }

    
    
    public List<Pessoa> findAll() {

        logger.info("encontrando todas as pessoas!");

        List<Pessoa> pessoas = new ArrayList<>();

        for (int i = 0; i < 8; i++) {

            Pessoa pessoa = mockPessoa(i);
            pessoas.add(pessoa);

        }

        return pessoas;
    }

    
    public Pessoa create(Pessoa pessoa) {

        logger.info("criando uma pessoa!");

        return pessoa;
    }
    
    

    public Pessoa update(Pessoa pessoa) {

        logger.info("atualizando uma pessoa!");

        return pessoa;
    }

    
    
    public void delete(String id) {

        logger.info("apagando uma pessoa!");

    }

    
    
    private Pessoa mockPessoa(int i) {

        Pessoa pessoa = new Pessoa();
        pessoa.setId(contador.incrementAndGet());
        pessoa.setPrimeiroNome("Primeiro Nome: " + i);
        pessoa.setUltimoNome("Ultimo Nome: " + i);
        pessoa.setEndereco("alguns endereços no brasil " + i);
        pessoa.setGenero("Masculino");

        return pessoa;
    }
    
    
    

}
