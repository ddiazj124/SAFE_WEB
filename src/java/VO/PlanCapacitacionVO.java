package VO;

import java.sql.Date;

public class PlanCapacitacionVO {
private int     id_plan;
private String  nombre_plan;
private Date    fecha_termino;
private Date    fecha_inicio;

    public PlanCapacitacionVO() {
    }

    public PlanCapacitacionVO(int id_plan, String nombre_plan, Date fecha_termino, Date fecha_inicio) {
        this.id_plan        = id_plan;
        this.nombre_plan    = nombre_plan;
        this.fecha_termino  = fecha_termino;
        this.fecha_inicio   = fecha_inicio;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public String getNombre_plan() {
        return nombre_plan;
    }

    public void setNombre_plan(String nombre_plan) {
        this.nombre_plan = nombre_plan;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

}
