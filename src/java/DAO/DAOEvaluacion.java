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
    private static String sql_insertarProcedimiento = "CALL INSERT_EVAL(?,?,?,?,?)";
    private static String sql_contarCantidadEvaluacion = "SELECT COUNT(*) FROM EVALUACION";
    private static String sql_EvaluacionesTecnico = "SELECT * FROM EVALUACION where rut_tecnico = ? and EVALUACION_ESTADO_ID = 1";
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public boolean Insertar(Evaluacion e) {
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_insertarProcedimiento);
            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getRut_empresa());
            ps.setString(3, e.getFecha_eval());
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

    public ArrayList<Evaluacion> TraerEvaluacionesTecnico(String rut_tecnico) {
        try {
            ArrayList<Evaluacion> Levaluacion = new ArrayList<>();
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_EvaluacionesTecnico);
            ps.setString(1,rut_tecnico);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Levaluacion.add(new Evaluacion(rs.getInt("ID_EV"),rs.getString("TITULO") ,rs.getString("RUT_EMPRESA"),rs.getString("FECHA_EVAL"),rs.getString("DESCRIPCION"),rs.getInt("EVALUACION_ESTADO_ID"),rs.getString("RUT_TECNICO"),rs.getString("RUT_INGENIERO")));                
            }
            return Levaluacion; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }
    
    
    
    public static void main(String[] args) {
        
        //Evaluacion e = new Evaluacion("PruebaDesdeJava", 2, "20385652-9", "Prueba");
        //DAOEvaluacion Dev = new DAOEvaluacion();
        //Dev.Insertar(e);
        DAOEvaluacion dao1 = new DAOEvaluacion();
        ArrayList<Evaluacion> Listvis = dao1.TraerEvaluacionesTecnico("16200739-4");
        System.out.println("Cantidad de objetos: " + Listvis.size());
        
        for (Evaluacion obj : Listvis) {
            System.out.println("ID Evaluacion: "+obj.getId_ev()+ " Titulo "+obj.getTitulo() +" Descripcion: " + obj.getDescripcion());
        }
        
        System.out.println("---------------------------------");
        
        
    }
    
    
    
    
}
