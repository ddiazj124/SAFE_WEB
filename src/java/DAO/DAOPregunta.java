/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Pregunta;
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
public class DAOPregunta {
    private static String sql_selectAll = "SELECT * FROM PREGUNTA where id_ev = ?";

    
private static Conexion objConn = Conexion.InstanciaConn();
private ResultSet rs;

public ArrayList<Pregunta> TraerPreguntasEval(int idEval) {
        try {
            ArrayList<Pregunta> Lpregunta = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAll);
            ps.setInt(1, idEval);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Lpregunta.add(new Pregunta(rs.getInt("id_pregunta"),rs.getInt("id_ev") ,rs.getString("detalle_pregunta")));                
            }
            return Lpregunta; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }

public static void main(String[] args) {
        
       DAOPregunta dao1 = new DAOPregunta();
       ArrayList<Pregunta> Listvis = dao1.TraerPreguntasEval(23);
        System.out.println("Cantidad de objetos: " + Listvis.size());
        
        for (Pregunta obj : Listvis) {
            System.out.println("ID Pregunta: "+obj.getIdEv()+ " Detalle: " + obj.getDetallePregunta());
        }
        
        System.out.println("---------------------------------");
    }
}
