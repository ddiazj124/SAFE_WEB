package VO;

import java.sql.Date;

public class CapacitacionVO {
private int     id_capacitacion;
private String  nombre_capacitación;
private Date    fecha_termino;
private Date    fecha_inicio;
private int     id_area;
private int     id_plan;
private String  area;
private String  plan;

    public CapacitacionVO() {
    }

    public CapacitacionVO(int id_capacitacion, String nombre_capacitación, Date fecha_termino, Date fecha_inicio, 
                            int id_area, int id_plan, String area, String plan) {
        this.id_capacitacion        = id_capacitacion;
        this.nombre_capacitación    = nombre_capacitación;
        this.fecha_termino          = fecha_termino;
        this.fecha_inicio           = fecha_inicio;
        this.id_area                = id_area;
        this.id_plan                = id_plan;
        this.area                   = area;
        this.plan                   = plan;
    }

    public int getId_capacitacion() {
        return id_capacitacion;
    }

    public void setId_capacitacion(int id_capacitacion) {
        this.id_capacitacion = id_capacitacion;
    }

    public String getNombre_capacitación() {
        return nombre_capacitación;
    }

    public void setNombre_capacitación(String nombre_capacitación) {
        this.nombre_capacitación = nombre_capacitación;
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

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

     public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
