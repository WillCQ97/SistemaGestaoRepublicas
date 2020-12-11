package factory;

import model.MoradorDeRepublica;
import model.Tarefa;
import model.TipoTarefaEnum;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

public class TarefaFactory {
    private static final String DESCRICAO = "Tarefa Teste";

    public static Tarefa createTarefa(String tipoTarefa, String prazoFinal, MoradorDeRepublica criadaPor, MoradorDeRepublica[] responsaveis) {
        return new Tarefa()
                .doTipo(TipoTarefaEnum.valueOf(tipoTarefa))
                .comDescricao(DESCRICAO)
                .comDataAgendamento(LocalDate.now())
                .comPrazoFinal(LocalDate.parse(prazoFinal))
                .criadaPor(criadaPor)
                .comResponsaveis(new HashSet<>(Arrays.asList(responsaveis)))
                .excluida(false);
    }

    public static Tarefa createTarefa(String tipoTarefa, String prazoFinal, String concluidaEm, MoradorDeRepublica criadaPor, MoradorDeRepublica[] responsaveis) {
        return new Tarefa()
                .doTipo(TipoTarefaEnum.valueOf(tipoTarefa))
                .comDescricao(DESCRICAO)
                .comDataAgendamento(LocalDate.now())
                .concluidaEm(LocalDate.parse(concluidaEm))
                .comPrazoFinal(LocalDate.parse(prazoFinal))
                .criadaPor(criadaPor)
                .comResponsaveis(new HashSet<>(Arrays.asList(responsaveis)))
                .excluida(false);
    }



}
