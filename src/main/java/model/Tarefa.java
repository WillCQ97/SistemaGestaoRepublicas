package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe que representa Tarefas, Sugestões e Reclamações. Cada variante dessas é representada
 * pelo TipoTarefaEnum. Os responsáveis pela tarefa estão associados pelo atributo responsáveis
 */
public class Tarefa extends AbstractModel {
    private static int idCount = 0;

    private TipoTarefaEnum tipoTarefa;
    private String descricao;
    private LocalDate dataAgendamento;
    private LocalDate prazoFinal;
    private LocalDate concluidaEm;
    private MoradorDeRepublica criadaPor;
    private HashSet<MoradorDeRepublica> responsaveis = new HashSet<>();
    private boolean excluida;

    public TipoTarefaEnum getTipoTarefa() {
        return tipoTarefa;
    }

    public Set<MoradorDeRepublica> getResponsaveis() {
        return responsaveis;
    }

    public void setTipoTarefa(TipoTarefaEnum tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalDate getPrazoFinal() {
        return prazoFinal;
    }

    public void setPrazoFinal(LocalDate prazoFinal) {
        this.prazoFinal = prazoFinal;
    }

    public LocalDate getConcluidaEm() {
        return concluidaEm;
    }

    public void setConcluidaEm(LocalDate concluidaEm) {
        this.concluidaEm = concluidaEm;
    }

    public MoradorDeRepublica getCriadaPor() {
        return criadaPor;
    }

    public void setCriadaPor(MoradorDeRepublica criadaPor) {
        this.criadaPor = criadaPor;
    }

    public boolean isExcluida() {
        return excluida;
    }

    public void setExcluida(boolean excluida) {
        this.excluida = excluida;
    }

    public Tarefa() {
        this.id = ++idCount;
    }

    public Tarefa doTipo(TipoTarefaEnum tipoTarefa) {
        this.tipoTarefa =tipoTarefa;
        return this;
    }

    public Tarefa comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Tarefa comDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
        return this;
    }

    public Tarefa comPrazoFinal(LocalDate prazoFinal) {
        this.prazoFinal = prazoFinal;
        return this;
    }

    public Tarefa concluidaEm(LocalDate concluidaEm) {
        this.concluidaEm = concluidaEm;
        return this;
    }

    public Tarefa criadaPor(MoradorDeRepublica moradorDeRepublica) {
        this.criadaPor = moradorDeRepublica;
        return this;
    }

    public Tarefa comResponsaveis(Set<MoradorDeRepublica> responsaveis) {
        this.responsaveis = (HashSet<MoradorDeRepublica>) responsaveis;
        return this;
    }

    public Tarefa excluida(boolean excluida) {
        this.excluida = excluida;
        return this;
    }

    public void addResponsavel(MoradorDeRepublica novoResponsavel) {
        this.responsaveis.add(novoResponsavel);
    }

    public void removerResponsavel(MoradorDeRepublica responsavel) {
        this.responsaveis.remove(responsavel);
    }

    public void concluirTarefa() {
        this.setConcluidaEm(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa)) return false;
        if (!super.equals(o)) return false;

        Tarefa tarefa = (Tarefa) o;
        return this.id == tarefa.getId();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
