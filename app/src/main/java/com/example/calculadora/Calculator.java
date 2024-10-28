package com.example.calculadora;

/**
 * Clase para implementar operaciones de la calculadora
 * @author Pablo Rodríguez Manrique
 * @version 1.1
 **/
public class Calculator {

    /**
     * Constructor de la clase
     */
    public Calculator() {
    }

    /**
     * Función para realizar operaciones de la calculadora (suma y multiplicación)
     * @param input Cadena de texto que contiene la operación a realizar
     * @return Resultado de la operación
     */
    public int calculate(String input) {
        // Si no hay un símbolo '+' o '*' en la cadena, conviértelo en número
        if (!input.contains("+") && !input.contains("*")) {
            return Integer.parseInt(input.trim());

        } else if (input.contains("+")) {
            // Dividimos la cadena en dos partes
            int plusIndex = input.indexOf('+'); // Encuentra el primer '+'
            String left = input.substring(0, plusIndex); // Parte izquierda
            String right = input.substring(plusIndex + 1); // Parte derecha

            return calculate(left) + calculate(right); //llamada recursiva
        } else {
            // Dividimos la cadena en dos partes
            int multIndex = input.indexOf('*'); // Encuentra el primer '*'
            String left = input.substring(0, multIndex); // Parte izquierda
            String right = input.substring(multIndex + 1); // Parte derecha

            return calculate(left) * calculate(right); //llamada recursiva
        }
    }
}
