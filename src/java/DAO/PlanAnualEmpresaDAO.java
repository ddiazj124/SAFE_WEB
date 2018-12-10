package DAO;

import Conexion.Conexion;
import Entidades.Area;
import Entidades.Plan_Anual;
import java.sql.Connection;
import Interface.CRUDArea;
import Interface.CRUDPlan;
import Interface.CRUDPlanAnualEmpresa;
import VO.AreaVO;
import VO.PlanAnualEmpresaVO;
import VO.PlanVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlanAnualEmpresaDAO implements CRUDPlanAnualEmpresa{

    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlanVO list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(PlanAnualEmpresaVO plan) {
        PreparedStatement pst = null;
        boolean salida;
        String sql =    " INSERT INTO PLAN_ANUAL_EMPRESA " +
                        " ( " +
                        "     ID_PLAN_ANUAL_EMPRESA " +
                        "   , RUT_EMPRESA" + 
                        "   , ID_PLAN_ANUAL " + 
                        "   , ID_CAPACITACION " +
                        " ) " + 
                        " VALUES " +
                        " ( " + 
                        " S_PLAN_ANUAL_EMPRESA.NEXTVAL, ?, ?, ? " + 
                        " ) ";
        try {
            pst = objConn.getConn().prepareStatement(sql);
            
            
            pst.setString(1, plan.getRut_empresa());
            //pst.setInt(3, "1");
            pst.setInt(2, plan.getId_plan_anual());
            pst.setInt(3, plan.getId_capacitacion());
            
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
    public boolean edit(PlanAnualEmpresaVO plan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
