/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Entidades.Tipo_Eval;
import Interface.Interface;
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
public class DAOTipo_Eval implements Interface{
    private static String sql_selectAll = "SELECT * FROM TIPO_EVAL";

    
private static Conexion objConn = Conexion.InstanciaConn();
private ResultSet rs;

    @Override
    public ArrayList<Tipo_Eval> TraerTodos() {
        try {
            ArrayList<Tipo_Eval> Lptipo_eval = new ArrayList<>();
            PreparedStatement ps;
            

            ps = objConn.getConn().prepareStatement(sql_selectAll);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Lptipo_eval.add(new Tipo_Eval(rs.getInt("id_tipo"), rs.getString("nombre_evaluacion")));
                
            }
            return Lptipo_eval; 
        
        } catch (SQLException ex) {
            Logger.getLogger(DAOTipo_Eval.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        return null;  
    }

    public static void main(String[] args) {
        DAOTipo_Eval tipo_eval = new DAOTipo_Eval();
        ArrayList<Tipo_Eval> Lptipo_eval = tipo_eval.TraerTodos();
        
        
        System.out.println("Cantidad de objetos :" + Lptipo_eval.size());
        System.out.println("");
        
        for (Tipo_Eval obj : Lptipo_eval) {
              System.out.println(obj.getId_tipo()+ " " + obj.getNombre_evaluacion());
        }
    }



}
