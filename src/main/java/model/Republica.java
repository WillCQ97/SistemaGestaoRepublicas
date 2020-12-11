package model;

import collection.MoradorDeRepublicaCollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Republica extends AbstractModel {
    private static int idCount = 0;

    private String nome;
    private LocalDate dataFundacao;
    private LocalDate dataExtincao;
    private ArrayList<String> vantagens = new ArrayList<>();
    private Endereco endereco;
    private Integer vagas;
    private String codigoEtica;
    private Double receitaColetiva = 0d;
    private final ArrayList<LancamentoValor> fluxoCaixa = new ArrayList<>();

    public List<LancamentoValor> getFluxoCaixa() {
        return fluxoCaixa;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public LocalDate getDataExtincao() {
        return dataExtincao;
    }

    public void setDataExtincao(LocalDate dataExtincao) {
        this.dataExtincao = dataExtincao;
    }

    public List<String> getVantagens() {
        return vantagens;
    }

    public void setVantagens(List<String> vantagens) {
        this.vantagens = (ArrayList<String>) vantagens;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        if (vagas <= 0) throw new IllegalArgumentException("número de vagas recebido (" + vagas + ") deve ser > 0");
        this.vagas = vagas;
    }

    public String getCodigoEtica() {
        return codigoEtica;
    }

    public void setCodigoEtica(String codigoEtica) {
        this.codigoEtica = codigoEtica;
    }

    public Double getReceitaColetiva() {
        return receitaColetiva;
    }

    public void setReceitaColetiva(Double receitaColetiva) {
        if (receitaColetiva < 0) throw new IllegalArgumentException("receita coletiva (" + receitaColetiva + ") deve ser >= 0");
        this.receitaColetiva = receitaColetiva;
    }

    public Republica() {
        this.id = ++idCount;
    }

    /**
     * Construtor padrão sem código de ética
     * @param nome Nome da república
     * @param dataFundacao Data de fundação da república
     * @param dataExtincao Data de Extinção da república
     * @param vantagens Lista de vantagens da república
     * @param endereco O Endereço da república
     * @param vagas Número de vagas totais da república
     * @param receitaColetiva Valor de saldo da república
     */
    public Republica(String nome, LocalDate dataFundacao, LocalDate dataExtincao, List<String> vantagens, Endereco endereco, Integer vagas, Double receitaColetiva) {
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.dataExtincao = dataExtincao;
        this.setVantagens(vantagens);
        this.endereco = endereco;
        setVagas(vagas);
        this.codigoEtica = "";
        setReceitaColetiva(receitaColetiva);
        this.id = ++idCount;
    }

    public Republica comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Republica comDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
        return this;
    }

    public Republica comDataExtincao(LocalDate dataExtincao) {
        this.dataExtincao = dataExtincao;
        return this;
    }

    public Republica comVantagens(List<String> vantagens) {
        this.vantagens = (ArrayList<String>) vantagens;
        return this;
    }

    public Republica comEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public Republica comVagas(Integer vagas) {
        this.vagas = vagas;
        return this;
    }

    public Republica comReceitaColetiva(Double receitaColetiva) {
        this.receitaColetiva = receitaColetiva;
        return this;
    }

    public Republica comCodigoEtica(String codigoEtica) {
        this.codigoEtica = codigoEtica;
        return this;
    }

    public void adicionarAoFluxoDeCaixa(LancamentoValor novoLancamento) {
        this.getFluxoCaixa().add(novoLancamento);
    }

    public int getVagasDisponiveis() {
        long moradores = MoradorDeRepublicaCollection
                .getMoradoresDeRepublicas()
                .stream()
                .filter(
                        moradorDeRepublica -> moradorDeRepublica.getRepublica().equals(this)
                                           && moradorDeRepublica.getAtual()
                )
                .count();

        return this.vagas - (int) moradores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Republica)) return false;
        if (!super.equals(o)) return false;

        Republica republica = (Republica) o;

        return this.id == republica.getId();
    }

    @Override
    public int hashCode() {
       return super.hashCode();
    }
}
