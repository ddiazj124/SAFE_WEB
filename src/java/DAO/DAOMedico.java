/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Medico;
import Entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class DAOMedico {
    private static String sql_selectAll = "SELECT * FROM MEDICO";
    private static String sql_selectRut = "SELECT * FROM MEDICO WHERE CORREO = (SELECT CORREO_ELECTRONICO FROM USUARIO WHERE nombre_usuario = ?)";
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public ArrayList<Medico> TraerTodos() {
        try {
            ArrayList<Medico> Lmedico = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAll);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Lmedico.add(new Medico(rs.getString("rut_medico"),rs.getString("nombre"),rs.getString("apellido")));
                
            }
            return Lmedico; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }
    
    
    
        public Medico BuscarRutMedico(String nombre_usuario){
        
        PreparedStatement pst = null;
        
        Medico m = new Medico();
        try {
            pst = objConn.getConn().prepareStatement(sql_selectRut);
            
            pst.setString(1, nombre_usuario);
            rs = pst.executeQuery();
            
            if(rs.next()){
                m = new Medico(rs.getString("rut_medico"));
                return m;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        DAOMedico dao = new DAOMedico();
        Medico med = new Medico();
        
        System.out.println(dao.TraerTodos().size());
        /*
        DAOMedico dao = new DAOMedico();
        med = dao.BuscarRutMedico("margarita");
        
        System.out.println(med.getRut_medico());
        */
    }
    
}
