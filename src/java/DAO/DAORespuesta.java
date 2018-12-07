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
    private static String sql_insertar = "INSERT INTO RESPUESTA VALUES(S_RESPUESTAS.nextval,?,?)";
    private static String sql_update = "UPDATE EVALUACION SET EVALUACION_ESTADO_ID = 2 WHERE ID_EV = ?";
    
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public boolean Insertar(Respuesta resp) {
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_insertar);
            ps.setInt(1, resp.getIdPregunta());
            ps.setString(2, resp.getDetalleRespuesta());
            
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
    
    public boolean update(int id_ev) {
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_update);
            ps.setInt(1, id_ev);
            
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
