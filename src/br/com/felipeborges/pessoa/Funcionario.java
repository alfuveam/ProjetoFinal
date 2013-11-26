package br.com.felipeborges.pessoa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Funcionario extends Pessoa {
    
    @Id
    @GeneratedValue
    private int idFuncionario;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    private String ctps;
    private String senha;
    private String login;
    private Double salario;

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Funcionario() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
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

    public Funcionario(String ctps, String senha, String login, int id_funcionario, Double salario) {
        this.ctps = ctps;
        this.senha = senha;
        this.login = login;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + idFuncionario + ", ctps=" + ctps + ", senha=" + senha + ", login=" + login + ", salario=" + salario + '}';
    }
}