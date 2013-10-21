//Pacotes
package br.com.felipeborges.dao;
//Impotações
import br.com.modelo.pessoa.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe que implementa os métodos CRUD da interface FuncionarioDAO
 *
 * @author Felipe Borges
 * @version 1.0 18/10/2013
 */
public class FuncionarioDAOJDBC implements FuncionarioDAO {

    private final String INSERT = "insert into funcionario(ctps, login, senha, login, nome, dataNasci, rg, cpf, endereco) values (?,?,?,?,?,?,?,?,?);";
    private final String UPDATE = "update funcionarios set ctps = ?, login = ?, senha = ?, nome = ?, dataNasci = ? , rg = ?, cpf = ? , endereco = ?";
    /**
     * Método que faz a inserção de pessoas na base de dados
     *
     * @param funcionario
     */
    public void inserir(Funcionario funcionario) {
        if (funcionario != null) {
            Connection conn = null;
            try {
                
                conn = ConnectionFactory.getConnection();
                PreparedStatement pstm = null;
                pstm = ConnectionFactory.getConnection().prepareStatement(INSERT);

                //Pega os dados que estão no objeto passado por parametro e coloca na instrução de retorno
                pstm.setString(1, funcionario.getCpf());
                pstm.setString(2, funcionario.getCtps());
                pstm.setString(3, funcionario.getRg());
                pstm.setDate(4, new java.sql.Date(funcionario.getDataNasci().getTime()));
                pstm.setString(6, funcionario.getLogin());
                pstm.setString(7, funcionario.getSenha());
                pstm.setString(8, funcionario.getNome());
                pstm.setString(9, funcionario.getEndereco());
                
                //Executa o comando sql
                
                pstm.executeQuery();
                JOptionPane.showMessageDialog(null,"Funcionario cadastrado com sucesso!");
                ConnectionFactory.closeConnection(conn, pstm);
            } catch (SQLException e) {
                System.out.println("Erro ao enserir pessoa no banco de dados\n" + e.getMessage());
            }
        }
    }
    /**
     * Método que faz a atualização de pessoas na base de dados
     * @param funcionario 
     */
    public void atualizar(Funcionario funcionario) {
        Connection conn = null;
        if(funcionario ! = null){
        try{
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = null;
            pstm = ConnectionFactory.getConnection().prepareStatement(UPDATE);
            //Pega os dados que estão no objeto passado por parametro
            pstm.setString(1, funcionario.getCelular());
            pstm.setString(2, funcionario.getCpf());
            pstm.setString(3, funcionario.getCtps());
            pstm.setString(4, funcionario.getEndereco());
            pstm.setString(5, funcionario.getLogin());
            pstm.setString(6, funcionario.getNome());
            pstm.setString(7, funcionario.getRg());
            pstm.setString(8, funcionario.getSenha());
            pstm.setString(9, funcionario.getTelefone());
            pstm.setInt(10, funcionario.getId_funcionario());
            //Executa o comando sql
            pstm.execute();
            //Mensagem na tela
            JOptionPane.showMessageDialog(null, "Funcionario foi atualizado com sucesso!");
            //Fecha a conexão
            ConnectionFactory.closeConnection(conn, pstm);
        }catch(SQLException e){
            System.out.println("Erro ao atualizar o funcionario no banco de dados\n" + e.getMessage());
        }
       }
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getfuncionario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getFuncionariobyNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Funcionario getFuncionariobyId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
