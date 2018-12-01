/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.EvaluacionTerreno;
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
public class DAOEvaluacionTerreno {
 
    private static String sql_selectAll = "SELECT * FROM EVAL_TERRENO";
    private static String sql_insertarProcedimiento = "CALL ADM_EVAL_TERRENO_TECNICO_I(?,?)";
    private static String sql_insertar = "INSERT INTO EVAL_TERRENO VALUES(S_EVAL_TERRENO.NEXTVAL,?,?,?)";
    
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public boolean Insertar(EvaluacionTerreno e) {
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_insertar);
            ps.setString(1, e.getDescripcion());
            ps.setInt(2, e.getId_tipo());
            ps.setInt(3, e.getId_evaluacion());
            
            if(ps.executeUpdate()>0){
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEvaluacionTerreno.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        //EvaluacionTerreno e = new EvaluacionTerreno(0,"Infraestructura Minera",1, 65);
        //DAOEvaluacionTerreno Dev = new DAOEvaluacionTerreno();
        //Dev.Insertar(e);
        
    }
    
    
    
    
}
