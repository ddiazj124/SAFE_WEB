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
    private String descripcion;

    public Evaluacion() {
    }

    public Evaluacion(int id_ev, String titulo, int id_tipo, String rut_empresa, String descripcion) {
        this.id_ev = id_ev;
        this.titulo = titulo;
        this.id_tipo = id_tipo;
        this.rut_empresa = rut_empresa;
        this.descripcion = descripcion;
    }

    public Evaluacion(String titulo, int id_tipo, String rut_empresa, String descripcion) {
        this.titulo = titulo;
        this.id_tipo = id_tipo;
        this.rut_empresa = rut_empresa;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
