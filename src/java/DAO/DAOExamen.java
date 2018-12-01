/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Examen;
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
public class DAOExamen {
 
    private static String sql_selectAll = "SELECT * FROM EXAMEN";
    private static String sql_insertarProcedimiento = "CALL ADM_EXAMENES(?,?,?,?)";
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public boolean Insertar(Examen e) {
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_insertarProcedimiento);
            ps.setString(1, e.getResultado());
            ps.setString(2, e.getObservacion());
            ps.setInt(3, e.getId_visita());
            ps.setString(4, e.getFecha_visita());
            
            if(ps.executeUpdate()>0){
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOExamen.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return false;
    }
    
    public ArrayList<Examen> TraerTodos() {
        try {
            ArrayList<Examen> Lexamen = new ArrayList<>();
            PreparedStatement ps;
            ps = objConn.getConn().prepareStatement("SELECT * FROM EXAMEN");
            rs = ps.executeQuery();
            while(rs.next()){
                Lexamen.add(new Examen(rs.getInt("id_examen"),rs.getString("observacion"),rs.getString("resultado"),rs.getString("fecha_visita"),rs.getInt("id_visita")));
            }
            return Lexamen;
        } catch (SQLException ex) {
            Logger.getLogger(DAOExamen.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }
    
    public static void main(String[] args) {
        
        //Evaluacion e = new Evaluacion("PruebaDesdeJava", 2, "20385652-9", "Prueba");
        //DAOEvaluacion Dev = new DAOEvaluacion();
        //Dev.Insertar(e);
        
    }
    
    
    
    
}
