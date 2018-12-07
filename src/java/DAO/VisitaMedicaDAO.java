package DAO;

import Conexion.Conexion;
import java.sql.Connection;
import Entidades.Capacitacion;
import Interface.CRUDVisitaMedica;
import VO.CapacitacionVO;
import VO.VisitaMedicaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VisitaMedicaDAO implements CRUDVisitaMedica{

    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    @Override
    public List listar() {
        PreparedStatement ps;
        List<VisitaMedicaVO> listado = new ArrayList();
        String sql =    " SELECT " +
                        "      VM.ID_VISITA       AS ID_VISITA " +
                        "    , VM.RUT_MEDICO      AS RUT_MEDICO " +
                        "    , VM.RUT_TRABAJADOR  AS RUT_TRABAJADOR " +
                        "    , VM.MOTIVO_CONSULTA AS MOTIVO_CONSULTA " +
                        "    , VM.OBSERVACIONES   AS OBSERVACIONES " +
                        "    , VM.DIAGNOSTICO     AS DIAGNOSTICO " +
                        "    , VM.FECHA_VISITA    AS FECHA_VISITA " +
                        "    , VM.ESTADO          AS ESTADO " +
                        "    , VE.DESCRIPCION     AS ESTADO_DESCRIPCION " +
                        "    , VM.RECETA          AS RECETA " +
                        " FROM        VISITA_MED          VM " +
                        " INNER JOIN  VISITA_MED_ESTADO   VE " +
                        " ON VM.ESTADO = VE.ID " +
                        " ORDER BY ID_VISITA DESC ";
        try {
            ps = objConn.getConn().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                VisitaMedicaVO visitaVO = new VisitaMedicaVO();
                visitaVO.setId_visita(rs.getInt("ID_VISITA"));
                visitaVO.setRut_medico(rs.getString("RUT_MEDICO"));
                visitaVO.setRut_trabajador(rs.getString("RUT_TRABAJADOR"));
                visitaVO.setMotivo_consulta(rs.getString("MOTIVO_CONSULTA"));
                visitaVO.setObservaciones(rs.getString("OBSERVACIONES"));
                visitaVO.setDiagnostico(rs.getString("DIAGNOSTICO"));
                visitaVO.setFecha_visita(rs.getDate("FECHA_VISITA"));
                visitaVO.setEstado(rs.getInt("ESTADO"));
                visitaVO.setEstado_descripcion(rs.getString("ESTADO_DESCRIPCION"));
                visitaVO.setReceta(rs.getString("RECETA"));
                listado.add(visitaVO);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar Visitas");
        }
        return listado;
    }

    public List listarAsc() {
        PreparedStatement ps;
        List<VisitaMedicaVO> listado = new ArrayList();
        String sql =    " SELECT " +
                        "      VM.ID_VISITA       AS ID_VISITA " +
                        "    , VM.RUT_MEDICO      AS RUT_MEDICO " +
                        "    , VM.RUT_TRABAJADOR  AS RUT_TRABAJADOR " +
                        "    , VM.MOTIVO_CONSULTA AS MOTIVO_CONSULTA " +
                        "    , VM.OBSERVACIONES   AS OBSERVACIONES " +
                        "    , VM.DIAGNOSTICO     AS DIAGNOSTICO " +
                        "    , VM.FECHA_VISITA    AS FECHA_VISITA " +
                        "    , VM.ESTADO          AS ESTADO " +
                        "    , VE.DESCRIPCION     AS ESTADO_DESCRIPCION " +
                        "    , VM.RECETA          AS RECETA " +
                        " FROM        VISITA_MED          VM " +
                        " INNER JOIN  VISITA_MED_ESTADO   VE " +
                        " ON VM.ESTADO = VE.ID " +
                        " ORDER BY ID_VISITA ASC ";
        try {
            ps = objConn.getConn().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                VisitaMedicaVO visitaVO = new VisitaMedicaVO();
                visitaVO.setId_visita(rs.getInt("ID_VISITA"));
                visitaVO.setRut_medico(rs.getString("RUT_MEDICO"));
                visitaVO.setRut_trabajador(rs.getString("RUT_TRABAJADOR"));
                visitaVO.setMotivo_consulta(rs.getString("MOTIVO_CONSULTA"));
                visitaVO.setObservaciones(rs.getString("OBSERVACIONES"));
                visitaVO.setDiagnostico(rs.getString("DIAGNOSTICO"));
                visitaVO.setFecha_visita(rs.getDate("FECHA_VISITA"));
                visitaVO.setEstado(rs.getInt("ESTADO"));
                visitaVO.setEstado_descripcion(rs.getString("ESTADO_DESCRIPCION"));
                visitaVO.setReceta(rs.getString("RECETA"));
                listado.add(visitaVO);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar Visitas");
        }
        return listado;
    }    
    
    @Override
    public VisitaMedicaVO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(VisitaMedicaVO vis) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    "INSERT INTO VISITA_MED " +
                        " ( " +
                        "     ID_VISITA " +
                        "   , RUT_MEDICO " + 
                        "   , RUT_TRABAJADOR " + 
                        "   , MOTIVO_CONSULTA " + 
                        "   , OBSERVACIONES " + 
                        "   , DIAGNOSTICO " +
                        "   , FECHA_VISITA " +
                        "   , ESTADO " +
                        "   , RECETA " +
                        " ) " + 
                        " VALUES " +
                        " ( " + 
                        " S_VISITA_MED.NEXTVAL, ?, ?, ?, ?, ? , ? ,? , ? " + 
                        " ) ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setString(1, vis.getRut_medico());
            pst.setString(2, vis.getRut_trabajador());
            pst.setString(3, vis.getMotivo_consulta());
            pst.setString(4, " ");
            pst.setString(5, " ");
            pst.setDate(6, vis.getFecha_visita());
            pst.setInt(7, 1);
            pst.setString(8, " ");
            
            rs = pst.executeQuery();    
           
            salida = true;
            
            return salida;
        } catch (Exception e) {
            System.out.println("error al agregar la Visita Médica");
            salida = false;
        }
        return salida;
    }

    @Override
    public boolean edit(VisitaMedicaVO vis) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    " UPDATE VISITA_MED " +
                        " SET " +
                        "     RUT_MEDICO        = ? " + 
                        "   , RUT_TRABAJADOR    = ? " + 
                        "   , MOTIVO_CONSULTA   = ? " + 
                        "   , FECHA_VISITA      = ? " +
                        " WHERE ID_VISITA       = ? ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setString(1, vis.getRut_medico());
            pst.setString(2, vis.getRut_trabajador());
            pst.setString(3, vis.getMotivo_consulta());
            pst.setDate(4, vis.getFecha_visita());
            pst.setInt(5, vis.getId_visita());
            
            rs = pst.executeQuery();    
           
            salida = true;
            
            return salida;
        } catch (Exception e) {
            System.out.println("error al agregar la Visita Médica");
            salida = false;
        }
        return salida;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    " DELETE FROM VISITA_MED " +
                        " WHERE ID_VISITA = ? ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();    
           
            salida = true;
            
            return salida;
        } catch (Exception e) {
            System.out.println("error al eliminar la Visita Médica");
            salida = false;
        }
        return salida;
    }
    //Parametros conexion
    
    
}
