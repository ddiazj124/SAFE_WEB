package VO;

import java.sql.Date;

public class PlanAnualEmpresaVO {
    private int id;
    private String rut_empresa;
    private int id_plan_anual;
    private int id_capacitacion;

    public PlanAnualEmpresaVO(){
        
    }
    
    public PlanAnualEmpresaVO(int id, String rut_empresa, int id_plan_anual, int id_capacitacion) {
        this.id = id;
        this.rut_empresa = rut_empresa;
        this.id_plan_anual = id_plan_anual;
        this.id_capacitacion = id_capacitacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut_empresa() {
        return rut_empresa;
    }

    public void setRut_empresa(String rut_empresa) {
        this.rut_empresa = rut_empresa;
    }

    public int getId_plan_anual() {
        return id_plan_anual;
    }

    public void setId_plan_anual(int id_plan_anual) {
        this.id_plan_anual = id_plan_anual;
    }

    public int getId_capacitacion() {
        return id_capacitacion;
    }

    public void setId_capacitacion(int id_capacitacion) {
        this.id_capacitacion = id_capacitacion;
    }

}
