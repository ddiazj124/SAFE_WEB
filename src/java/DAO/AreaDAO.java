package DAO;

import Conexion.Conexion;
import Entidades.Area;
import java.sql.Connection;
import Interface.CRUDArea;
import VO.AreaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AreaDAO implements CRUDArea{
    //Parametros conexion
    Conexion            cn  = new Conexion();
    Connection          con;
    PreparedStatement   ps;
    ResultSet           rs;
    //Inicializacion Entidades y VO

    @Override
    public List listar() {
        List<AreaVO> listado = new ArrayList();
        String sql =    "SELECT " +
                        "      ID_AREA       AS ID " +
                        "    , NOMBRE_AREA   AS NOMBRE " +
                        "FROM AREA " +
                        "ORDER BY ID_AREA ASC";
        try {
            con = cn.getConn();
            ps  = con.prepareStatement(sql);
            rs  = ps.executeQuery();
            while (rs.next()) {
                AreaVO areaVO = new AreaVO();
                areaVO.setId_area(rs.getInt("ID"));
                areaVO.setNombre_area(rs.getString("NOMBRE"));
                listado.add(areaVO);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar las Áreas");
        }
        return listado;    
    }

    @Override
    public Area list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Area are) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(Area are) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
