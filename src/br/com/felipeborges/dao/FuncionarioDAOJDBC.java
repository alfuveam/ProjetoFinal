//Pacotes
package br.com.felipeborges.dao;
//Impotações
import br.com.modelo.pessoa.Funcionario;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    private final String DELETE = "delete from funcionarios where id = ?;";
    private final String LIST = "select * from Funcionario;";
    private final String LIST_NOME = "select * from funcionario where nome like ?";

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
                JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso!");
                ConnectionFactory.closeConnection(conn, pstm);
            } catch (SQLException e) {
                System.out.println("Erro ao enserir pessoa no banco de dados\n" + e.getMessage());
            }
        }
    }

    /**
     * Método que faz a atualização de pessoas na base de dados
     *
     * @param funcionario
     */
    public void atualizar(Funcionario funcionario) {
        Connection conn = null;
        if (funcionario != null) {
            try {
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
            } catch (SQLException e) {
                System.out.println("Erro ao atualizar o funcionario no banco de dados\n" + e.getMessage());
            }
        }
    }

    @Override
    public void remover(int id) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement pstm = null;
            pstm = ConnectionFactory.getConnection().prepareStatement(DELETE);
            String mensagem = "Você tem ceeza que deseja excluit este funcionario?";
            String titulo = "Atenção!";

            int condicao = JOptionPane.showConfirmDialog(null, mensagem, titulo, JOptionPane.YES_NO_OPTION);
            if (condicao == JOptionPane.YES_OPTION) {
                pstm.setInt(1, id);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "O funcionario foi removido com sucesso!");
                ConnectionFactory.closeConnection(conn, pstm);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o funcionario no banco de dados\n" + e.getMessage());
        }
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
                f.setConta(rs.getString("login"));
                f.setCpf(rs.getString("cpf"));
                f.setCtps(rs.getString("ctps"));
                f.setDataNasci(rs.getDate("dataNasci"));
                f.setEndereco(rs.getString("endereco"));
                f.setId_funcionario(rs.getInt("id_funcionario"));
                f.setNome(rs.getString("nome"));
                f.setRg(rs.getString("rg"));
                f.setSenha(rs.getString("senha"));
                f.setTelefone(rs.getString("telefone"));

                funcionarios.add(f);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        } catch (SQLException e) {
            System.out.println("Erro ao listar pessoas: " + e.getMessage());
        }
        return funcionarios;
    }

    @Override
    public List<Funcionario> getFuncionariobyNome(String nome) {
        Connection conn = null;

        PreparedStatement pstm = null;

        ResultSet rs;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            conn = (Connection) ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST_NOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setCelular(rs.getString("celular"));
                f.setConta(rs.getString("login"));
                f.setCpf(rs.getString("cpf"));
                f.setCtps(rs.getString("ctps"));
                f.setDataNasci(rs.getDate("dataNasci"));
                f.setEndereco(rs.getString("endereco"));
                f.setId_funcionario(rs.getInt("id_funcionario"));
                f.setNome(rs.getString("nome"));
                f.setRg(rs.getString("rg"));
                f.setSenha(rs.getString("senha"));
                f.setTelefone(rs.getString("telefone"));
                
                funcionarios.add(f);
            }
            ConnectionFactory.closeConnection(conn, pstm, rs);
        }catch(SQLException e){
            System.out.println("Erro ao listar funcionarios: " + e.getMessage());
        }
        return funcionarios;
    }

    @Override
    public Funcionario getFuncionariobyId(int id) {
        
    }
}
