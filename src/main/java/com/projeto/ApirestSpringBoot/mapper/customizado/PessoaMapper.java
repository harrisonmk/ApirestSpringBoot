package com.projeto.ApirestSpringBoot.mapper.customizado;

import com.projeto.ApirestSpringBoot.data.vo.v2.PessoaVOV2;
import com.projeto.ApirestSpringBoot.modelo.Pessoa;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class PessoaMapper {

    
    
    public PessoaVOV2 converteEntidadeParaVo(Pessoa pessoa) {

        PessoaVOV2 vo = new PessoaVOV2();
        vo.setId(pessoa.getId());
        vo.setPrimeiroNome(pessoa.getPrimeiroNome());
        vo.setUltimoNome(pessoa.getUltimoNome());
        vo.setEndereco(pessoa.getEndereco());
        vo.setGenero(pessoa.getGenero());
        vo.setDataAniversario(new Date());

        return vo;
    }

    
    
    public Pessoa converteVoParaEntidade(PessoaVOV2 pessoa) {

        Pessoa entidade = new Pessoa();
        entidade.setId(pessoa.getId());
        entidade.setPrimeiroNome(pessoa.getPrimeiroNome());
        entidade.setUltimoNome(pessoa.getUltimoNome());
        entidade.setEndereco(pessoa.getEndereco());
        entidade.setGenero(pessoa.getGenero());
        //entidade.setDataAniversario(new Date());

        return entidade;
    }

}
