/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.TipoEvaluacion;
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
public class DAOTipoEvaluacion {
    private static String sql_selectAll = "SELECT * FROM TIPO_EVAL";

    
private static Conexion objConn = Conexion.InstanciaConn();
private ResultSet rs;

public ArrayList<TipoEvaluacion> TraerTodos() {
        try {
            ArrayList<TipoEvaluacion> LTipoEval = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAll);
            rs = ps.executeQuery();
            
            while(rs.next()){
                LTipoEval.add(new TipoEvaluacion(rs.getInt("id_tipo"), rs.getString("nombre_evaluacion")));
                
            }
            return LTipoEval; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOTipoEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }

public static void main(String[] args) {
        
        DAOTipoEvaluacion Dev = new DAOTipoEvaluacion();
        System.out.println(Dev.TraerTodos());
        
    }

}
