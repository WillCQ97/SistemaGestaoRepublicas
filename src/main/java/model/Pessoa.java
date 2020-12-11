package model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa extends AbstractModel {
    private static int idCount = 0;

    private String nome;
    private String apelido;
    private String telefone;
    private String linkRedeSocial;
    private ArrayList<String> numeroResponsaveis = new ArrayList<>(2);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLinkRedeSocial() {
        return linkRedeSocial;
    }

    public void setLinkRedeSocial(String linkRedeSocial) {
        this.linkRedeSocial = linkRedeSocial;
    }

    public List<String> getNumeroResponsaveis() {
        return numeroResponsaveis;
    }

    public void setNumeroResponsaveis(List<String> numeroResponsaveis) {
        this.numeroResponsaveis = (ArrayList<String>) numeroResponsaveis;
    }

    public Pessoa(String nome, String apelido, String telefone, String linkRedeSocial, String numeroResponsavel1, String numeroResponsavel2) {
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.linkRedeSocial = linkRedeSocial;
        this.numeroResponsaveis.add(numeroResponsavel1);
        this.numeroResponsaveis.add(numeroResponsavel2);
        this.id = ++idCount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        if (!super.equals(o)) return false;

        Pessoa pessoa = (Pessoa) o;
        return pessoa.id == this.id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
