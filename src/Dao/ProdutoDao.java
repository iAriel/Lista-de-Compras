/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Produto;
import Controller.IdUser;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariel
 */
public class ProdutoDao {
    
    public ProdutoDao(){}
    
    public void create(Produto p) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO produto (nome,quantidade,marca,id_usuario) VALUES (?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getQuantidade());
            stmt.setString(3, p.getMarca());
            stmt.setInt(4, IdUser.getLogado());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Salvar");
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Produto> listProduct() {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<Produto>();
        
        try {
            stmt = con.prepareStatement("SELECT nome,quantidade,marca FROM produto WHERE id_usuario = ?");
            stmt.setInt(1, IdUser.getLogado());
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Produto produto = new Produto(rs.getString("nome"), rs.getString("quantidade"), rs.getString("marca"));
                
                produtos.add(produto);
            }
            
            return produtos;
                    
                    } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produtos;
    }
    
    
}
