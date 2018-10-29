/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Atencion;
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
public class DAOAtencionMedica {
    private static String sql_selectAll = "SELECT * FROM VISITA_MED";
    private static String sql_buscar = "SELECT * FROM VISITA_MED WHERE ID_VISITA=? AND RUT_TRABAJADOR =? AND RUT_MEDICO = ?";
    private static String sql_update = "UPDATE visita_med SET fecha_visita = ?, observaciones = ?, diagnostico = ?, receta = ? WHERE id_visita = ?;";
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    
    public boolean Actualizar(int v_nvisita, String v_fecha_visita, String v_observaciones, String v_diagnostico,String v_receta){
        
        PreparedStatement pst = null;
        try {
            pst = objConn.getConn().prepareStatement(sql_update);
            
            
            pst.setString(1, v_fecha_visita);
            pst.setString(2, v_observaciones);
            pst.setString(3, v_diagnostico);
            pst.setString(4, v_receta);
            pst.setInt(5, v_nvisita);
            rs = pst.executeQuery();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOAtencionMedica.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        
        return false;
    }
    
    public ArrayList<Atencion> TraerTodos() {
        try {
            ArrayList<Atencion> LAtencion = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAll);
            rs = ps.executeQuery();
            
            while(rs.next()){
                LAtencion.add(new Atencion(rs.getInt("id_visita"), rs.getString("rut_medico"), rs.getString("rut_trabajador"), rs.getString("motivo_consulta"),rs.getString("observaciones"),rs.getString("diagnostico"),rs.getString("fecha_visita"),rs.getString("estado"),rs.getString("receta")));
            }
            return LAtencion; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOAtencionMedica.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }
    
    public Atencion Buscar(int v_nvisita, String v_rutTrabajador, String v_rutMedico){
        
        PreparedStatement pst = null;
        
        Atencion a = new Atencion();
        try {
            pst = objConn.getConn().prepareStatement(sql_buscar);
            
            pst.setInt(1, v_nvisita);
            pst.setString(2, v_rutTrabajador);
            pst.setString(3, v_rutMedico);
            rs = pst.executeQuery();
            
            if(rs.next()){
                a = new Atencion(rs.getInt("id_visita"), rs.getString("rut_medico"), rs.getString("rut_trabajador"), rs.getString("motivo_consulta"),rs.getString("observaciones"),rs.getString("diagnostico"),rs.getString("fecha_visita"),rs.getString("estado"),rs.getString("receta"));
                return a;
            }
            else
            {
                return a;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOAtencionMedica.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        
        return null;
    }
    
    
    
    public static void main(String[] args) {
        
        DAOAtencionMedica dao = new DAOAtencionMedica();
        System.out.println(dao.TraerTodos());
        
        
        
            
        
                
    }
    
}
