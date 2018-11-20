/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian
 */
public class Conexion {
    public static Conexion InstaConn;
    private Connection conn;
    
    private Conexion(){
        try {
            //Ahora conecta
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@safe.ctslys2afeq0.us-east-2.rds.amazonaws.com:1521:ORCL", "user_safe", "Portafolio_1");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized static Conexion InstanciaConn(){
        if(InstaConn==null){
            InstaConn = new Conexion();
        }
        return InstaConn;
    }
    
    public Connection getConn() {
        return conn;
    }
    
    public void Cerrar(){
        InstaConn = null;
    }
    
}

