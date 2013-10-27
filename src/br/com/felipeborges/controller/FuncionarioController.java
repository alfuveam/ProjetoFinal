package br.com.felipeborges.controller;

import br.com.felipeborges.dao.FuncionarioDAO;
import br.com.felipeborges.dao.FuncionarioDAOJDBC;
import br.com.modelo.pessoa.Funcionario;
import java.util.List;

public class FuncionarioController {

    public int salvar(Funcionario funcionario) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        return dao.salvar(funcionario);
    }

    public boolean remover(int id) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        return dao.remover(id);
    }

    public List<Funcionario> getFuncionario() {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        return dao.getfuncionario();
    }

    public List<Funcionario> buscarFuncionariobyNome(String nome) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        return dao.getFuncionariobyNome(nome);
    }

    public Funcionario buscarFuncionariobyId(int id) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        return (Funcionario) dao.getFuncionariobyId(id);
    }

    public boolean validaLogin(String login, String senha) {
        FuncionarioDAO dao = new FuncionarioDAOJDBC();
        return dao.validaLogin(login, senha);
    }
}
