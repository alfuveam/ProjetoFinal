package br.com.felipeborges.pessoa;

import java.util.Date;

public class Pessoa {

    private String nome;
    private Date dataNasci;
    private String rg;
    private String cpf;
    private String endereco;
    private String sexo;

    public Pessoa() {
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }
    private int id_pessoa;

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

    public Pessoa(String nome, Date dataNasci, String rg, String cpf, String endereco, String sexo, int id_pessoa, String telefone, String celular) {
        this.nome = nome;
        this.dataNasci = dataNasci;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.sexo = sexo;
        this.id_pessoa = id_pessoa;
        this.telefone = telefone;
        this.celular = celular;
    }
}