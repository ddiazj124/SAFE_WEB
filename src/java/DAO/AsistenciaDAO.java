package DAO;

import Conexion.Conexion;
import Entidades.Area;
import java.sql.Connection;
import Interface.CRUDArea;
import Interface.CRUDAsistencia;
import VO.AreaVO;
import VO.AsistenciaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDAO implements CRUDAsistencia{
    //Parametros conexion
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    //Inicializacion Entidades y VO

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AsistenciaVO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(AsistenciaVO asi) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    " INSERT INTO ASISTENCIA " +
                        " ( " +
                        "     ASISTENCIA_ID " +
                        "   , CAPACITACION_ID " + 
                        "   , TRABAJADOR_RUT " + 
                        "   , ASISTENCIA_ESTADO_ID " + 
                        "   , FECHA_ASISTENCIA " + 
                        "   , LUGAR " +
                        " ) " + 
                        " VALUES " +
                        " ( " + 
                        " S_ASISTENCIA.NEXTVAL, ?, ?, 1, ?, ? " + 
                        " ) ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            
            pst.setInt(1, asi.getCapacitacion_id());
            pst.setString(2, asi.getRut_trabajador());
            //pst.setInt(3, "1");
            pst.setDate(3, asi.getFecha_asistencia());
            pst.setString(4, asi.getLugar());
            
            rs = pst.executeQuery();    
           
            salida = true;
            
            return salida;
        } catch (Exception e) {
            System.out.println("error al agregar la asistencia");
            salida = false;
        }
        return salida;
    }

    @Override
    public boolean edit(AsistenciaVO asi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
