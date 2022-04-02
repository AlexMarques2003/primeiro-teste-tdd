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

        pessoa.setNome("Alex");

        cadastroPessoas.adicionar(pessoa);

        Assertions.assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test(expected = PessoaSemNomeException.class)
    public void naoDeveAdicionarPessoaComNomeVazio(){
        // cenario

        // execução
        cadastroPessoas.adicionar(pessoa);
    }

    @Test
    public void deveRemoverUmaPessoa(){
        // cenário
        pessoa.setNome("Alex");
        cadastroPessoas.adicionar(pessoa);
        // execução
        cadastroPessoas.remover(pessoa);
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();

    }

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente(){
        // cenário

        // execução
        cadastroPessoas.remover(pessoa);
    }

}
