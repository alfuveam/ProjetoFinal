package br.com.felipeborges.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    /**
     * Classe reponsável pela conexão com o banco
     *
     * @Autor Felipe Borges Tomaz Version 1.0 18/10/2013
     */
    
    //String de conexão
    private static final String STR_CONEXAO = "jdbc:mysql://localhost:3306/";
    //Usuário
    private static final String USER = "root";
    //Senha
    private static final String PASSWORD = "";
    //Base de dados
    private static final String DATABASE = "projetocobra";

    /**
     * Método que faz a conexão com o banco de dados
     *
     * @return Connection
     * @throws SQLException
     * @thorws ClassNotFoundExceptin
     */
    //Método que pega a conexão
    public static Connection getConnection () throws SQLException{
        try{
        return DriverManager.getConnection(STR_CONEXAO + DATABASE, USER, PASSWORD);
        }catch(Exception e){
        throw new SQLException(e.getMessage());
        }
    }
        
        //Método que fecha a conexão
            
        public static void closeConnection(Connection con) throws SQLException{
            if(con != null){
                con.close();
            }
        }
        //Método que fecha o Statement
        public static void closeConnection(Connection con, Statement stmt) throws SQLException{
            if(stmt != null){
                stmt.close();
            }
            closeConnection(con);
        }
        
        //Método que fecha o ResultSet
        public static void closeConnection(Connection con, Statement stmt, ResultSet rs) throws SQLException{
            if(rs != null){
                rs.close();
            }
            closeConnection(con, stmt);
        }
}   
