/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ariel
 */
public class ConnectionFactory {
    private final String DRIVER = "com.mysql.jdbc.driver";
    //chamando o BD
    private final String URL = "jdbc:mysql:localhost:3306/atividade";
    private final String USER = "root";
    private final String PASS = "";
    
    public Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
