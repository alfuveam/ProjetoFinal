/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.felipeborges.dao;

import br.com.felipeborges.model.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class EstadoDAOJDBC implements EstadoDAO {

    private final String INSERT = "insert into estado(nome, sigla) values (?,?);";
    private final String UPDATE = "update estado set nome = ? , sigla = ?";
    private final String DELETE = "delete from estado where id_estado = ?;";
    private final String LIST = "select * from estado;";
    private final String LIST_NOME = "select * from estado where nome like ?";
    private final String LIST_ID = "select * from estado where id_estado = ?";

    /**
     * Método que faz a inserção de estado no banco de dados
     *
     * @param estado
     */
    @Override
    public void inserir(Estado estado) {
        if (estado != null) {
            Connection conn = null;
            try {
                conn = ConnectionFactory.getConnection();
                PreparedStatement pstm = null;
                pstm = ConnectionFactory.getConnection().prepareStatement(INSERT);

                //Pega os dados que estão no objeto passado por parametro e coloca na instruição de retorno
                pstm.setString(1, estado.getNome());
                pstm.setString(2, estado.getSigla());

                pstm.executeQuery();
                JOptionPane.showMessageDialog(null, "Estado cadastrado com sucesso!");
                ConnectionFactory.closeConnection(conn, pstm);
            } catch (SQLException e) {
                System.out.println("Erro ao enserir Estado no banco de dados \n" + e.getMessage());
            }
        }
    }

    /**
     * Método que faz a atualização de Estado no Banco de Dados.
     *
     * @param estado
     */

    @Override
    public void atualizar(Estado estado) {
        Connection conn = null;
        if (estado != null) {
            try {
                conn = ConnectionFactory.getConnection();
                PreparedStatement pstm = null;
                pstm = ConnectionFactory.getConnection().prepareStatement(UPDATE);
                pstm.setString(1, estado.getNome());
                pstm.setString(2, estado.getSigla());

                pstm.execute();
                JOptionPane.showMessageDialog(null, "Estado foi atualizado com sucesso!");
                ConnectionFactory.closeConnection(conn, pstm);
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar o Estado!\n" + e.getMessage());
            }
        }
    }

    /**
     * Método para remover a informação do Bando de Dados
     *
     * @param id
     */
    @Override
    public void remover(int id) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = null;
            pstm = ConnectionFactory.getConnection().prepareStatement(DELETE);
            String mensagem = "Você deseja realmente Excluir o Estado?";
            String titulo = "Atenção!";

            int condicao = JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION);
            if (condicao == JOptionPane.YES_OPTION) {
                pstm.setInt(1, id);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "O estado foi removido com sucesso!");
                ConnectionFactory.closeConnection(conn, pstm);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o Estado!\n" + e.getMessage());
        }
    }

    /**
     * Método para chamar o estado do Banco de Dados!
     *
     * @return
     */
    @Override
    public List<Estado> getEstado() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Estado> estados = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Estado s = new Estado();
                s.setNome(rs.getString("nome"));
                s.setSigla(rs.getString("sigla"));
                estados.add(s);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch(SQLException e){
            System.out.println("Erro ao listar Estado!" + e.getMessage());
        }
        return estados;
    }

    @Override
    public List<Estado> getEstadobyNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Estado> estados = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST_NOME);
            pstm.setString(1, "%" +nome+ "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                Estado s = new Estado();
                s.setNome(rs.getString("nome"));
                s.setSigla(rs.getString("sigla"));
                estados.add(s);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar Estados!"+e.getMessage());
        } finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            } catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return estados;
    }
/**
 * Método que vai listar os estados pela ID
 * @param id
 * @return 
 */
    @Override
    public Estado getEstadobtId(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Estado s = new Estado();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST_ID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while(rs.next()){
                s.setNome(rs.getString("nome"));
                s.setSigla(rs.getString("sigla"));
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao listar Pessoas !"+e.getMessage());
        } finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            } catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return s;
    }

}
