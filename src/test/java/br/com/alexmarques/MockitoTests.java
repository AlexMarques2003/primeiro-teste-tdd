package br.com.alexmarques;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {

    @Mock
    List<String> lista;

    @Test
    public void primeiroTesteMockito(){

        Mockito.when( lista.size()).thenReturn(2);

        int size = lista.size();

        Assertions.assertThat(size).isEqualTo(2);
    }

    @Test
    public void exemploTesteMockitoMetodoVoid(){

        Mockito.when( lista.size()).thenReturn(2);

        int size = 0;
        if(1 == 1){
            size = lista.size();
            size = lista.size();
        }

        Mockito.verify(lista, Mockito.times(2)).size();
    }

    // Verificando se os métodos foram executados na exata ordem.
    @Test
    public void exemploTesteMockitoInorder(){

        lista.size();
        lista.add("");

        InOrder inOrder = Mockito.inOrder(lista);
        inOrder.verify(lista).size();
        inOrder.verify(lista).add("");

    }
}