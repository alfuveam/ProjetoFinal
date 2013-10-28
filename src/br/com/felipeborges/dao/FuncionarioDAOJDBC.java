//Pacotes
package br.com.felipeborges.dao;
//Impotações
import br.com.felipeborges.pessoa.Funcionario;
import java.util.List;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 * Classe que implementa os métodos CRUD da interface FuncionarioDAO
 *
 * @author Felipe Borges
 * @version 1.0 18/10/2013
 */
public class FuncionarioDAOJDBC implements FuncionarioDAO {

    private final String INSERT = "insert into funcionario(celular, cpf, ctps, endereco, login, nome, rg, senha, sexo, telefone, dataNasci) values (?,?,?,?,?,?,?,?,?,?,?);";
    private final String UPDATE = "update funcionario set celular = ?, cpf = ?, ctps = ?, endereco = ?, login = ?, nome = ?, rg = ?, senha = ?, sexo = ?, telefone = ?, dataNasci = ? where id_funcionario = ?";
    private final String DELETE = "delete from funcionario where id_funcionario = ?;";
    private final String LIST = "select * from Funcionario;";
    private final String LIST_NOME = "select * from funcionario where nome like ?";
    private final String LIST_ID = "select * from funcionario where id_funcionario = ?";
    private final String VERIFICALOGIN = "select login, senha from funcionario where login = ? and senha= ?";
    private String LISTBYVARIABLE = "select * from ?;";
     /**
     * Método que faz a inserção de pessoas na base de dados
     * @param funcionario
     * @return
     */

    @Override
    public int salvar(Funcionario funcionario){
        if(funcionario.getId_funcionario() == 0){
            return inserir(funcionario);
    }else{
            return atualizar(funcionario);
        }
    }

    /**
     *
     * @param funcionario
     * @return
     */
        
    public int inserir(Funcionario funcionario) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                //Pega os dados que estão no objeto passado por parametro e coloca na instrução de retorno
                pstm.setString(1, funcionario.getCelular());
                pstm.setString(2, funcionario.getCpf());
                pstm.setString(3, funcionario.getCtps());
                pstm.setString(4, funcionario.getEndereco());
                pstm.setString(5, funcionario.getLogin());
                pstm.setString(6, funcionario.getNome());
                pstm.setString(7, funcionario.getRg());
                pstm.setString(8, funcionario.getSenha());
                pstm.setString(9, funcionario.getSexo());
                pstm.setString(10, funcionario.getTelefone());
                pstm.setDate(11, new java.sql.Date(funcionario.getDataNasci().getTime()));
                pstm.execute();
                
                try (ResultSet rs = pstm.getGeneratedKeys()){
                    if(rs.next()){
                        retorno = rs.getInt(1);
                        
                    }
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao enserir:" +e);
            } finally{
                try{
                    ConnectionFactory.closeConnection(conn, pstm);
                } catch(SQLException ex){
                }
            }
//        JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso");                
            return retorno;
        }
    
    
        private int atualizar(Funcionario funcionario) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            
            //Pega os dados que estão no objeto passado por parametro
                pstm.setString(1, funcionario.getCelular());
                pstm.setString(2, funcionario.getCpf());
                pstm.setString(3, funcionario.getCtps());
                pstm.setString(4, funcionario.getEndereco());
                pstm.setString(5, funcionario.getLogin());
                pstm.setString(6, funcionario.getNome());
                pstm.setString(7, funcionario.getRg());
                pstm.setString(8, funcionario.getSenha());
                pstm.setString(9, funcionario.getSexo());
                pstm.setString(10, funcionario.getTelefone());
                pstm.setDate(11, new java.sql.Date(funcionario.getDataNasci().getTime()));
                pstm.setInt(12, funcionario.getId_funcionario());
            //Executa o comando sql
            pstm.execute();
            retorno = funcionario.getId_funcionario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar os dados do Funcionário " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão");
            }
        }
        return retorno;
    }

    /**
     * Método que faz a atualização de pessoas na base de dados
     *
     * @param id
     * @param funcionario
     * @return 
     */

    @Override
    public boolean remover(int id) {
        boolean status = false;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(DELETE);
            pstm.setInt(1, id);
            pstm.execute();
            status = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return status;
    }

    @Override
    public List<Funcionario> getfuncionario() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = (Connection) ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setCelular(rs.getString("celular"));
                f.setLogin(rs.getString("login"));
                f.setCpf(rs.getString("cpf"));
                f.setCtps(rs.getString("ctps"));
                f.setDataNasci(rs.getDate("dataNasci"));
                f.setEndereco(rs.getString("endereco"));
                f.setId_funcionario(rs.getInt("id_funcionario"));
                f.setNome(rs.getString("nome"));
                f.setRg(rs.getString("rg"));
                f.setSenha(rs.getString("senha"));
                f.setTelefone(rs.getString("telefone"));
                f.setSexo(rs.getString("sexo"));

                funcionarios.add(f);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as pessoas: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return funcionarios;
    }

    @Override
    public List<Funcionario> getFuncionariobyNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST_NOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setCelular(rs.getString("celular"));
                f.setLogin(rs.getString("login"));
                f.setCpf(rs.getString("cpf"));
                f.setCtps(rs.getString("ctps"));
                f.setDataNasci(rs.getDate("dataNasci"));
                f.setEndereco(rs.getString("endereco"));
                f.setId_funcionario(rs.getInt("id_funcionario"));
                f.setNome(rs.getString("nome"));
                f.setRg(rs.getString("rg"));
                f.setSenha(rs.getString("senha"));
                f.setTelefone(rs.getString("telefone"));
                f.setSexo(rs.getString("sexo"));
                
                funcionarios.add(f);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuário" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return funcionarios;
    }

    @Override
    public Funcionario getFuncionariobyId(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Funcionario f = new Funcionario();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST_ID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                f.setCelular(rs.getString("celular"));
                f.setLogin(rs.getString("login"));
                f.setCpf(rs.getString("cpf"));
                f.setCtps(rs.getString("ctps"));
                f.setDataNasci(rs.getDate("dataNasci"));
                f.setEndereco(rs.getString("endereco"));
                f.setId_funcionario(rs.getInt("id_funcionario"));
                f.setNome(rs.getString("nome"));
                f.setRg(rs.getString("rg"));
                f.setSenha(rs.getString("senha"));
                f.setTelefone(rs.getString("telefone"));
                f.setSexo(rs.getString("sexo"));                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar o usuário" + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, pstm, rs);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + e.getMessage());
            }
        }
        return f;
    }

    @Override
    public boolean validaLogin(String login, String senha) {
        boolean autenticado = false;

        Connection conn = null;

        PreparedStatement pstm = null;

        ResultSet rs = null;
        //Funcionario funcionarios = new Funcionario();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(VERIFICALOGIN);
            pstm.setString(1, login);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao validar login ou senha: " + e.getMessage());
        }
        return autenticado;
    }


}