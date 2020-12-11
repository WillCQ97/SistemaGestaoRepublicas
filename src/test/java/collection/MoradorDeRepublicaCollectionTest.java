package collection;

import factory.MoradorDeRepublicaFactory;
import factory.PessoaFactory;
import model.MoradorDeRepublica;
import model.Pessoa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoradorDeRepublicaCollectionTest {

    @AfterEach
    void clearCollection() {
        MoradorDeRepublicaCollection.clear();
    }

    /**
     * Funçao <b>pessoaJaTemRepublica()</b>
     * Deve retornar <b>Verdadeiro</b> caso uma pessoa já esteja associada a uma república
     */
    @Test
    void CT012() {
        Pessoa pessoa = PessoaFactory.createPessoa();
        MoradorDeRepublica morador = MoradorDeRepublicaFactory.createMoradorDeRepublica(pessoa);

        MoradorDeRepublicaCollection.addMoradorDeRepublica(morador);

        boolean resultado = MoradorDeRepublicaCollection.pessoaJaTemRepublica(pessoa);

        assertTrue(resultado);
    }

    /**
     * Funçao <b>pessoaJaTemRepublica()</b>
     * Deve retornar <b>Falso</b> caso uma pessoa não esteja associada a uma república
     */
    @Test
    void CT013() {
        Pessoa pessoa1 = PessoaFactory.createPessoa();
        MoradorDeRepublica morador = MoradorDeRepublicaFactory.createMoradorDeRepublica(pessoa1);

        Pessoa pessoa2 = PessoaFactory.createPessoa();

        MoradorDeRepublicaCollection.addMoradorDeRepublica(morador);

        boolean resultado = MoradorDeRepublicaCollection.pessoaJaTemRepublica(pessoa2);

        assertFalse(resultado);
    }

    /**
     * Funçao <b>pessoaJaTemRepublica()</b>
     * Deve retornar <b>Falso</b> caso uma pessoa tenha uma república no histórico, mas não é atual.
     */
    @Test
    void CT014() {
        Pessoa pessoa = PessoaFactory.createPessoa();
        MoradorDeRepublica morador = MoradorDeRepublicaFactory.createMoradorDeRepublica(pessoa);
        morador.setAtual(false);

        MoradorDeRepublicaCollection.addMoradorDeRepublica(morador);

        boolean resultado = MoradorDeRepublicaCollection.pessoaJaTemRepublica(pessoa);

        assertFalse(resultado);
    }

    /**
     * Funçao <b>addMoradorDeRepublica()</b>
     * Deve adicionar um novo MoradorDeRepublica à collection.
     */
    @Test
    void CT015() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublicaCollection.addMoradorDeRepublica(moradorDeRepublica);

        boolean resultado = MoradorDeRepublicaCollection.getMoradoresDeRepublicas().contains(moradorDeRepublica);
        assertTrue(resultado);
    }

    /**
     * Funçao <b>removerMoradorDeRepublica()</b>
     * Deve remover um MoradorDeRepublica da collection pelo Id
     */
    @Test
    void CT016() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublicaCollection.addMoradorDeRepublica(moradorDeRepublica);

        MoradorDeRepublicaCollection.removerMoradorDeRepublica(moradorDeRepublica.getId());

        boolean resultado = MoradorDeRepublicaCollection.getMoradoresDeRepublicas().contains(moradorDeRepublica);
        assertFalse(resultado);
    }


    /**
     * Funçao <b>removerMoradorDeRepublica()</b>
     * Deve remover um MoradorDeRepublica da collection pela referência
     */
    @Test
    void CT017() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublicaCollection.addMoradorDeRepublica(moradorDeRepublica);

        MoradorDeRepublicaCollection.removerMoradorDeRepublica(moradorDeRepublica);

        boolean resultado = MoradorDeRepublicaCollection.getMoradoresDeRepublicas().contains(moradorDeRepublica);
        assertFalse(resultado);
    }
}