/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ProdutoDao {
    
    public void create(Produto p) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO produto (nome,quantidade,marca) VALUES (?,?,?)");
            stmt.setString(1, p.getProduto());
            stmt.setString(2, p.getQtd());
            stmt.setString(3, p.getMarca());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Salvar");
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
}
