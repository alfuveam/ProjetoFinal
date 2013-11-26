/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.felipeborges.controller;

import br.com.felipeborges.dao.RoupaDAO;
import br.com.felipeborges.dao.RoupaDAOImplements;
import br.com.felipeborges.produtos.Roupa;
import java.util.List;

/**
 *
 * @author guest01
 */
public class RoupaController {
        public int salvar(Roupa roupa) {
        RoupaDAO dao = new RoupaDAOImplements();
        return dao.save(roupa).getidRoupa();
    }

    public boolean remover(int IdRoupa) {
        RoupaDAO dao = new RoupaDAOImplements();
        return dao.remove(Roupa.class, IdRoupa);
    }
//Igual ao listar todos
    public List<Roupa> getRoupa() {
        RoupaDAO dao = new RoupaDAOImplements();
        return dao.listarTodos(Roupa.class);
    }

//    public List<Roupa> buscarRoupabyNome(String nome) {
//        RoupaDAO dao = new RoupaDAOImplements();
//        return dao.buscarNome(nome, Roupa.class);
//    }

    public Roupa buscarRoupabyId(int id) {
        RoupaDAO dao = new RoupaDAOImplements();
        return dao.buscarCodigo(Roupa.class, id);
    }
}
