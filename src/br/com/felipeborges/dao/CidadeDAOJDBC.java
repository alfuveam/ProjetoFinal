/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.felipeborges.dao;

import br.com.felipeborges.model.Cidade;
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
public class CidadeDAOJDBC implements CidadeDAO {

    private final String INSERT = "insert into cidade(nome, sigla) values (?,?);";
    private final String UPDATE = "update cidade set nome = ?, sigla = ?";
    private final String DELETE = "delete from cidade where id_cidade = ?;";
    private final String LIST = "select * from cidade;";
    private final String LIST_NOME = "select * from cidade where nome like ?";
    private final String LIST_ID = "select * from cidade where id_cidade = ?";

    @Override
    public void inserir(Cidade cidade) {
        if (cidade != null) {
            Connection conn = null;
            try {
                conn = ConnectionFactory.getConnection();
                PreparedStatement pstm = null;
                pstm = ConnectionFactory.getConnection().prepareStatement(INSERT);

                pstm.setString(1, cidade.getNome());
                pstm.setString(2, cidade.getSigla());

                //Executa o comando sql
                pstm.executeQuery();
                JOptionPane.showMessageDialog(null, "Cidade cadastrada com sucesso!");
                ConnectionFactory.closeConnection(conn, pstm);
            } catch (SQLException e) {
                System.out.println("Erro ao enserir Cidade no Banco de Dados!\n" + e.getMessage());
            }
        }
    }

    /**
     *
     * @param cidade
     */
    @Override
    public void atualizar(Cidade cidade) {
        Connection conn = null;
        if (cidade != null) {
            try {
                conn = ConnectionFactory.getConnection();
                PreparedStatement pstm = null;
                pstm = ConnectionFactory.getConnection().prepareStatement(UPDATE);

                pstm.setString(1, cidade.getNome());
                pstm.setString(2, cidade.getSigla());

                pstm.execute();

                JOptionPane.showMessageDialog(null, "Cidade foi atualizado com sucesso!");
                ConnectionFactory.closeConnection(conn, pstm);
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar a Cidade no Banco de Dados\n" + e.getMessage());
            }
        }
    }

    /**
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
            String mensagem = "Você tem certeza que deseja excluir esta Cidade";
            String titulo = "Atenção!";

            int condicao = JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION);
            if (condicao == JOptionPane.YES_OPTION) {
                pstm.setInt(1, id);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "A cidade foi removidade com sucesso!");
            }
        }catch(SQLException e){
            System.out.println("Erro ao deletar a Cidade no Banco de Dados\n" + e.getMessage());
        }
    }

    @Override
    public List<Cidade> getCidade() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cidade> cidades = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while(rs.next()){
                Cidade c = new Cidade();
                c.setNome(rs.getString("nome"));
                c.setSigla(rs.getString("sigla"));
                cidades.add(c);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch(SQLException e){
            System.out.println("Erro ao listar Cidades!" + e.getMessage());
        }
        return cidades;
    }

    @Override
    public List<Cidade> getCidadebyNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cidade> cidades = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST_NOME);
            pstm.setString(1, "%" + nome+ "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                Cidade c = new Cidade();
                c.setNome(rs.getString("nome"));
                c.setSigla(rs.getString("sigla"));
                cidades.add(c);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar a Cidade!" + e.getMessage());
        } finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao fechar a Conexão!"+ e.getMessage());
            }
        }
        return cidades;
    }

    @Override
    public Cidade getCidadebyId(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cidade c = new Cidade();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST_ID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while(rs.next()){
                c.setNome(rs.getString("nome"));
                c.setSigla(rs.getString("sigla"));
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao listar Cidade!"+ e.getMessage());
        }
        return c;
    }
}