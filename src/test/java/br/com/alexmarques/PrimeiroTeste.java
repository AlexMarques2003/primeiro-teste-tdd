package br.com.alexmarques;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class PrimeiroTeste {
    Calculadora calculadora;
    int numero1 = 10, numero2 = 5;

    @Before
    public void setup(){
        calculadora = new Calculadora();
    }

    @Test
    public void calcularSomaDoisNumeros(){
        // Cenário

        // Execução
        int resultado = calculadora.somar(numero1, numero2);

        // Verificações

        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test
    public void deveSubtrair2Numeros(){
        int resultado = calculadora.subtrair(numero1, numero2);
        Assertions.assertThat(resultado).isEqualTo(5);
    }

    @Test
    public void deveMultiplicar2Numeros(){
        int resultado = calculadora.multiplicar(numero1, numero2);
        Assertions.assertThat(resultado).isEqualTo(50);
    }

    @Test
    public void deveDividir2Numeros(){
        float resultado = calculadora.dividir(numero1,numero2);
        Assertions.assertThat(resultado).isEqualTo(2);
    }

    @Test(expected = ArithmeticException.class)
    public void naoDeveDividirPorZero(){
        int numero1 = 10, numero2 = 0;
        calculadora.dividir(numero1,numero2);
    }

}

class Calculadora{
    int somar(int num1, int num2){
        if(num1 < 0 || num2 < 0 ){
           throw new RuntimeException("Não é permitido somar números negativos");
        }
        return num1 + num2;
    }

    int subtrair(int num1, int num2){
        if(num1 < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido subtrair números negativos");
        }
        return num1 - num2;
    }

    int multiplicar(int num1, int num2){
        if(num1 < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido multiplicar números negativos");
        }
        return num1 * num2;
    }

    float dividir(int num1, int num2){
        return num1 / num2;
    }

}