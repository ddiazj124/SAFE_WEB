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
    
    
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
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
    
    
    public static void main(String[] args) {
        
        DAOAtencionMedica dao = new DAOAtencionMedica();
        System.out.println(dao.TraerTodos());
        
        
        
            
        
                
    }
    
}
