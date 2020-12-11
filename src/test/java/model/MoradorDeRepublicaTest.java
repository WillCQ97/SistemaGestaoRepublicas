package model;

import factory.MoradorDeRepublicaFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MoradorDeRepublicaTest {

    /**
     * Deve retornar que pessoa é representante da república quando existe o tempo de início da administração e não finalizou
     * função <b>isRepresentante</b>
     */
    @Test
    void CT022() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        moradorDeRepublica.setInicioAdministracao(LocalDate.parse("2020-12-11"));
        moradorDeRepublica.setFimAdministracao(null);

        assertTrue(moradorDeRepublica.isRepresentante());
    }

    /**
     * Deve retornar que pessoa <b>não</b> é representante da república quando fimAdministração não é null
     * função <b>isRepresentante</b>
     */
    @Test
    void CT023() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        moradorDeRepublica.setInicioAdministracao(LocalDate.parse("2020-12-11"));
        moradorDeRepublica.setFimAdministracao(LocalDate.parse("2020-12-11"));

        assertFalse(moradorDeRepublica.isRepresentante());
    }

    /**
     * Deve retornar que pessoa <b>não</b> é representante da república quando inicioAdminitracao é null
     * função <b>isRepresentante</b>
     */
    @Test
    void CT024() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        moradorDeRepublica.setInicioAdministracao(null);
        moradorDeRepublica.setFimAdministracao(null);

        assertFalse(moradorDeRepublica.isRepresentante());
    }

    @Test
    void CT025() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        moradorDeRepublica.setInicioAdministracao(LocalDate.now());
        moradorDeRepublica.encerrarAdministracao();

        assertNotNull(moradorDeRepublica.getFimAdministracao());
    }

    @Test
    void CT026() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        Despesa despesa = new Despesa(
                1000d,
                "despesa",
                PeriodicidadeEnum.MENSAL,
                true,
                LocalDate.parse("2020-12-25")
        );

        moradorDeRepublica.adicionarDespesa(despesa);
        assertTrue(moradorDeRepublica.getRepublica().getFluxoCaixa().contains(despesa));
    }

}