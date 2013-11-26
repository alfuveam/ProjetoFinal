/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.felipeborges.controller;

import br.com.felipeborges.dao.CidadeDAO;
import br.com.felipeborges.dao.CidadeDAOImplements;
import br.com.felipeborges.model.Cidade;
import java.util.List;

/**
 *
 * @author Felipe
 */
public class CidadeController {
        public int salvar(Cidade cidade) {
        CidadeDAO dao = new CidadeDAOImplements();
        return dao.save(cidade).getCd_cidade();
    }

    public boolean remover(int id) {
        CidadeDAO dao = new CidadeDAOImplements();
        return dao.remove(Cidade.class, id);
    }

    public List<Cidade> getCidade() {
        CidadeDAO dao = new CidadeDAOImplements();
        return dao.listarTodos(Cidade.class);
    }

    public List<Cidade> buscarCidadebyNome(String nome) {
        CidadeDAO dao = new CidadeDAOImplements();
        return dao.buscarNome(nome, Cidade.class);
    }

    public Cidade buscarCidadebyId(int id) {
        CidadeDAO dao = new CidadeDAOImplements();
        return dao.buscarCodigo(Cidade.class, id);
    }
}
