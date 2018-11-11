/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Visita_Med;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class DAOVisita_Med {
    private static String sql_selectAll = "SELECT * FROM VISITA_MED";
    private static String sql_selectAllFecha = "SELECT * FROM VISITA_MED WHERE FECHA_VISITA LIKE '%?%' ";
    private static String sql_buscarVisita = "SELECT * FROM VISITA_MED WHERE ID_VISITA = ?";
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    
    public ArrayList<Visita_Med> TraerTodos() {
        try {
            ArrayList<Visita_Med> Lvisita = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAll);
            rs = ps.executeQuery();
            
            while(rs.next()){
                //Lvisita.add(new Visita_Med(rs.getInt("id_visita"), rs.getString("rut_medico"), rs.getString("rut_trabajador"), rs.getString("motivo_consulta"), rs.getString("observaciones"), rs.getString("diagnostico"), rs.getTimestamp("fecha_visita"),rs.getString("estado").charAt(0),rs.getString("receta")));
                Lvisita.add(new Visita_Med(rs.getInt("id_visita"), rs.getString("rut_medico"), rs.getString("trabajador"), rs.getString("motivo_consulta"), rs.getString("observaciones"), rs.getString("diagnostico"), rs.getString("fecha_visita"), rs.getBoolean("estado"), rs.getString("receta")));
            }
            return Lvisita; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }
    
    
    public ArrayList<Visita_Med> TraerTodosPorFecha(Timestamp tiempo) {
        try {
            ArrayList<Visita_Med> Lvisita = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAllFecha);
            ps.setTimestamp(1, tiempo);
            rs = ps.executeQuery();
            
            while(rs.next()){
                //Lvisita.add(new Visita_Med(rs.getInt("id_visita"), rs.getString("rut_medico"), rs.getString("rut_trabajador"), rs.getString("motivo_consulta"), rs.getString("observaciones"), rs.getString("diagnostico"), rs.getTimestamp("fecha_visita"),rs.getString("estado").charAt(0),rs.getString("receta")));
                Lvisita.add(new Visita_Med(rs.getInt("id_visita"), rs.getString("rut_medico"), rs.getString("trabajador"), rs.getString("motivo_consulta"), rs.getString("observaciones"), rs.getString("diagnostico"), rs.getString("fecha_visita"), rs.getBoolean("estado"), rs.getString("receta")));
            }
            return Lvisita; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }
    
    public Visita_Med BuscarXvisita(int v_id){
        
        PreparedStatement pst = null;
        
        Visita_Med v = new Visita_Med();
        try {
            pst = objConn.getConn().prepareStatement(sql_buscarVisita);
            pst.setInt(1, v_id);
            rs = pst.executeQuery();
            
            if(rs.next()){
            //v = new Visita_Med(rs.getInt("id_visita"), rs.getString("rut_medico"), rs.getString("rut_trabajador"), rs.getString("motivo_consulta"), rs.getString("observaciones"), rs.getString("diagnostico"), rs.getTimestamp("fecha_visita"),rs.getString("estado").charAt(0),rs.getString("receta"));
            v = new Visita_Med(rs.getInt("id_visita"), rs.getString("rut_medico"), rs.getString("trabajador"), rs.getString("motivo_consulta"), rs.getString("observaciones"), rs.getString("diagnostico"), rs.getString("fecha_visita"), rs.getBoolean("estado"), rs.getString("receta"));
            return v;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        
        return null;
    }
    
    
    public static void main(String[] args) {
        
        /*
        DAOVisita_Med vism = new DAOVisita_Med();
        ArrayList<Visita_Med> Listvis = vism.TraerTodos();
        
        System.out.println("Cantidad Objetos: " + Listvis.size());
        System.out.println("-----------------------------------------------------");
        
        
        for (Visita_Med Listvi : Listvis) {
            System.out.println(Listvi.getId_visita());
            System.out.println(Listvi.getRut_medico());
            System.out.println(Listvi.getRut_trabajador());
            System.out.println(Listvi.getEstado());
            System.out.println(Listvi.getFecha_visita());
        }
        */
        DAOVisita_Med vism = new DAOVisita_Med();
        ArrayList<Visita_Med> Listvis = vism.TraerTodosPorFecha(Timestamp.valueOf("2020-10-20 18:00:00.000"));
        
        System.out.println("Cantidad Fechas dia 2020-10-20 18:00:00.000 : "+Listvis.size());
        
    }
}
