package DAO;

import Conexion.Conexion;
import Entidades.Area;
import java.sql.Connection;
import Interface.CRUDArea;
import VO.AreaVO;
import VO.MedicoVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO implements CRUDArea{
    //Parametros conexion
    Conexion            cn  = new Conexion();
    Connection          con;
    PreparedStatement   ps;
    ResultSet           rs;
    //Inicializacion Entidades y VO

    @Override
    public List listar() {
        List<MedicoVO> listado = new ArrayList();
        String sql =    " SELECT " +
                        "      ME.RUT_MEDICO    AS RUT_MEDICO " +
                        "    , ME.ID_PERFIL     AS ID_PERFIL " +
                        "    , PE.NOMBRE_PERFIL AS NOMBRE_PERFIL " +
                        "    , ME.NOMBRE        AS NOMBRE " +
                        "    , ME.APELLIDO      AS APELLIDO " +
                        "    , ME.CORREO        AS CORREO " +
                        "FROM MEDICO ME INNER JOIN PERFIL PE " +
                        "ON ME.ID_PERFIL = PE.ID_PERFIL";
        try {
            con = cn.getConn();
            ps  = con.prepareStatement(sql);
            rs  = ps.executeQuery();
            while (rs.next()) {
                MedicoVO medicoVO = new MedicoVO();
                medicoVO.setRut_medico(rs.getString("RUT_MEDICO"));
                medicoVO.setId_perfil(rs.getInt("ID_PERFIL"));
                medicoVO.setPerfil_descripcion(rs.getString("NOMBRE_PERFIL"));
                medicoVO.setNombre(rs.getString("NOMBRE"));
                medicoVO.setApellido(rs.getString("APELLIDO"));
                medicoVO.setCorreo(rs.getString("CORREO"));
                listado.add(medicoVO);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar los médicos");
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
