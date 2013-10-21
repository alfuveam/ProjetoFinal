package br.com.felipeborges.controller;

import br.com.felipeborges.dao.FuncionarioDAO;
import br.com.felipeborges.dao.FuncionarioDAOJDBC;
import br.com.modelo.pessoa.Funcionario;

public class FuncionarioController {
    
    public void inserir(Funcionario funcionario){
    FuncionarioDAO dao = new FuncionarioDAOJDBC();
    dao.inserir(Funcionario);
    }
    
    public void atualizar(Funcionario funcionario){
    FuncionarioDAO dao = new FuncionarioDAOJDBC();
    dao.atualizar(Funcionario);
    }
}
