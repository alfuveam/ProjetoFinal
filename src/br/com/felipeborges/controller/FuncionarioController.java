package br.com.felipeborges.controller;

import br.com.felipeborges.dao.FuncionarioDAO;
import br.com.felipeborges.dao.FuncionarioDAOImplements;
import br.com.felipeborges.pessoa.Funcionario;
import java.util.List;

public class FuncionarioController {

    public int salvar(Funcionario funcionario) {
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.save(funcionario).getIdFuncionario();
    }

    public boolean remover(int id) {
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.remove(Funcionario.class, id);
    }

    public List<Funcionario> getFuncionario() {
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.listarTodos(Funcionario.class);
    }

    public List<Funcionario> buscarFuncionariobyNome(String nome) {
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.buscarNome(nome, Funcionario.class);
    }

    public Funcionario buscarFuncionariobyId(int id) {
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.buscarCodigo(Funcionario.class, id);
    }

    public boolean validaLogin(String login, String senha) {
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.procurarLogin(login, senha);
    }
}
