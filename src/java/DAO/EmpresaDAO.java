package DAO;

import Conexion.Conexion;
import java.sql.Connection;
import Interface.CRUDEmpresa;
import VO.EmpresaVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO implements CRUDEmpresa{
    //Parametros conexion
    Conexion            cn  = new Conexion();
    Connection          con;
    PreparedStatement   ps;
    ResultSet           rs;
    //Inicializacion Entidades y VO

    @Override
    public List listar() {
        List<EmpresaVO> listado = new ArrayList();
        String sql =    " SELECT " +
                        "      EMP.RUT_EMPRESA   AS RUT_EMPRESA " +
                        "    , EMP.RAZON_SOCIAL  AS RAZON_SOCIAL " +
                        "    , EMP.ID_PERFIL     AS ID_PERFIL " +
                        "    , PE.NOMBRE_PERFIL  AS NOMBRE_PERFIL " +
                        "    , EMP.DIRECCION     AS DIRECCION " +
                        " FROM EMPRESA EMP INNER JOIN PERFIL PE ON EMP.ID_PERFIL = PE.ID_PERFIL ";
        try {
            con = cn.getConn();
            ps  = con.prepareStatement(sql);
            rs  = ps.executeQuery();
            while (rs.next()) {
                EmpresaVO vo = new EmpresaVO();
                vo.setRut_empresa(rs.getString("RUT_EMPRESA"));
                vo.setRazon_social(rs.getString("RAZON_SOCIAL"));
                vo.setId_perfil(rs.getInt("ID_PERFIL"));
                vo.setNombre_perfil(rs.getString("NOMBRE_PERFIL"));
                vo.setDireccion(rs.getString("DIRECCION"));
                listado.add(vo);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar las Empresas");
        }
        return listado;
    }

    @Override
    public EmpresaVO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(EmpresaVO emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(EmpresaVO emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
