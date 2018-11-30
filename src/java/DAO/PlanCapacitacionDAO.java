package DAO;

import Conexion.Conexion;
import java.sql.Connection;
import Entidades.Capacitacion;
import Interface.CRUDPlanCapacitacion;
import VO.CapacitacionVO;
import VO.PlanCapacitacionVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanCapacitacionDAO implements CRUDPlanCapacitacion{
    //Parametros conexion
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    //Inicializacion Entidades y VO
    PlanCapacitacionVO vo = new PlanCapacitacionVO();

    @Override
    public List listar() {
        PreparedStatement ps;
        List<PlanCapacitacionVO> listado = new ArrayList();
        String sql =    " SELECT " +
                        "      ID_PLAN AS ID_PLAN " +
                        "    , DESCRIPCION AS DESCRIPCION " +
                        "    , FECHA_INICIO  AS FECHA_INICIO " +
                        "    , FECHA_TERMINO AS FECHA_TERMINO " +
                        " FROM PLAN_ANUAL " +
                        " ORDER BY ID_PLAN DESC ";
        try {
            ps = objConn.getConn().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PlanCapacitacionVO vo = new PlanCapacitacionVO();
                vo.setId_plan(rs.getInt("ID_PLAN"));
                vo.setNombre_plan(rs.getString("DESCRIPCION"));
                vo.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                vo.setFecha_termino(rs.getDate("FECHA_TERMINO"));
                listado.add(vo);
            }
            return listado;
        } catch (Exception e) {
            System.out.println("error al listar los Planes Anuales de Capacitaciones");
        }
        return listado;
    }

    @Override
    public PlanCapacitacionVO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(PlanCapacitacionVO plan) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    "INSERT INTO PLAN_ANUAL " +
                        " ( " +
                        "     ID_PLAN " +
                        "   , DESCRIPCION " + 
                        "   , FECHA_INICIO " + 
                        "   , FECHA_TERMINO " + 
                        " ) " + 
                        " VALUES " +
                        " ( " + 
                        " S_PLAN_ANUAL.NEXTVAL, ?, ?, ? " + 
                        " ) ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setString(1, plan.getNombre_plan());
            pst.setDate(2, plan.getFecha_inicio());
            pst.setDate(3, plan.getFecha_termino());            
            
            rs = pst.executeQuery();    
           
            salida = true;
            
            return salida;
        } catch (Exception e) {
            System.out.println("error al agregar el Plan Anual de Capacitacion");
            salida = false;
        }
        return salida;
    }

    @Override
    public boolean edit(PlanCapacitacionVO plan) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    " UPDATE PLAN_ANUAL " +
                        " SET " +
                        "     DESCRIPCION   = ? " +                         
                        "   , FECHA_INICIO  = ? " +
                        "   , FECHA_TERMINO = ? " +                          
                        " WHERE ID_PLAN     = ? " ;
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setString(1, plan.getNombre_plan());
            pst.setDate(2, plan.getFecha_inicio());
            pst.setDate(3, plan.getFecha_termino());
            pst.setInt(4, plan.getId_plan());
            
            rs = pst.executeQuery();    
           
            salida = true;
            
            return salida;
        } catch (Exception e) {
            System.out.println("error al editar el Plan Anual de Capacitacion");
            salida = false;
        }
        return salida;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    " DELETE FROM PLAN_ANUAL " +
                        " WHERE ID_PLAN = ? ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();    
           
            salida = true;
            
            return salida;
        } catch (Exception e) {
            System.out.println("error al eliminar el Plan Anual de Capacitación");
            salida = false;
        }
        return salida;
    }
    
    
}
