package DAO;

import Conexion.Conexion;
import Entidades.Area;
import java.sql.Connection;
import Interface.CRUDArea;
import Interface.CRUDTrabajador;
import VO.AreaVO;
import VO.TrabajadorVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO implements CRUDTrabajador{
    //Parametros conexion
    Conexion            cn  = new Conexion();
    Connection          con;
    PreparedStatement   ps;
    ResultSet           rs;
    //Inicializacion Entidades y VO

    @Override
    public List listar() {
        List<TrabajadorVO> listado = new ArrayList();
        String sql =    " SELECT " +
                        "      TR.RUT_TRABAJADOR     AS RUT_TRABAJADOR " +
                        "    , TR.NOMBRE             AS NOMBRE " +
                        "    , TR.APELLIDO           AS APELLIDO " +
                        "    , TR.ID_PERFIL          AS ID_PERFIL " +
                        "    , PE.NOMBRE_PERFIL      AS NOMBRE_PERFIL " +
                        "    , TR.RUT_EMPRESA        AS RUT_EMPRESA " +
                        "    , EMP.RAZON_SOCIAL      AS RAZON_SOCIAL " +
                        " FROM TRABAJADOR TR " +
                        " INNER JOIN PERFIL   PE  ON TR.ID_PERFIL     = PE.ID_PERFIL " +
                        " INNER JOIN EMPRESA  EMP ON TR.RUT_EMPRESA   = EMP.RUT_EMPRESA " ;
        try {
            con = cn.getConn();
            ps  = con.prepareStatement(sql);
            rs  = ps.executeQuery();
            while (rs.next()) {
                TrabajadorVO vo = new TrabajadorVO();
                vo.setRut_trabajador(rs.getString("RUT_TRABAJADOR"));
                vo.setNombre(rs.getString("NOMBRE"));
                vo.setApellido(rs.getString("APELLIDO"));
                vo.setId_perfil(rs.getInt("ID_PERFIL"));
                vo.setNombre_perfil(rs.getString("NOMBRE_PERFIL"));
                vo.setRut_empresa(rs.getString("RUT_EMPRESA"));
                vo.setRazon_social_empresa(rs.getString("RAZON_SOCIAL"));
                listado.add(vo);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar los trabajadores");
        }
        return listado; 
    }

    @Override
    public List listarPorRutEmpresa(String rutEmpresa) {        
        List<TrabajadorVO> listado = new ArrayList();
        String sql =    " SELECT " +
                        "      TR.RUT_TRABAJADOR     AS RUT_TRABAJADOR " +
                        "    , TR.NOMBRE             AS NOMBRE " +
                        "    , TR.APELLIDO           AS APELLIDO " +
                        "    , TR.ID_PERFIL          AS ID_PERFIL " +
                        "    , PE.NOMBRE_PERFIL      AS NOMBRE_PERFIL " +
                        "    , TR.RUT_EMPRESA        AS RUT_EMPRESA " +
                        "    , EMP.RAZON_SOCIAL      AS RAZON_SOCIAL " +
                        " FROM TRABAJADOR TR " +
                        " INNER JOIN PERFIL   PE  ON TR.ID_PERFIL     = PE.ID_PERFIL " +
                        " INNER JOIN EMPRESA  EMP ON TR.RUT_EMPRESA   = EMP.RUT_EMPRESA " +
                        " WHERE TR.RUT_EMPRESA = ? ";
        try {
            con = cn.getConn();
            ps  = con.prepareStatement(sql);
            
            ps.setString(1, rutEmpresa);
            rs  = ps.executeQuery();
            while (rs.next()) {
                TrabajadorVO vo = new TrabajadorVO();
                vo.setRut_trabajador(rs.getString("RUT_TRABAJADOR"));
                vo.setNombre(rs.getString("NOMBRE"));
                vo.setApellido(rs.getString("APELLIDO"));
                vo.setId_perfil(rs.getInt("ID_PERFIL"));
                vo.setNombre_perfil(rs.getString("NOMBRE_PERFIL"));
                vo.setRut_empresa(rs.getString("RUT_EMPRESA"));
                vo.setRazon_social_empresa(rs.getString("RAZON_SOCIAL"));
                listado.add(vo);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar los trabajadores");
        }
        return listado; 
    }

    @Override
    public TrabajadorVO list(String ruTrabajador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(TrabajadorVO vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(TrabajadorVO vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     

    
}
