/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;

/**
 * 
 * @author Ariel
 */
public class IdUser {
    private static int id;
    
    public IdUser(){}
    
    public static int getLogado(){
        return id;
    }
    
    public static void setLogado( int userId){
        IdUser.id = userId; 
             
    }
}
