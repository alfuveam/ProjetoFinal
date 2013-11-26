/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.felipeborges.dao;

import br.com.felipeborges.pessoa.Funcionario;

/**
 *
 * @author guest01
 */
public interface FuncionarioDAO extends DAO<Funcionario, Integer> {
    boolean procurarLogin(String login, String senha);
}