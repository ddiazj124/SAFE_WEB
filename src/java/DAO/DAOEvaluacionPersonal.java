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
 
    private static String sql_selectAll = "SELECT * FROM EVAL_PERSONAL";
    private static String sql_insertarProcedimiento = "CALL INSERT_EVAL_PERS(?,?,?)";
    private static String sql_insertar = "INSERT INTO EVAL_PERS (id,descripcion,rut_trabajador,id_evaluacion,id_tipo) VALUES (S_EVAL_PERS.NEXTVAL,?,?,?,?)";
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public boolean Insertar(EvaluacionPersonal e) {
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_insertar);
            ps.setString(1, e.getDescripcion());
            ps.setString(2, e.getRut_trabajador());
            ps.setInt(3, e.getId_ev());
            ps.setInt(4, e.getId_tipo());
            
            
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
        
        //EvaluacionPersonal e = new EvaluacionPersonal();
        String detalle = "Evaluacion de Supervision de Seguridad";
        String rut = "19585020-8";
        EvaluacionPersonal e = new EvaluacionPersonal(0,detalle,1,102,rut);
        DAOEvaluacionPersonal Dev = new DAOEvaluacionPersonal();
        Dev.Insertar(e);
        
    }
    
    
    
    
}
