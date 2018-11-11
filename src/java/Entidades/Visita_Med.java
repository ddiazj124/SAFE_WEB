/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastian
 */
public class Visita_Med {
    private int id_visita;
    private String rut_medico;
    private String rut_trabajador;
    private String motivo_consulta;
    private String observaciones;
    private String diagnostico;
    private String fecha_visita;
    private char estado;
    private String receta;

    public Visita_Med() {
    }

    public Visita_Med(int id_visita, String rut_medico, String rut_trabajador, String motivo_consulta, String observaciones, String diagnostico, String fecha_visita, char estado, String receta) {
        this.id_visita = id_visita;
        this.rut_medico = rut_medico;
        this.rut_trabajador = rut_trabajador;
        this.motivo_consulta = motivo_consulta;
        this.observaciones = observaciones;
        this.diagnostico = diagnostico;
        this.fecha_visita = fecha_visita;
        this.estado = estado;
        this.receta = receta;
    }

    public Visita_Med(int id_visita) {
        this.id_visita = id_visita;
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

    public String getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(String fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }
    
    
    
    
}
