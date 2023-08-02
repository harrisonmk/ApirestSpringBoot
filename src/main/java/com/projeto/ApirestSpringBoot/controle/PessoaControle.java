package com.projeto.ApirestSpringBoot.controle;

import com.projeto.ApirestSpringBoot.modelo.Pessoa;
import com.projeto.ApirestSpringBoot.servicos.PessoaServico;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/pessoa")
public class PessoaControle {

    @Autowired
    private PessoaServico pessoaServico;
    //private PessoaServico pessoaServico = new PessoaServico();

    
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa findById(@PathVariable(value = "id") String id) {

        return pessoaServico.findById(id);

    }

    
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pessoa>> findAll() {

        List<Pessoa> lista = pessoaServico.findAll();

        return ResponseEntity.ok().body(lista); // retorna o status 200 OK

    }

    
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa) {

        pessoa = pessoaServico.create(pessoa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa); //retorna 201 que é de criacao (created) com o corpo do objeto

    }
    
    

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa update(@RequestBody Pessoa pessoa) {

        return pessoaServico.update(pessoa);

    }
    
    
    

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable(value = "id") String id) {

        pessoaServico.delete(id);

        return ResponseEntity.noContent().build(); //retorna o codigo 204 sem corpo que é da exclusao
    }

    
    
    
}
