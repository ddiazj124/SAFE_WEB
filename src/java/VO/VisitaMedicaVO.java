package VO;

import java.sql.Date;

public class VisitaMedicaVO {
private int     id_visita;
private String  rut_medico;
private String  rut_trabajador;
private String  motivo_consulta;
private String  observaciones;
private String  diagnostico;
private Date    fecha_visita;
private int     estado;
private String  estado_descripcion;
private String  receta;

    public VisitaMedicaVO() {
    }

    public VisitaMedicaVO(int id_visita, String rut_medico, String rut_trabajador, String motivo_consulta, String observaciones
                            , String diagnostico, Date fecha_visita, int estado,String estado_descripcion, String receta) {
        this.id_visita          = id_visita;
        this.rut_medico         = rut_medico;
        this.rut_trabajador     = rut_trabajador;
        this.motivo_consulta    = motivo_consulta;
        this.observaciones      = observaciones;
        this.diagnostico        = diagnostico;
        this.fecha_visita       = fecha_visita;
        this.estado             = estado;
        this.estado_descripcion = estado_descripcion;
        this.receta             = receta;
    }

    public String getEstado_descripcion() {
        return estado_descripcion;
    }

    public void setEstado_descripcion(String estado_descripcion) {
        this.estado_descripcion = estado_descripcion;
    }

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }

    public String getRut_medico() {
        return rut_medico;
    }

    public void setRut_medico(String rut_medico) {
        this.rut_medico = rut_medico;
    }

    public String getRut_trabajador() {
        return rut_trabajador;
    }

    public void setRut_trabajador(String rut_trabajador) {
        this.rut_trabajador = rut_trabajador;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(Date fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    
}
