/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Diego
 */
public class EvaluacionPersonal {
    private int id;
    private String descripcion;
    private int id_tipo;
    private String rut_trabajador;

    public EvaluacionPersonal() {
    }

    public EvaluacionPersonal(int id, String descripcion, int id_tipo, String rut_trabajador) {
        this.id = id;
        this.descripcion = descripcion;
        this.id_tipo = id_tipo;
        this.rut_trabajador = rut_trabajador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getRut_trabajador() {
        return rut_trabajador;
    }

    public void setRut_trabajador(String rut_trabajador) {
        this.rut_trabajador = rut_trabajador;
    }
    
    
}
