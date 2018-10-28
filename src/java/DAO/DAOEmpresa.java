/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Empresa;
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
public class DAOEmpresa {
    private static String sql_selectAll = "SELECT * FROM EMPRESA";
    
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public ArrayList<Empresa> TraerTodos() {
        try {
            ArrayList<Empresa> Lusu = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAll);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Lusu.add(new Empresa(rs.getString("rut_empresa"), rs.getString("razon_social"), rs.getInt("id_perfil"), rs.getString("direccion")));
                
            }
            return Lusu; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }
    
    
    public static void main(String[] args) {
        
        DAOEmpresa dao = new DAOEmpresa();
        System.out.println(dao.TraerTodos());
        
            
        
                
    }
    
}
