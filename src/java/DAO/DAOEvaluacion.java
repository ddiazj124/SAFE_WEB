/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Evaluacion;
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
public class DAOEvaluacion {
 
    private static String sql_selectAll = "SELECT * FROM EVALUACION";
    private static String sql_insertarProcedimiento = "CALL ADM_EVALUACION_TECNICO_I(?,?,?,?)";
    private static String sql_contarCantidadEvaluacion = "SELECT COUNT(*) FROM EVALUACION";
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public boolean Insertar(Evaluacion e) {
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_insertarProcedimiento);
            ps.setString(1, e.getTitulo());
            ps.setInt(2, e.getId_tipo());
            ps.setString(3, e.getRut_empresa());
            ps.setString(4, e.getDescripcion());
            ps.setInt(5, e.getEvaluacion_estado_id());
            
            if(ps.executeUpdate()>0){
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return false;
    }
    
    
    
    public static void main(String[] args) {
        
        //Evaluacion e = new Evaluacion("PruebaDesdeJava", 2, "20385652-9", "Prueba");
        //DAOEvaluacion Dev = new DAOEvaluacion();
        //Dev.Insertar(e);
        
        
        
    }
    
    
    
    
}
