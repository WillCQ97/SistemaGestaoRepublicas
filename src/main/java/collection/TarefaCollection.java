package collection;

import model.MoradorDeRepublica;
import model.Tarefa;
import model.TipoTarefaEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TarefaCollection {

    private TarefaCollection() {

    }

    private static final TreeSet<Tarefa> TAREFAS = new TreeSet<>();

    public static void addTarefa(Tarefa novaTarefa) {
        TAREFAS.add(novaTarefa);
    }

    public static void removerTarefa(Tarefa tarefa) {
        TAREFAS.remove(tarefa);
    }

    public static List<Tarefa> listarTarefas() {
        return new ArrayList<>(TAREFAS);
    }

    public static List<Tarefa> listarTarefasPorTipo(String tipo) {
            return
                TAREFAS
                .stream()
                .filter(tarefa -> TipoTarefaEnum.valueOf(tipo.toUpperCase()) == tarefa.getTipoTarefa())
                .collect(
                        Collectors
                        .toCollection(ArrayList::new)
                );

    }

    public static List<Tarefa> getReclamacoesDeMorador(MoradorDeRepublica moradorDeRepublica) {
        return listarTarefasDeMoradorPorTipo(moradorDeRepublica,"RECLAMACAO");
    }

    public static List<Tarefa> getTarefasComunsDeMorador(MoradorDeRepublica moradorDeRepublica) {
        return listarTarefasDeMoradorPorTipo(moradorDeRepublica, "COMUM");
    }

    private static List<Tarefa> listarTarefasDeMoradorPorTipo(MoradorDeRepublica moradorDeRepublica, String tipo) {
        List<Tarefa> reclamacoes = TarefaCollection.listarTarefasPorTipo(tipo);

        return  reclamacoes
                .stream()
                .filter(tarefa -> tarefa.getResponsaveis().contains(moradorDeRepublica))
                .collect(Collectors
                .toCollection(ArrayList::new));
    }


}
