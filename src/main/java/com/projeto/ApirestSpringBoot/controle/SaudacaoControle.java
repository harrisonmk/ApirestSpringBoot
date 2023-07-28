package com.projeto.ApirestSpringBoot.controle;

import com.projeto.ApirestSpringBoot.modelo.Saudacao;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaudacaoControle {

    private static final String template = "Hello, %s!";
    private static final AtomicLong contador = new AtomicLong();

    
    @RequestMapping("/saudacao")
    public Saudacao saudacao(@RequestParam(value = "nome", defaultValue = "world") String nome) {

        return new Saudacao(contador.incrementAndGet(), String.format(template, nome));

    }

}
