package VO;

import java.sql.Date;

public class AsistenciaVO {
private int     id_asistencia;
private int     capacitacion_id;
private String  nombre_capacitacion;
private String  rut_trabajador;
private String  nombre_trabajador;
private String  apellido_trabajador;
private int     estado_id;
private String  estado_asistencia;
private Date    fecha_asistencia;
private String  lugar;

    public AsistenciaVO() {
    }

    public String getNombre_capacitacion() {
        return nombre_capacitacion;
    }

    public void setNombre_capacitacion(String nombre_capacitacion) {
        this.nombre_capacitacion = nombre_capacitacion;
    }

    public String getNombre_trabajador() {
        return nombre_trabajador;
    }

    public void setNombre_trabajador(String nombre_trabajador) {
        this.nombre_trabajador = nombre_trabajador;
    }

    public String getApellido_trabajador() {
        return apellido_trabajador;
    }

    public void setApellido_trabajador(String apellido_trabajador) {
        this.apellido_trabajador = apellido_trabajador;
    }

    public AsistenciaVO(int id_asistencia, int capacitacion_id, String nombre_capacitacion, String rut_trabajador, 
                        String  nombre_trabajador, String  apellido_trabajador, int estado_id, String estado_asistencia,
                        Date fecha_asistencia, String lugar) {
        this.id_asistencia          = id_asistencia;  
        this.capacitacion_id        = capacitacion_id;
        this.nombre_capacitacion    = nombre_capacitacion;
        this.rut_trabajador         = rut_trabajador;
        this.nombre_capacitacion    = nombre_capacitacion;
        this.apellido_trabajador    = apellido_trabajador;
        this.estado_id              = estado_id;
        this.estado_asistencia      = estado_asistencia;
        this.fecha_asistencia       = fecha_asistencia; 
        this.lugar                  = lugar;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
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
