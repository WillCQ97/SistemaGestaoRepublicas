package business;

import collection.TarefaCollection;
import factory.MoradorDeRepublicaFactory;
import factory.TarefaFactory;
import model.MoradorDeRepublica;
import model.Tarefa;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraIndiceTarefasTest {

    /**
     * Função <b>getIndiceRealizacaoTarefasComuns()</b>
     * Deve calcular corretamente o Índice de Realização de Tarefas de um mês específico
     */
    @Test
    void CT011() {

        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublica[] responsaveis = new MoradorDeRepublica[]{ moradorDeRepublica };

        Tarefa[] tarefas = new Tarefa[] {
                TarefaFactory.createTarefa("COMUM", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("COMUM", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("COMUM", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("COMUM", "2020-10-20", "2020-10-19", moradorDeRepublica, responsaveis),
        };

        Arrays
                .stream(tarefas)
                .iterator()
                .forEachRemaining(TarefaCollection::addTarefa);

        double indiceRealizacaoTarefas = CalculadoraIndiceTarefas.getIndiceRealizacaoTarefasComuns(moradorDeRepublica, 10, 2020);

        assertEquals(0.25d, indiceRealizacaoTarefas, 0.001);
    }

    /**
     * Função <b>getIndiceSolucaoReclamacoes()</b>
     * Deve calcular corretamente o Índice de Solução de Reclamações de um mês específico
     */
    @Test
    void CT019() {

        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublica[] responsaveis = new MoradorDeRepublica[]{ moradorDeRepublica };

        Tarefa[] tarefas = new Tarefa[] {
                TarefaFactory.createTarefa("RECLAMACAO", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("RECLAMACAO", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("RECLAMACAO", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("RECLAMACAO", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("RECLAMACAO", "2020-10-20", "2020-10-19", moradorDeRepublica, responsaveis),
        };

        Arrays
                .stream(tarefas)
                .iterator()
                .forEachRemaining(TarefaCollection::addTarefa);

        double indiceRealizacaoTarefas = CalculadoraIndiceTarefas.getIndiceSolucaoReclamacoes(moradorDeRepublica, 10, 2020);

        assertEquals(0.20d, indiceRealizacaoTarefas, 0.001);
    }

    /**
     * Função <b>getIndiceRealizacaoTarefasComuns()</b>
     * Deve calcular corretamente o Índice de Realização de Tarefas de todos os meses
     */
    @Test
    void CT020() {

        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublica[] responsaveis = new MoradorDeRepublica[]{ moradorDeRepublica };

        Tarefa[] tarefas = new Tarefa[] {
                TarefaFactory.createTarefa("COMUM", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("COMUM", "2020-10-20", "2020-10-19", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("COMUM", "2020-11-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("COMUM", "2020-11-20", "2020-11-19", moradorDeRepublica, responsaveis),
        };

        Arrays
                .stream(tarefas)
                .iterator()
                .forEachRemaining(TarefaCollection::addTarefa);

        double indiceRealizacaoTarefas = CalculadoraIndiceTarefas.getIndiceRealizacaoTarefasComuns(moradorDeRepublica);

        assertEquals(0.50d, indiceRealizacaoTarefas, 0.001);
    }

    /**
     * Função <b>getIndiceSolucaoReclamacoes()</b>
     * Deve calcular corretamente o Índice de Solução de Reclamações de todos os meses
     */
    @Test
    void CT021() {

        MoradorDeRepublica moradorDeRepublica = MoradorDeRepublicaFactory.createMoradorDeRepublica();
        MoradorDeRepublica[] responsaveis = new MoradorDeRepublica[]{ moradorDeRepublica };

        Tarefa[] tarefas = new Tarefa[] {
                TarefaFactory.createTarefa("RECLAMACAO", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("RECLAMACAO", "2020-10-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("RECLAMACAO", "2020-10-20", "2020-10-19", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("RECLAMACAO", "2020-11-20", moradorDeRepublica, responsaveis),
                TarefaFactory.createTarefa("RECLAMACAO", "2020-11-20", "2020-11-19", moradorDeRepublica, responsaveis),
        };

        Arrays
                .stream(tarefas)
                .iterator()
                .forEachRemaining(TarefaCollection::addTarefa);

        double indiceRealizacaoTarefas = CalculadoraIndiceTarefas.getIndiceSolucaoReclamacoes(moradorDeRepublica);

        assertEquals(0.40d, indiceRealizacaoTarefas, 0.001);
    }
}