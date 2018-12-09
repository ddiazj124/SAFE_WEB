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
import VO.EvaluacionLiteVO;
import VO.EvaluacionVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EvaluacionTerrenoDAO implements CRUDEvaluacionTerreno{
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

   
    
}
