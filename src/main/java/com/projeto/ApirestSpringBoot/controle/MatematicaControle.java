package com.projeto.ApirestSpringBoot.controle;

import com.projeto.ApirestSpringBoot.Excecao.UnsupportedMathOperationException;
import com.projeto.ApirestSpringBoot.conversores.ConverteNumero;
import com.projeto.ApirestSpringBoot.matematica.MatematicaSimples;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatematicaControle {

    private static final AtomicLong contador = new AtomicLong();
    private MatematicaSimples matematica = new MatematicaSimples(); 

    
    @GetMapping(value = "/soma/{numeroUm}/{numeroDois}")
    public Double soma(@PathVariable(value = "numeroUm") String numeroUm, @PathVariable(value = "numeroDois") String numeroDois) throws Exception {

        if (!ConverteNumero.EhNumero(numeroUm) || !ConverteNumero.EhNumero(numeroDois)) {
            throw new UnsupportedMathOperationException("Por favor insira um valor numerico!");
        }

        return matematica.soma(ConverteNumero.converteParaDouble(numeroUm), ConverteNumero.converteParaDouble(numeroDois));

    }

    
    @GetMapping(value = "/sub/{numeroUm}/{numeroDois}")
    public Double subtracao(@PathVariable(value = "numeroUm") String numeroUm, @PathVariable(value = "numeroDois") String numeroDois) throws Exception {

        if (!ConverteNumero.EhNumero(numeroUm) || !ConverteNumero.EhNumero(numeroDois)) {
            throw new UnsupportedMathOperationException("Por favor insira um valor numerico!");
        }

        return matematica.subtracao(ConverteNumero.converteParaDouble(numeroUm), ConverteNumero.converteParaDouble(numeroDois));

    }

    
    @GetMapping(value = "/mult/{numeroUm}/{numeroDois}")
    public Double mult(@PathVariable(value = "numeroUm") String numeroUm, @PathVariable(value = "numeroDois") String numeroDois) throws Exception {

        if (!ConverteNumero.EhNumero(numeroUm) || !ConverteNumero.EhNumero(numeroDois)) {
            throw new UnsupportedMathOperationException("Por favor insira um valor numerico!");
        }

        return matematica.mult(ConverteNumero.converteParaDouble(numeroUm), ConverteNumero.converteParaDouble(numeroDois));

    }

    
    @GetMapping(value = "/div/{numeroUm}/{numeroDois}")
    public Double divisao(@PathVariable(value = "numeroUm") String numeroUm, @PathVariable(value = "numeroDois") String numeroDois) throws Exception {

        if (!ConverteNumero.EhNumero(numeroUm) || !ConverteNumero.EhNumero(numeroDois)) {
            throw new UnsupportedMathOperationException("Por favor insira um valor numerico!");
        }

        return matematica.divisao(ConverteNumero.converteParaDouble(numeroUm), ConverteNumero.converteParaDouble(numeroDois));

    }

    
    
    @GetMapping(value = "/media/{numeroUm}/{numeroDois}")
    public Double media(@PathVariable(value = "numeroUm") String numeroUm, @PathVariable(value = "numeroDois") String numeroDois) throws Exception {

        if (!ConverteNumero.EhNumero(numeroUm) || !ConverteNumero.EhNumero(numeroDois)) {
            throw new UnsupportedMathOperationException("Por favor insira um valor numerico!");
        }

        return matematica.media(ConverteNumero.converteParaDouble(numeroUm), ConverteNumero.converteParaDouble(numeroDois));

    }
    
    
    @GetMapping(value = "/raiz/{numeroUm}")
    public Double raizQuadrada(@PathVariable(value = "numeroUm") String numeroUm) throws Exception {

        if (!ConverteNumero.EhNumero(numeroUm)) {
            throw new UnsupportedMathOperationException("Por favor insira um valor numerico!");
        }

        return matematica.raizQuadrada(ConverteNumero.converteParaDouble(numeroUm));

    }

   

}
