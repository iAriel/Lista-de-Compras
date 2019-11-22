/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Model.Usuario;
import Connection.ConnectionFactory;
import Controller.IdUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class UsuarioDao {
    
    public void create(Usuario u) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO usuario (nome,email,senha) VALUES (?,?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar");
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public boolean checkLogin(String email, String senha) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? and senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                IdUser.setLogado(rs.getInt("id"));
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;

    }

    
     public void updateSenha(Usuario u) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE usuario SET senha = ? WHERE email = ?");
 
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getSenha());
            
            stmt.executeUpdate();
            
            
            
            JOptionPane.showMessageDialog(null, "Senha Atualizada!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        
    }
    
}
