/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.felipeborges.controller;

import br.com.felipeborges.dao.FornecedorDAO;
import br.com.felipeborges.dao.FornecedorDAOImplements;
import br.com.felipeborges.pessoa.Fornecedor;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class FornecedorController {

    public int salvar(Fornecedor fornecedor) {
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.save(fornecedor).getIdFornecedor();
    }

    public boolean remover(int IdFornecedor) {
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.remove(Fornecedor.class, IdFornecedor);
    }
//Igual ao listar todos
    public List<Fornecedor> getFornecedor() {
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.listarTodos(Fornecedor.class);
    }

    public List<Fornecedor> buscarFornecedorbyNome(String nome) {
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.buscarNome(nome, Fornecedor.class);
    }

    public Fornecedor buscarFornecedorbyId(int id) {
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.buscarCodigo(Fornecedor.class, id);
    }
}
