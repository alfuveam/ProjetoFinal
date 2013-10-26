/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.felipeborges.dao;

import br.com.felipeborges.model.Estado;
import java.util.List;

/**
 *
 * @author Felipe
 */
public interface EstadoDAO {
    /**
     * Método para inserir um novo estado no banco de dados
     * @param estado 
     */
    void inserir(Estado estado);
    /**
     * 
     * @param estado 
     */
    void atualizar(Estado estado);
    /**
     * 
     * @param id 
     */
    void remover(int id);
    /**
     * 
     * @return 
     */
    List<Estado> getEstado();
    /**
     * 
     * @param nome
     * @return 
     */
    List<Estado> getEstadobyNome(String nome);
    /**
     * 
     * @param id
     * @return 
     */
    Estado getEstadobtId(int id);
}
