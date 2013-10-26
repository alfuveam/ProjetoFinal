/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.felipeborges.dao;

import br.com.felipeborges.model.Pais;

/**
 *
 * @author guest01
 */
public class PaisDAOJDBC implements PaisDAO {

    private static final String INSERT = "insert into pais (nome, sigla) values (?,?);";
    private static final String DELETE = "delete from pais where id_pais = ?";
    private static final String UPDATE = "update pais set nome = ?, sigla = ?/;";

    @Override
    public int salvar(Pais p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
