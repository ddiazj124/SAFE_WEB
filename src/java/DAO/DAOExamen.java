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
    private static String sql_insert = "INSERT INTO EXAMEN(id_examen,observacion,resultado,fecha_visita,id_visita) VALUES(S_EXAMEN.nextval,?,?,?,?)";
    private static String sql_selectAllAsc = "SELECT * FROM EXAMEN order by id_examen";
    private static String sql_buscarExamen = "SELECT * FROM EXAMEN WHERE ID_EXAMEN = ?";
    private static String TraerTodoExamenX = "SELECT E.* FROM EXAMEN E INNER JOIN VISITA_MED VM ON VM.ID_VISITA = E.ID_VISITA INNER JOIN MEDICO M ON M.RUT_MEDICO = VM.RUT_MEDICO WHERE M.RUT_MEDICO = ?";
    private static String sql_insertarProcedimiento = "CALL ADM_EXAMENES(?,?,?,?)";
    private static String sql_updateExamenMed = "UPDATE EXAMEN SET OBSERVACION = ?, RESULTADO = ? WHERE ID_EXAMEN = ?";
    
    
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public boolean Insertar(Examen e) {
        try {
            PreparedStatement ps;
            
            ps = objConn.getConn().prepareStatement(sql_insert);
            
            ps.setString(1, e.getObservacion());
            ps.setString(2, e.getResultado());
            ps.setString(3, e.getFecha_visita());
            ps.setInt(4, e.getId_visita());
            
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
    
       public ArrayList<Examen> TraerTodosAsc() {
        try {
            ArrayList<Examen> Lexamen = new ArrayList<>();
            PreparedStatement ps;
            ps = objConn.getConn().prepareStatement(sql_selectAllAsc);
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
    
    
        public Examen BuscarXExamen(int v_id){
        PreparedStatement pst = null;
        
        Examen e = new Examen();
        try {
            pst = objConn.getConn().prepareStatement(sql_buscarExamen);
            pst.setInt(1, v_id);
            rs = pst.executeQuery();
            
            if(rs.next()){
            e = new Examen(rs.getInt("id_examen"),rs.getString("observacion"),rs.getString("resultado"),rs.getString("fecha_visita"),rs.getInt("id_visita"));
            return e;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;
    }
    
    
    
    public ArrayList<Examen> TraerExamenMedXRut(String rut_medico) {
        try {
            ArrayList<Examen> Lexamen = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(TraerTodoExamenX);
            ps.setString(1, rut_medico);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Lexamen.add(new Examen(rs.getInt("id_examen"),rs.getString("observacion"),rs.getString("resultado"),rs.getString("fecha_visita"),rs.getInt("id_visita")));
                }
            return Lexamen; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }
    public boolean ActualizarExamenMedX(Examen e){
        try {
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_updateExamenMed);
            ps.setString(1, e.getObservacion());
            ps.setString(2, e.getResultado());
            ps.setInt(3, e.getId_examen());
            
            rs = ps.executeQuery();
            
            if (rs.rowUpdated()) {
                return true; 
            }
            
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return false;
    }
    

    
    public static void main(String[] args) {
        
        Examen e = new Examen(1, "Prueba", "Prueba2");
        DAOExamen dao = new DAOExamen();
        
        dao.ActualizarExamenMedX(e);
        
    }
    
    
}
