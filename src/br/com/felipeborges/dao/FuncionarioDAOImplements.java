//Pacotes
package br.com.felipeborges.dao;
//Impotações

import br.com.felipeborges.pessoa.Funcionario;
import java.util.List;
import javax.persistence.Query;

/**
 * Classe que implementa os métodos CRUD da interface FuncionarioDAO
 *
 *
 * @author Felipe Borges
 * @version 1.0 18/10/2013
 */
public class FuncionarioDAOImplements extends DAOImplements<Funcionario, Integer> implements FuncionarioDAO {

    @Override
    public boolean procurarLogin(String login, String senha) {
        Query q = getEntityManager().createQuery("select a from Funcionario a where a.senha = '" + senha + "' and a.login = '" + login + "'");
        List<Funcionario> funcionarios = q.getResultList();
        for (Funcionario a : funcionarios) {
            return true;
        }
        return false;
    }
}