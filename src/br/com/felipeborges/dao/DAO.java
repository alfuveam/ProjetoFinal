/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.felipeborges.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author guest01
 */
public interface DAO <T, I extends Serializable> {
    
    T save(T entity);
    List<T> listarTodos(Class <T> classe);
    EntityManager getEntityManager();
    T buscarCodigo(Class<T> classe, I pk);
    boolean remove(Class<T> classe, I pk);
    List<T> buscarNome(String nome, Class<T> classe);
}