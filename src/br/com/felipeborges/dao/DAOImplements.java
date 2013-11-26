/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.felipeborges.dao;



import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author guest01
 */
public abstract class DAOImplements <T, I extends Serializable> implements DAO<T, I>{

   private ConnectionFactory conexao;
    
    public T save(T entity) {
        T save = null;
        getEntityManager().getTransaction().begin();
        save = getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
        return save;
    }

    @Override
    public List<T> listarTodos(Class<T> classe) {
        return getEntityManager().createQuery("select x from " + classe.getSimpleName() + " x").getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        if(conexao == null){
            conexao = new ConnectionFactory();
        }
        return conexao.getEntityManager();
    }

    @Override
    public T buscarCodigo(Class<T> classe, I pk) {
        try{
            return getEntityManager().find(classe, pk);
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public boolean remove(Class<T> classe, I pk) {
        T entity = getEntityManager().find(classe, pk);
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(entity);
        getEntityManager().getTransaction().commit();
        return true;
    }
    
    public List<T> buscarNome(String nome, Class<T> classe){
        System.out.println("Chegou");
        Query q = getEntityManager().createQuery("select a from " + classe.getSimpleName() + " a where a.nome like '%" + nome + "%'", classe);
        List<T> list = q.getResultList();
        return q.getResultList();
    }
}