/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Usuario;
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
public class DAOUsuario {
    private static String sql_selectAll = "SELECT * FROM USUARIO";
    private static String sql_autenticacion = "SELECT * FROM USUARIO WHERE nombre_usuario = ? AND contrasena = ?";
    private static String sql_selectUsuarioId = "SELECT * FROM USUARIO WHERE id_usuario = ?";
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public ArrayList<Usuario> TraerTodos() {
        try {
            ArrayList<Usuario> Lusu = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAll);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Lusu.add(new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("contrasena"), rs.getInt("id_perfil")));
                
            }
            return Lusu; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }
    
    public Usuario Autenticacion(String v_usuario, String v_contrasena){
        
        PreparedStatement pst = null;
        
        Usuario u = new Usuario();
        try {
            pst = objConn.getConn().prepareStatement(sql_autenticacion);
            
            pst.setString(1, v_usuario);
            pst.setString(2, v_contrasena);
            rs = pst.executeQuery();
            
            if(rs.next()){
                u = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("contrasena"), rs.getInt("id_perfil"));
                return u;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        
        return null;
    }
    
    public Usuario AutenticacionCorreo(String v_usuario, String v_contrasena){
        
        PreparedStatement pst = null;
        
        Usuario u = new Usuario();
        try {
            pst = objConn.getConn().prepareStatement(sql_autenticacion);
            
            pst.setString(1, v_usuario);
            pst.setString(2, v_contrasena);
            rs = pst.executeQuery();
            
            if(rs.next()){
                u = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre_usuario"), rs.getString("contrasena"), rs.getInt("id_perfil"),rs.getString("correo_electronico"));
                return u;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        
        return null;
    }
    
    
    
    public boolean ValidarUsuario(String v_usuario, String v_contrasena){
        
        PreparedStatement pst = null;
        try {
            pst = objConn.getConn().prepareStatement(sql_autenticacion);
            
            pst.setString(1, v_usuario);
            pst.setString(2, v_contrasena);
            rs = pst.executeQuery();
            
            if(rs.next()){
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
        /*
        DAOUsuario dao = new DAOUsuario();
        Usuario u = new Usuario();
        u = dao.Autenticacion("diazj", "f725e8472e0cd2da0541f3bf81004a26");
        System.out.println(u.getId_usuario());
        System.out.println(u.getNombre_usuario());
        */
        
        DAOUsuario dao = new DAOUsuario();
        dao.ValidarUsuario("diazj", "f725e8472e0cd2da0541f3bf81004a26");
        
        System.out.println(dao.ValidarUsuario("diazj", "f725e8472e0cd2da0541f3bf81004a26"));
        
        
        
    }
    
}
