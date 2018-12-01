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
public class Evaluacion {
    private int id_ev;
    private String titulo;
    private int id_tipo;
    private String rut_empresa;
    private String fecha_eval;
    private String descripcion;
    private int evaluacion_estado_id;
    private String rut_tecnico;
    private String rut_ingeniero;
    private String razon_social;

    public Evaluacion() {
    }
    
    public Evaluacion(int id_ev, String titulo, String rut_empresa, String fecha_eval, String descripcion, int evaluacion_estado_id, String rut_tecnico, String rut_ingeniero) {
        this.id_ev = id_ev;
        this.titulo = titulo;
        this.rut_empresa = rut_empresa;
        this.fecha_eval = fecha_eval;
        this.descripcion = descripcion;
        this.evaluacion_estado_id = evaluacion_estado_id;
        this.rut_tecnico = rut_tecnico;
        this.rut_ingeniero = rut_ingeniero;
    }

    public Evaluacion(int id_ev, String titulo, int id_tipo, String rut_empresa, String fecha_eval, String descripcion, int evaluacion_estado_id) {
        this.id_ev = id_ev;
        this.titulo = titulo;
        this.id_tipo = id_tipo;
        this.rut_empresa = rut_empresa;
        this.fecha_eval = fecha_eval;
        this.descripcion = descripcion;
        this.evaluacion_estado_id = evaluacion_estado_id;
    }

    public Evaluacion(String titulo,String fecha_eval,String descripcion,String razonSocial) {
        this.titulo = titulo;
        this.fecha_eval = fecha_eval;
        this.descripcion = descripcion;
        this.razon_social = razonSocial;
    }
    
    public Evaluacion(String titulo, int id_tipo, String rut_empresa, String fecha_eval, String descripcion, int evaluacion_estado_id) {
        this.titulo = titulo;
        this.id_tipo = id_tipo;
        this.rut_empresa = rut_empresa;
        this.fecha_eval = fecha_eval;
        this.descripcion = descripcion;
        this.evaluacion_estado_id = evaluacion_estado_id;
    }

    public int getId_ev() {
        return id_ev;
    }

    public void setId_ev(int id_ev) {
        this.id_ev = id_ev;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getRut_empresa() {
        return rut_empresa;
    }

    public void setRut_empresa(String rut_empresa) {
        this.rut_empresa = rut_empresa;
    }

    public String getFecha_eval() {
        return fecha_eval;
    }

    public void setFecha_eval(String fecha_eval) {
        this.fecha_eval = fecha_eval;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEvaluacion_estado_id() {
        return evaluacion_estado_id;
    }

    public void setEvaluacion_estado_id(int evaluacion_estado_id) {
        this.evaluacion_estado_id = evaluacion_estado_id;
    }
    
    public String getRut_tecnico() {
        return rut_tecnico;
    }

    public void setRut_tecnico(String rut_tecnico) {
        this.rut_tecnico = rut_tecnico;
    }

    public String getRut_ingeniero() {
        return rut_ingeniero;
    }

    public void setRut_ingeniero(String rut_ingeniero) {
        this.rut_ingeniero = rut_ingeniero;
    }

    public String getRazon_social() {
        return razon_social;
    }
    
    
}
