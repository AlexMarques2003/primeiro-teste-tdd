package br.com.alexmarques;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CadastroPessoasTest {

    CadastroPessoas cadastroPessoas;
    Pessoa pessoa;

    @Before
    public void cadastro(){
        cadastroPessoas = new CadastroPessoas();
        pessoa = new Pessoa();
    }

    @Test
    public void deveCriarOCadastroDePessoas(){

         // Verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa(){
        cadastroPessoas.adicionar(pessoa);
        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test(expected = PessoaSemNomeException.class)
    public void naoDeveAdicionarPessoaComNomeVazio(){
        cadastroPessoas.adicionar(pessoa);
    }

}
