package DAO;

import Conexion.Conexion;
import Entidades.Area;
import Entidades.Atencion;
import java.sql.Connection;
import Interface.CRUDArea;
import Interface.CRUDAsistencia;
import Interface.CRUDEvaluacion;
import VO.AreaVO;
import VO.AsistenciaVO;
import VO.EvaPer_TerVO;
import VO.EvaluacionLiteVO;
import VO.EvaluacionVO;
import VO.Pregunta_RespuestaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EvaluacionDAO implements CRUDEvaluacion{
    //Parametros conexion
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    //Inicializacion Entidades y VO

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EvaluacionVO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EvaluacionLiteVO> listLite(String rutEmpresa) {
        PreparedStatement pst;
        List<EvaluacionLiteVO> listado = new ArrayList();
        String sql =    " SELECT " +
                        "      ID_EV " +
                        "    , TITULO " +                        
                        " FROM EVALUACION " +
                        " WHERE RUT_EMPRESA = ? " +
                        " ORDER BY ID_EV DESC ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            pst.setString(1, rutEmpresa);
            rs = pst.executeQuery();
            while (rs.next()) {
                EvaluacionLiteVO vo = new EvaluacionLiteVO();
                vo.setId(rs.getInt("ID_EV"));
                vo.setTitulo(rs.getString("TITULO"));                
                listado.add(vo);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar Capacitaciones");
        }
        return listado;
    }

    @Override
    public boolean add(EvaluacionVO are) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(EvaluacionVO are) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EvaPer_TerVO EvaPersonaPorId(int id) {
        PreparedStatement pst;
        String sql =    " SELECT " +
            "  EVA.TITULO             AS TITULO_EVA " +
            " ,EMP.RAZON_SOCIAL       AS RAZON_SOCIAL " +
            " ,EVA.RUT_EMPRESA        AS RUT_EMPRESA " +
            " ,EVA.FECHA_EVAL         AS FECHA_EVAL " +
            " ,EVA.DESCRIPCION        AS DESCRIPCION_EVA " +
            " ,EST.DESCRIPCION        AS ESTADO_EVA " +
            " ,PERS.DESCRIPCION       AS DESCRIPCION_EVA_PERS " +
            " ,PERS.RUT_TRABAJADOR    AS RUT_TRABAJADOR " +
            " FROM       EVALUACION EVA " +
            " INNER JOIN EMPRESA           EMP  ON EVA.RUT_EMPRESA            = EMP.RUT_EMPRESA " +    
            " INNER JOIN EVAL_PERS         PERS ON EVA.ID_EV = PERS.ID_EVALUACION " +
            " INNER JOIN EVALUACION_ESTADO EST  ON EVA.EVALUACION_ESTADO_ID = EST.EVALUACION_ESTADO_ID " +
            " WHERE EVA.ID_EV = ? ";
        EvaPer_TerVO vo = new EvaPer_TerVO();
        try {
            pst = objConn.getConn().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {                
                vo.setTITULO_EVA(rs.getString("TITULO_EVA"));
                vo.setRAZON_SOCIAL(rs.getString("RAZON_SOCIAL"));
                vo.setRUT_EMPRESA(rs.getString("RUT_EMPRESA"));
                vo.setFECHA_EVAL(rs.getDate("FECHA_EVAL"));
                vo.setDESCRIPCION_EVA(rs.getString("DESCRIPCION_EVA"));
                vo.setESTADO_EVA(rs.getString("ESTADO_EVA"));
                vo.setDESCRIPCION_EVA_PERS(rs.getString("DESCRIPCION_EVA_PERS"));
                vo.setRUT_TRABAJADOR(rs.getString("RUT_TRABAJADOR"));
            }
            return vo;
        } catch (Exception e) {
            System.out.println("error al listar Evaluaciones");
        }
        return vo;
    }

    @Override
    public EvaPer_TerVO EvaTerrenoPorId(int id) {
        PreparedStatement pst;
        String sql =    " SELECT " +
            "  EVA.TITULO             AS TITULO_EVA " +
            " ,EMP.RAZON_SOCIAL       AS RAZON_SOCIAL " +
            " ,EVA.RUT_EMPRESA        AS RUT_EMPRESA " +
            " ,EVA.FECHA_EVAL         AS FECHA_EVAL " +
            " ,EVA.DESCRIPCION        AS DESCRIPCION_EVA " +
            " ,EST.DESCRIPCION        AS ESTADO_EVA " +
            " ,TER.DESCRIPCION        AS DESCRIPCION_EVA_TER " +
            " FROM       EVALUACION EVA " +
            " INNER JOIN EMPRESA           EMP ON EVA.RUT_EMPRESA          = EMP.RUT_EMPRESA " +    
            " INNER JOIN EVAL_TERRENO      TER ON EVA.ID_EV                = TER.ID_EVALUACION " +
            " INNER JOIN EVALUACION_ESTADO EST ON EVA.EVALUACION_ESTADO_ID = EST.EVALUACION_ESTADO_ID " +
            " WHERE EVA.ID_EV = ? ";
        EvaPer_TerVO vo = new EvaPer_TerVO();
        try {
            pst = objConn.getConn().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {                
                vo.setTITULO_EVA(rs.getString("TITULO_EVA"));
                vo.setRAZON_SOCIAL(rs.getString("RAZON_SOCIAL"));
                vo.setRUT_EMPRESA(rs.getString("RUT_EMPRESA"));
                vo.setFECHA_EVAL(rs.getDate("FECHA_EVAL"));
                vo.setDESCRIPCION_EVA(rs.getString("DESCRIPCION_EVA"));
                vo.setESTADO_EVA(rs.getString("ESTADO_EVA"));
                vo.setDESCRIPCION_EVA_TER(rs.getString("DESCRIPCION_EVA_TER"));
            }
            return vo;
        } catch (Exception e) {
            System.out.println("error al listar Evaluaciones");
        }
        return vo;
    }

    @Override
    public List<Pregunta_RespuestaVO> Pregunta_RespuestaPorIdEva(int id) {
        PreparedStatement pst;
        String sql =    " SELECT " +
                        "     PRE.DETALLE_PREGUNTA  AS DETALLE_PREGUNTA" +
                        "    ,RES.DETALLE_RESPUESTA AS DETALLE_RESPUESTA " +
                        " FROM PREGUNTA PRE " +
                        " INNER JOIN EVALUACION EVA ON PRE.ID_EV       = EVA.ID_EV " +
                        " INNER JOIN RESPUESTA  RES ON PRE.ID_PREGUNTA = RES.ID_PREGUNTA " +
                        " WHERE EVA.ID_EV = ? ";
        
        Pregunta_RespuestaVO        vo      = new Pregunta_RespuestaVO();
        List<Pregunta_RespuestaVO>  listado = new ArrayList();
        
        try {
            pst = objConn.getConn().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {                
                vo.setDETALLE_PREGUNTA(rs.getString("DETALLE_PREGUNTA"));
                vo.setDETALLE_RESPUESTA(rs.getString("DETALLE_RESPUESTA"));
                listado.add(vo);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar Preguntas y Respuestas");
        }
        return listado;
    }

    @Override
    public int getEvaPer(int id) {
        PreparedStatement pst;
        String sql =    " SELECT COUNT(*) AS CANTIDAD FROM EVAL_PERS WHERE ID_EVALUACION = ? ";
        int salida = 0;
        try {
            pst = objConn.getConn().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                salida = rs.getInt("CANTIDAD");
            }
            return salida;
        } catch (Exception e) {
            System.out.println("error al listar evaluacion persona");
        }
        return salida;
    }

    @Override
    public int getEvaTer(int id) {
        PreparedStatement pst;
        String sql =    " SELECT COUNT(*) AS CANTIDAD FROM EVAL_TERRENO WHERE ID_EVALUACION = ? ";
        int salida = 0;
        try {
            pst = objConn.getConn().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                salida = rs.getInt("CANTIDAD");
            }
            return salida;
        } catch (Exception e) {
            System.out.println("error al listar evaluacion terreno");
        }
        return salida;
    }
      
    
}
