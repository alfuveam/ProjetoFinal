package br.com.modelo.pessoa;

import java.util.Date;

public class Funcionario extends Pessoa {

    private String ctps;
    private String senha;
    private String login;
    private int id_funcionario;

    public Funcionario() {
    }

    public String getLogin() {
        return login;
    }

    public void setConta(String login) {
        this.login = login;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "ctps=" + ctps + '}';
    }
}