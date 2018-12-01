/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Ingeniero;
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
public class DAOIngeniero {
    private static String sql_selectAll = "SELECT * FROM Ingeniero";

    
private static Conexion objConn = Conexion.InstanciaConn();
private ResultSet rs;

public ArrayList<Ingeniero> TraerTodos() {
        try {
            ArrayList<Ingeniero> Lingeniero = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAll);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Lingeniero.add(new Ingeniero(rs.getString("rut_ingeniero"),rs.getInt("id_perfil") ,rs.getString("nombre"),rs.getString("apellido")));                
            }
            return Lingeniero; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngeniero.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }

public static void main(String[] args) {
        
       DAOIngeniero dao1 = new DAOIngeniero();
       ArrayList<Ingeniero> Listvis = dao1.TraerTodos();
        System.out.println("Cantidad de objetos: " + Listvis.size());
        
        for (Ingeniero obj : Listvis) {
            System.out.println("RUT: "+obj.getRut_ingeniero()+ " NOMBRE: " + obj.getNombre() + " Apellido"+obj.getApellido());
        }
        
        System.out.println("---------------------------------");
    }

}
