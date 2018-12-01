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
    private static String TraerTodoExamenX = "SELECT E.* FROM EXAMEN E INNER JOIN VISITA_MED VM ON VM.ID_VISITA = E.ID_VISITA INNER JOIN MEDICO M ON M.RUT_MEDICO = VM.RUT_MEDICO WHERE M.RUT_MEDICO = ?";
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


                ps = objConn.getConn().prepareStatement(sql_selectAll);
                rs = ps.executeQuery();

                while(rs.next()){
                    Lexamen.add(new Examen(rs.getInt("E.id_examen")));
                }
                return Lexamen; 

            } catch (SQLException ex) {
                Logger.getLogger(DAOPerfil.class.getName()).log(Level.SEVERE, null, ex);
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
                Lexamen.add(new Examen(rs.getInt("id_examen")));
                }
            return Lexamen; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }
    

    
    public static void main(String[] args) {
        
        DAOExamen daoExam = new DAOExamen();
        ArrayList<Examen> ListExam = daoExam.TraerExamenMedXRut("10001191-3");
        
        System.out.println(ListExam.size());
    }
    
    
    
    
}
