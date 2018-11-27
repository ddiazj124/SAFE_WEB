/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.EvaluacionPersonal;
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
public class DAOEvaluacionPersonal {
 
    private static String sql_selectAll = "SELECT * FROM EVAL_TERRENO";
    private static String sql_insertarProcedimiento = "CALL INSERT_EVAL_PERS(?,?,?)";
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public boolean Insertar(EvaluacionPersonal e) {
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_insertarProcedimiento);
            ps.setString(1, e.getDescripcion());
            ps.setInt(2, e.getId_tipo());
            ps.setString(3, e.getRut_trabajador());
            
            if(ps.executeUpdate()>0){
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEvaluacionPersonal.class.getName()).log(Level.SEVERE, null, ex);
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
