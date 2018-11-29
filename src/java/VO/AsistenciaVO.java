package VO;

import java.sql.Date;

public class AsistenciaVO {
private int     id_asistencia;
private int     capacitacion_id;
private String  rut_trabajador;
private int     estado_id;
private String  estado_asistencia;
private Date    fecha_asistencia;

    public AsistenciaVO() {
    }

    public AsistenciaVO(int id_asistencia, int capacitacion_id,  String rut_trabajador, int estado_id
                        , String estado_asistencia, Date fecha_asistencia) {
        this.id_asistencia      = id_asistencia;  
        this.capacitacion_id    = capacitacion_id;
        this.rut_trabajador     = rut_trabajador;
        this.estado_id          = estado_id;
        this.estado_asistencia  = estado_asistencia;
        this.fecha_asistencia   = fecha_asistencia;              
    }

    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public int getCapacitacion_id() {
        return capacitacion_id;
    }

    public void setCapacitacion_id(int capacitacion_id) {
        this.capacitacion_id = capacitacion_id;
    }

    public String getRut_trabajador() {
        return rut_trabajador;
    }

    public void setRut_trabajador(String rut_trabajador) {
        this.rut_trabajador = rut_trabajador;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public String getEstado_asistencia() {
        return estado_asistencia;
    }

    public void setEstado_asistencia(String estado_asistencia) {
        this.estado_asistencia = estado_asistencia;
    }

    public Date getFecha_asistencia() {
        return fecha_asistencia;
    }

    public void setFecha_asistencia(Date fecha_asistencia) {
        this.fecha_asistencia = fecha_asistencia;
    }

}
