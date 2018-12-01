/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Respuesta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class DAORespuesta {
    private static String sql_insertar = "INSERT INTO RESPUESTA(?,?,?)";
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public boolean Insertar(Respuesta resp) {
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_insertar);
            ps.setInt(1, resp.getIdRespuesta());
            ps.setInt(2, resp.getIdPregunta());
            ps.setString(3, resp.getDetalleRespuesta());
            
            if(ps.executeUpdate()>0){
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAORespuesta.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return false;
    }
}
