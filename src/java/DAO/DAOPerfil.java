/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class DAOPerfil {
private static String sql_selectAll = "SELECT * FROM PERFIL";

    
private static Conexion objConn = Conexion.InstanciaConn();
private ResultSet rs;

public ArrayList<Perfil> TraerTodos() {
        try {
            ArrayList<Perfil> Lperfil = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAll);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Lperfil.add(new Perfil(rs.getInt("id_perfil"), rs.getString("nombre_perfil")));
                
            }
            return Lperfil; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }


    public static void main(String[] args) {
        DAOPerfil perfil = new DAOPerfil();
        ArrayList<Perfil> Listperfil = perfil.TraerTodos();
        
        
        System.out.println("Cantidad de objetos :" + Listperfil.size());
        System.out.println("");
        
        for (Perfil obj : Listperfil) {
              System.out.println(obj.getId_perfil()+ " " + obj.getNombre_perfil());
        }
        
        
        
    }
    
    


}
