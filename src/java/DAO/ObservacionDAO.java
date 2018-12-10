package DAO;

import Conexion.Conexion;
import Entidades.Area;
import Entidades.Atencion;
import java.sql.Connection;
import Interface.CRUDArea;
import Interface.CRUDAsistencia;
import Interface.CRUDEvaluacion;
import Interface.CRUDObservacion;
import VO.AreaVO;
import VO.AsistenciaVO;
import VO.EvaPer_TerVO;
import VO.EvaluacionLiteVO;
import VO.EvaluacionVO;
import VO.ObservacionVO;
import VO.Pregunta_RespuestaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObservacionDAO implements CRUDObservacion{
    //Parametros conexion
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    //Inicializacion Entidades y VO

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservacionVO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ObservacionVO> listLite(String rutIngeniero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(ObservacionVO obs) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    " INSERT " +
                        " INTO EVALUACION_OBSERVACION " +
                        " ( " +
                        "      ID_OBSERVACION " +
                        "    , ID_EVALUACION " +
                        "    , DETALLE_OBSERVACION " +
                        " ) " +
                        " VALUES " +
                        " ( " +
                        "      S_OBSERVACION.NEXTVAL " +
                        "    , ? " +
                        "    , ? " +
                        " ) ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setInt(1, obs.getID_EVALUACION());
            pst.setString(2, obs.getDETALLE_OBSERVACION());
            
            rs = pst.executeQuery();    
           
            salida = true;
            
            return salida;
        } catch (Exception e) {
            System.out.println("error al agregar la observación");
            salida = false;
        }
        return salida;
    }

    @Override
    public boolean edit(ObservacionVO obs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


      
    
}
