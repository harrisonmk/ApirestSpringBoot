
package com.projeto.ApirestSpringBoot.repositorio;

import com.projeto.ApirestSpringBoot.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa,Long> {
    
}
