package com.projeto.ApirestSpringBoot.matematica;




public class MatematicaSimples {
    

    
    public Double soma(double numeroUm, double numeroDois) {

        return numeroUm + numeroDois;

    }

    
    public Double subtracao(double numeroUm, double numeroDois) {

        return numeroUm - numeroDois;

    }

    
    public Double mult(double numeroUm, double numeroDois) {

        return numeroUm * numeroDois;

    }

    
    public Double divisao(double numeroUm, double numeroDois) {

        return numeroUm / numeroDois;

    }

    
    public Double media(double numeroUm, double numeroDois) {

        return ((numeroUm + numeroDois) / 2);

    }

    
   
    public Double raizQuadrada(double numeroUm)  {

       

        return Math.sqrt(numeroUm);

    }
    
    

}
