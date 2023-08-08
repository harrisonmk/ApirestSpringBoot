package com.projeto.ApirestSpringBoot.servicos;

import com.projeto.ApirestSpringBoot.Excecao.ResourceNotFoundException;
import com.projeto.ApirestSpringBoot.data.vo.v1.PessoaVO;
import com.projeto.ApirestSpringBoot.data.vo.v2.PessoaVOV2;
import com.projeto.ApirestSpringBoot.mapper.DozerMapper;
import com.projeto.ApirestSpringBoot.mapper.customizado.PessoaMapper;
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
    
    @Autowired
    PessoaMapper pessoaMapper;

    
    
    public PessoaVO findById(Long id) {

        logger.info("Encontrar uma pessoa!");

        var entidade = pessoaRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("nenhum registro encontrado para Id"));

        return DozerMapper.parseObject(entidade, PessoaVO.class);
    }

    
    
    public List<PessoaVO> findAll() {

        logger.info("encontrando todas as pessoas!");

        return DozerMapper.parseListObjects(pessoaRepositorio.findAll(), PessoaVO.class);
    }

    
    
    public PessoaVO create(PessoaVO pessoaVo) {

        logger.info("criando uma pessoa!");

        var entidade = DozerMapper.parseObject(pessoaVo, Pessoa.class);

        var vo = DozerMapper.parseObject(pessoaRepositorio.save(entidade), PessoaVO.class);

        return vo;
    }

    
    
    public PessoaVOV2 createV2(PessoaVOV2 pessoaVo) {

        logger.info("criando uma pessoa!");

        var entidade = pessoaMapper.converteVoParaEntidade(pessoaVo);

        var vo = pessoaMapper.converteEntidadeParaVo(pessoaRepositorio.save(entidade));

        return vo;
    }

    
    
    public PessoaVO update(PessoaVO pessoa) {

        logger.info("atualizando uma pessoa!");

        Pessoa entidade = pessoaRepositorio.findById(pessoa.getId()).orElseThrow(() -> new ResourceNotFoundException("nenhum registro encontrado para Id"));

        entidade.setPrimeiroNome(pessoa.getPrimeiroNome());
        entidade.setUltimoNome(pessoa.getUltimoNome());
        entidade.setEndereco(pessoa.getEndereco());
        entidade.setGenero(pessoa.getGenero());

        var vo = DozerMapper.parseObject(pessoaRepositorio.save(entidade), PessoaVO.class);

        return vo;
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
