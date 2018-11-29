package VO;

import java.sql.Date;

public class PlanVO {
    private int id_plan;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_termino;

    public PlanVO() {
    }

    public PlanVO(int id_plan, String descripcion, Date fecha_inicio, Date fecha_termino) {
        this.id_plan = id_plan;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }


}
