
package br.com.felipeborges.dao;

import br.com.felipeborges.model.Cidade;
import java.util.List;

/**
 *
 * @author Felipe
 */
public interface CidadeDAO {
    void inserir(Cidade cidade);
    void atualizar(Cidade cidade);
    void remover(int id);
    List<Cidade> getCidade();
    List<Cidade> getCidadebyNome(String nome);
    Cidade getCidadebyId(int id);
}
