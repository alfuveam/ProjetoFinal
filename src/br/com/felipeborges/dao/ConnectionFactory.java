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
    //Driver
    //private static final String DRIVER_CONEXAO = "com.myslq.jdbc.Driver";
    //String de conexão
    private static final String STR_CONEXAO = "jdbc.mysql://localhost:3306/";
    //Usuário
    private static final String USUARIO = "root";
    //Senha
    private static final String SENHA = "12345";
    //Base de dados
    private static final String DATABASE = "projeto_cobra";

    /**
     * Método que faz a conexão com o banco de dados
     *
     * @return Connection
     * @throws SQLException
     * @thorws ClassNotFoundExceptin
     */
    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(STR_CONEXAO + DATABASE, USUARIO, SENHA);
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    /**
     * Método que fecha a conexão com o banco de dados
     *
     * @param Connection
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
            System.out.println("Conexão fechada com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao fechar a conexão" + e.getMessage());
        }
    }

    /**
     * Método ue fecha a conexão, juntamente com o statement do banco de dados
     *
     * @param conn
     * @param stmt
     */
    public static void closeConnection(Connection conn, Statement stmt) {
        try {
            if (conn != null) {
                closeConnection(conn);
            }
            if (stmt != null) {
                stmt.close();
                System.out.println("Statement fechado com sucesso");
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel fechar o statement" + e.getMessage());
        }
    }

    /**
     * Método que fecha a conexão, Juntamente com o statement e o result set do
     * banco de dados
     *
     * @param conn
     * @param stm
     * @param rs
     */
    public static void closeConnection(Connection conn, Statement stm, ResultSet rs) {

        try {
            if (conn != null || stm != null) {
                closeConnection(conn);
            }
            if (rs != null) {
                rs.close();
                System.out.println("Result set fechado com sucesoo");
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel fechar o result set" + e.getMessage());
        }
    }
}