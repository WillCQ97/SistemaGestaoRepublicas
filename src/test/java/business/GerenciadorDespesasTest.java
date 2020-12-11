package business;

import factory.MoradorDeRepublicaFactory;
import model.Despesa;
import model.LancamentoValor;
import model.MoradorDeRepublica;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GerenciadorDespesasTest {

    /**
     * Função <b>lancarValorUnico()</b>
     * Deve lançar corretamente um valor único de despesa.
     */
    @Test
    void CT007() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        GerenciadorDespesas gerenciadorDespesas = new GerenciadorDespesas();

        Despesa novaDespesa = (Despesa) gerenciadorDespesas.lancarValorUnico(
                moradorDeRepublica,
                "Teste",
                1000d,
                "2020-12-17"
        );
        assertEquals(1000, moradorDeRepublica.getRepublica().getFluxoCaixa().get(0).getValor());

    }

    /**
     * Função <b>lancarValorSemanal()</b>
     * Deve lançar corretamente uma despesa semanal
     */
    @Test
    void CT008() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        GerenciadorDespesas gerenciadorDespesas = new GerenciadorDespesas();

        Despesa novaDespesa = (Despesa) gerenciadorDespesas.lancarValorSemanal(
                moradorDeRepublica,
                "Teste",
                3,
                1000d,
                "2020-12-17"
        );

        ArrayList<LancamentoValor> fluxoCaixa = moradorDeRepublica.getRepublica().getFluxoCaixa();

        assertEquals(fluxoCaixa.size(), 3);

        Despesa lancamento1 = (Despesa) fluxoCaixa.get(0);
        Despesa lancamento2 = (Despesa) fluxoCaixa.get(1);
        Despesa lancamento3 = (Despesa) fluxoCaixa.get(2);

        assertEquals(1000, lancamento1.getValor());
        assertEquals(1000, lancamento2.getValor());
        assertEquals(1000, lancamento3.getValor());

        // Todo mudar para que sejam adicionados apenas semanas nas despesas?
        assertEquals(lancamento1.getDataVencimento(), novaDespesa.getDataVencimento());
        assertEquals(lancamento2.getDataVencimento(), novaDespesa.getDataVencimento().plusMonths(1));
        assertEquals(lancamento3.getDataVencimento(), novaDespesa.getDataVencimento().plusMonths(2));

    }

    /**
     * Função <b>lancarValorMensal()</b>
     * Deve lançar corretamente uma despesa Mensal
     */
    @Test
    void CT009() {
        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        GerenciadorDespesas gerenciadorDespesas = new GerenciadorDespesas();

        Despesa novaDespesa = (Despesa) gerenciadorDespesas.lancarValorMensal(
                moradorDeRepublica,
                "Teste",
                3,
                1000d,
                "2020-12-17"
        );

        ArrayList<LancamentoValor> fluxoCaixa = moradorDeRepublica.getRepublica().getFluxoCaixa();

        assertEquals(fluxoCaixa.size(), 3);

        Despesa lancamento1 = (Despesa) fluxoCaixa.get(0);
        Despesa lancamento2 = (Despesa) fluxoCaixa.get(1);
        Despesa lancamento3 = (Despesa) fluxoCaixa.get(2);

        assertEquals(1000, lancamento1.getValor());
        assertEquals(1000, lancamento2.getValor());
        assertEquals(1000, lancamento3.getValor());

        assertEquals(lancamento1.getDataVencimento(), novaDespesa.getDataVencimento());
        assertEquals(lancamento2.getDataVencimento(), novaDespesa.getDataVencimento().plusMonths(1));
        assertEquals(lancamento3.getDataVencimento(), novaDespesa.getDataVencimento().plusMonths(2));
    }
}