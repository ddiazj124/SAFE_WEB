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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class DAOMedico {
    private static String sql_selectRut = "SELECT * FROM MEDICO WHERE CORREO = (SELECT CORREO_ELECTRONICO FROM USUARIO WHERE nombre_usuario = ?)";
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    
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
        
        Medico med = new Medico();
        
        DAOMedico dao = new DAOMedico();
        med = dao.BuscarRutMedico("margarita");
        
        System.out.println(med.getRut_medico());
    }
    
}
