package br.com.modelo.pessoa;

import java.util.Date;

public class Funcionario extends Pessoa {

    private String ctps;
    private String senha;
    private String conta;
    private int id;

    public Funcionario(String ctps, String senha, String conta, String nome, Date dataNasci, String rg, String cpf, String endereco, String telefone, String celular, int id) {
        super(nome, dataNasci, rg, cpf, endereco, telefone, celular);
        this.ctps = ctps;
        this.senha = senha;
        this.conta = conta;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "ctps=" + ctps + '}';
    }
}