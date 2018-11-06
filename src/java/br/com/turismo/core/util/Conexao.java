/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.turismo.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hisak
 */
public class Conexao {
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        // Define um driver de conexao com o banco.
        Class.forName("org.postgresql.Driver");
        // Abre uma conexao com o banco.
       
           Connection conn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/companhia", "postgres", "1234");
   return conn;
    }
    
}
