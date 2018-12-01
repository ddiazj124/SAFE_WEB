package DAO;

import Conexion.Conexion;
import Entidades.Area;
import Entidades.Atencion;
import java.sql.Connection;
import Interface.CRUDArea;
import Interface.CRUDAsistencia;
import VO.AreaVO;
import VO.AsistenciaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public List<AsistenciaVO> list(int id) {
        PreparedStatement pst = null;
        
        try {
            String sql =    " SELECT " +
                            "      ASI.ASISTENCIA_ID         AS ID " +
                            "    , ASI.CAPACITACION_ID       AS CAPACITACION_ID " +
                            "    , CAP.NOMBRE_CAPACITACION   AS NOMBRE_CAPACITACION " +
                            "    , ASI.TRABAJADOR_RUT        AS TRABAJADOR_RUT " +
                            "    , TRA.NOMBRE                AS NOMBRE_TRABAJADOR " +
                            "    , TRA.APELLIDO              AS APELLIDO_TRABAJADOR " +
                            "    , ASI.ASISTENCIA_ESTADO_ID  AS ASISTENCIA_ESTADO_ID " +
                            "    , EST.DESCRIPCION           AS DESCRIPCION_ESTADO " +
                            "    , ASI.FECHA_ASISTENCIA      AS FECHA_ASISTENCIA " +
                            "    , ASI.LUGAR                 AS LUGAR " +
                            " FROM ASISTENCIA ASI " +
                            " INNER JOIN CAPACITACION         CAP ON ASI.CAPACITACION_ID      = CAP.ID_CAPACITACION " +
                            " INNER JOIN ASISTENCIA_ESTADO    EST ON ASI.ASISTENCIA_ESTADO_ID = EST.ASISTENCIA_ESTADO_ID " +
                            " INNER JOIN TRABAJADOR           TRA ON ASI.TRABAJADOR_RUT       = TRA.RUT_TRABAJADOR " +
                            " WHERE ASI.ASISTENCIA_ID = ? ";    
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            List<AsistenciaVO> listado = new ArrayList();
            if(rs.next()){
                AsistenciaVO vo = new AsistenciaVO();
                vo.setId_asistencia(rs.getInt("ID"));
                vo.setCapacitacion_id(rs.getInt("CAPACITACION_ID"));
                vo.setNombre_capacitacion(rs.getString("NOMBRE_CAPACITACION"));
                vo.setRut_trabajador(rs.getString("TRABAJADOR_RUT"));
                vo.setNombre_trabajador(rs.getString("NOMBRE_TRABAJADOR"));
                vo.setApellido_trabajador(rs.getString("APELLIDO_TRABAJADOR"));
                vo.setEstado_id(rs.getInt("ASISTENCIA_ESTADO_ID"));
                vo.setEstado_asistencia(rs.getString("DESCRIPCION_ESTADO"));
                vo.setFecha_asistencia(rs.getDate("FECHA_ASISTENCIA"));
                vo.setLugar(rs.getString("LUGAR"));
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(DAOAtencionMedica.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objConn.Cerrar();
        }
        
        return null;
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

    @Override
    public List<AsistenciaVO> list2(int id) {
        
        PreparedStatement pst = null;
        List<AsistenciaVO> listado = new ArrayList();
        
        String sql =    " SELECT " +
                        "  TRA.NOMBRE               AS NOMBRE " +
                        "  ,TRA.APELLIDO            AS APELLIDO " +
                        "  ,ASI.TRABAJADOR_RUT      AS TRABAJADOR_RUT " +
                        "  ,ASI.FECHA_ASISTENCIA    AS FECHA_ASISTENCIA " +
                        "  ,EST.DESCRIPCION         AS ESTADO_DESCRIPCION " +
                        " FROM  ASISTENCIA              ASI " +
                        " INNER JOIN TRABAJADOR         TRA ON ASI.TRABAJADOR_RUT       = TRA.RUT_TRABAJADOR " +
                        " INNER JOIN ASISTENCIA_ESTADO  EST ON ASI.ASISTENCIA_ESTADO_ID = EST.ASISTENCIA_ESTADO_ID " +    
                        " WHERE ASI.CAPACITACION_ID = ? ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                AsistenciaVO vo = new AsistenciaVO();
                vo.setNombre_trabajador(rs.getString("NOMBRE"));
                vo.setApellido_trabajador(rs.getString("APELLIDO"));
                vo.setRut_trabajador(rs.getString("TRABAJADOR_RUT"));
                vo.setFecha_asistencia(rs.getDate("FECHA_ASISTENCIA"));
                vo.setEstado_asistencia(rs.getString("ESTADO_DESCRIPCION"));
                listado.add(vo);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar los trabajadores");
        }
        return listado;
    }

   
    
}
