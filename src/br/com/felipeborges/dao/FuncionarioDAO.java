/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.felipeborges.dao;

import br.com.modelo.pessoa.Funcionario;
import java.util.List;

/**
 *
 * @author guest01
 */
public interface FuncionarioDAO {
     void inserir(Funcionario funcionario);
     
     int atualizar (Funcionario funcionario);
     
     boolean remover(int id);
     //type the list dont take parameters
     List<Funcionario> getfuncionario();
     
     List<Funcionario> getFuncionariobyNome(String nome);
     
     Funcionario getFuncionariobyId(int id);
     
     boolean validaLogin(String login, String senha);
    }