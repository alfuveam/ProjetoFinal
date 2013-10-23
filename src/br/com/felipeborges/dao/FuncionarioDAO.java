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
     
     void atualizar (Funcionario funcionario);
     
     void remover(int id);
     //type the list dont take parameters
     List<Funcionario> getfuncionario();
     
     List<Funcionario> FuncionariobyNome(String nome);
     
     Funcionario getFuncionariobyId(int id);
    }

