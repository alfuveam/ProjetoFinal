package br.com.modelo.pessoa;

import java.util.Date;

public class Funcionario extends Pessoa {

    private String ctps;
    private String senha;
    private String conta;
    private int id;

    public Funcionario() {
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