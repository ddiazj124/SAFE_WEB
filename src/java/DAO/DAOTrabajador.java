/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Trabajador;
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
public class DAOTrabajador {
    
    private static String sql_selectAll = "SELECT * FROM TRABAJADOR";

    
private static Conexion objConn = Conexion.InstanciaConn();
private ResultSet rs;

public ArrayList<Trabajador> TraerTodos() {
        try {
            ArrayList<Trabajador> Ltrabajador = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAll);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Ltrabajador.add(new Trabajador(rs.getString("rut_trabajador"), rs.getInt("id_perfil"),rs.getString("rut_empresa"),rs.getString("nombre"),rs.getString("apellido")));
                
            }
            return Ltrabajador; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOTrabajador.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }
    
    
    
}
