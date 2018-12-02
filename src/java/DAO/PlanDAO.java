package DAO;

import Conexion.Conexion;
import Entidades.Area;
import Entidades.Plan_Anual;
import java.sql.Connection;
import Interface.CRUDArea;
import Interface.CRUDPlan;
import VO.AreaVO;
import VO.PlanVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanDAO implements CRUDPlan{
    //Parametros conexion
    Conexion            cn  = new Conexion();
    Connection          con;
    PreparedStatement   ps;
    ResultSet           rs;

    @Override
    public List listar() {
        List<PlanVO> listado = new ArrayList();
        String sql =    " SELECT " +
                        "      ID_PLAN       AS ID " +
                        "    , DESCRIPCION   AS NOMBRE " +
                        "    , FECHA_INICIO  AS FECHA_INICIO " +
                        "    , FECHA_TERMINO AS FECHA_TERMINO " +
                        " FROM PLAN_ANUAL " +
                        " ORDER BY ID_PLAN ASC";
        try {
            con = cn.getConn();
            ps  = con.prepareStatement(sql);
            rs  = ps.executeQuery();
            while (rs.next()) {
                PlanVO planVO = new PlanVO();
                planVO.setId_plan(rs.getInt("ID"));
                planVO.setDescripcion(rs.getString("NOMBRE"));
                planVO.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                planVO.setFecha_termino(rs.getDate("FECHA_TERMINO"));
                listado.add(planVO);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar los Planes");
        }
        return listado;        
    }

    @Override
    public PlanVO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Plan_Anual plan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(Plan_Anual plan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
