/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Tecnico;
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
public class DAOTecnico {
    private static String sql_selectAll = "SELECT * FROM Tecnico";
    private static String sql_datosTecnico = "SELECT * FROM Tecnico where correo_electronico = ?";

    
private static Conexion objConn = Conexion.InstanciaConn();
private ResultSet rs;

public ArrayList<Tecnico> TraerTecnico(String email) {
        try {
            ArrayList<Tecnico> Ltecnico = new ArrayList<>();
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_datosTecnico);
            ps.setString(1,email);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Ltecnico.add(new Tecnico(rs.getString("rut_tecnico"),rs.getInt("id_perfil") ,rs.getString("nombre"),rs.getString("apellido"),rs.getString("correo_electronico")));                
            }
            return Ltecnico; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOIngeniero.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }

    public static void main(String[] args) {
        
        
        
        DAOTecnico dao = new DAOTecnico();
        ArrayList<Tecnico> Ltecnico = dao.TraerTecnico("d.diazj@alumnos.duoc.cl");
        
        System.out.println("====");
        for (Tecnico obj : Ltecnico) {
            System.out.println("Tecnico rut: "+obj.getRut_tecnico());
        }
    }
}
