package br.com.modelo.pessoa;

import java.util.Date;

public class Pessoa {

    private String nome;
    private Date dataNasci;
    private String rg;
    private String cpf;
    private String endereco;
    private int id;

    public Pessoa() {
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    private String telefone;
    private String celular;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasci() {
        return dataNasci;
    }

    public void setDataNasci(Date dataNasci) {
        this.dataNasci = dataNasci;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", dataNasci=" + dataNasci + ", rg=" + rg + ", cpf=" + cpf + ", endereco=" + endereco + ", id=" + id + ", telefone=" + telefone + ", celular=" + celular + '}';
    }
}
