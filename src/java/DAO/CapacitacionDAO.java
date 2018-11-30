package DAO;

import Conexion.Conexion;
import java.sql.Connection;
import Entidades.Capacitacion;
import Interface.CRUDCapacitacion;
import VO.CapacitacionVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CapacitacionDAO implements CRUDCapacitacion{
    //Parametros conexion
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    //Inicializacion Entidades y VO
    CapacitacionVO      capacitacionVO  = new CapacitacionVO();
    Capacitacion        capacitacion    = new Capacitacion();
    
    @Override
    public List listar() {
        PreparedStatement ps;
        List<CapacitacionVO> listado = new ArrayList();
        String sql =    "SELECT " +
                        "    CAP.ID_CAPACITACION        AS ID " +
                        "   ,CAP.NOMBRE_CAPACITACION    AS NOMBRE_CAPACITACION " +
                        "   ,CAP.FECHA_TERMINO          AS FECHA_TERMINO " +
                        "   ,CAP.FECHA_INICIO           AS FECHA_INICIO " +
                        "   ,CAP.ID_AREA                AS ID_AREA " +
                        "   ,ARE.NOMBRE_AREA            AS NOMBRE_AREA " +
                        "   ,CAP.ID_PLAN                AS ID_PLAN " +
                        "   ,PLA.DESCRIPCION            AS NOMBRE_PLAN " +
                        "FROM        CAPACITACION CAP " +
                        "INNER JOIN  AREA         ARE ON CAP.ID_AREA = ARE.ID_AREA " +
                        "INNER JOIN  PLAN_ANUAL   PLA ON CAP.ID_PLAN = PLA.ID_PLAN " +
                        "ORDER BY CAP.ID_CAPACITACION DESC ";
        try {
            ps = objConn.getConn().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CapacitacionVO capacitacionVO = new CapacitacionVO();
                capacitacionVO.setId_capacitacion(rs.getInt("ID"));
                capacitacionVO.setNombre_capacitación(rs.getString("NOMBRE_CAPACITACION"));
                capacitacionVO.setFecha_termino(rs.getDate("FECHA_TERMINO"));
                capacitacionVO.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                capacitacionVO.setId_area(rs.getInt("ID_AREA"));
                capacitacionVO.setArea(rs.getString("NOMBRE_AREA"));
                capacitacionVO.setId_plan(rs.getInt("ID_PLAN"));
                capacitacionVO.setPlan(rs.getString("NOMBRE_PLAN"));
                listado.add(capacitacionVO);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar Capacitaciones");
        }
        return listado;
    }

    @Override
    public CapacitacionVO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(CapacitacionVO capVO) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    "INSERT INTO CAPACITACION " +
                        " ( " +
                        "     ID_CAPACITACION " +
                        "   , NOMBRE_CAPACITACION " + 
                        "   , FECHA_TERMINO " + 
                        "   , FECHA_INICIO " + 
                        "   , ID_AREA " + 
                        "   , ID_PLAN " +
                        " ) " + 
                        " VALUES " +
                        " ( " + 
                        " S_CAPACITACION.NEXTVAL, ?, ?, ?, ?, ? " + 
                        " ) ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setString(1, capVO.getNombre_capacitación());
            pst.setDate(2, capVO.getFecha_termino());
            pst.setDate(3, capVO.getFecha_inicio());
            pst.setInt(4, capVO.getId_area());
            pst.setInt(5, capVO.getId_plan());
            
            rs = pst.executeQuery();    
           
            salida = true;
            
            return salida;
        } catch (Exception e) {
            System.out.println("error al agregar la Capacitacion");
            salida = false;
        }
        return salida;
    }

    @Override
    public boolean edit(CapacitacionVO capVO) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    "UPDATE CAPACITACION " +
                        "SET " +
                        "     NOMBRE_CAPACITACION    = ? " + 
                        "   , FECHA_TERMINO          = ? " + 
                        "   , FECHA_INICIO           = ? " + 
                        "   , ID_AREA                = ? " + 
                        "   , ID_PLAN                = ? " + 
                        "WHERE ID_CAPACITACION       = ? " ;
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setString(1, capVO.getNombre_capacitación());
            pst.setDate(2, capVO.getFecha_termino());
            pst.setDate(3, capVO.getFecha_inicio());
            pst.setInt(4, capVO.getId_area());
            pst.setInt(5, capVO.getId_plan());
            pst.setInt(6, capVO.getId_capacitacion());
            
            rs = pst.executeQuery();    
           
            salida = true;
            
            return salida;
        } catch (Exception e) {
            System.out.println("error al editar la Capacitacion");
            salida = false;
        }
        return salida;    
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    " DELETE FROM CAPACITACION " +
                        " WHERE ID_CAPACITACION = ? ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();    
           
            salida = true;
            
            return salida;
        } catch (Exception e) {
            System.out.println("error al eliminar la Capacitacion");
            salida = false;
        }
        return salida;
    }
    
    
    //Buscar por rut
    public List listarRut(String rut) {
        PreparedStatement ps;
        List<CapacitacionVO> listado = new ArrayList();
        String sql =    "SELECT " +
                        "    CAP.ID_CAPACITACION        AS ID " +
                        "   ,CAP.NOMBRE_CAPACITACION    AS NOMBRE_CAPACITACION " +
                        "   ,CAP.FECHA_TERMINO          AS FECHA_TERMINO " +
                        "   ,CAP.FECHA_INICIO           AS FECHA_INICIO " +
                        "   ,CAP.ID_AREA                AS ID_AREA " +
                        "   ,ARE.NOMBRE_AREA            AS NOMBRE_AREA " +
                        "   ,CAP.ID_PLAN                AS ID_PLAN " +
                        "   ,PLA.DESCRIPCION            AS NOMBRE_PLAN " +
                        "FROM        CAPACITACION CAP " +
                        "INNER JOIN  AREA         ARE ON CAP.ID_AREA = ARE.ID_AREA " +
                        "INNER JOIN  PLAN_ANUAL   PLA ON CAP.ID_PLAN = PLA.ID_PLAN " +
                        "Where rut_trabajador = ?" +
                        "ORDER BY CAP.ID_CAPACITACION ASC ";
        try {
            ps = objConn.getConn().prepareStatement(sql);
            ps.setString(1, rut);
            rs = ps.executeQuery();
            while (rs.next()) {
                CapacitacionVO capacitacionVO = new CapacitacionVO();
                capacitacionVO.setId_capacitacion(rs.getInt("ID"));
                capacitacionVO.setNombre_capacitación(rs.getString("NOMBRE_CAPACITACION"));
                capacitacionVO.setFecha_termino(rs.getDate("FECHA_TERMINO"));
                capacitacionVO.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                capacitacionVO.setId_area(rs.getInt("ID_AREA"));
                capacitacionVO.setArea(rs.getString("NOMBRE_AREA"));
                capacitacionVO.setId_plan(rs.getInt("ID_PLAN"));
                capacitacionVO.setPlan(rs.getString("NOMBRE_PLAN"));
                listado.add(capacitacionVO);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar Capacitaciones");
        }
        return listado;
    }
    
}
