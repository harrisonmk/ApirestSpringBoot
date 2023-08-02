package com.projeto.ApirestSpringBoot.conversores;

public class ConverteNumero {

    
    
    public static boolean EhNumero(String numeroUm) {
        String numero;

        if (numeroUm == null) {
            return false;
        }
        numero = numeroUm.replaceAll(",", ".");

        return numero.matches("[-+]?[0-9]*\\.?[0-9]+");

    }

    
    
    public static Double converteParaDouble(String numeroUm) {

        String numero;

        if (numeroUm == null) {
            return 0D;
        }
        // BR 10,25  US 10.25

        numero = numeroUm.replaceAll(",", ".");

        if (EhNumero(numero)) {
            return Double.parseDouble(numero);
        }

        return 0D;
    }
    
    

}
