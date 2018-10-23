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
public class Tipo_Eval {
    private int id_tipo;
    private String nombre_evaluacion;

    public Tipo_Eval() {
    }

    public Tipo_Eval(int id_tipo, String nombre_evaluacion) {
        this.id_tipo = id_tipo;
        this.nombre_evaluacion = nombre_evaluacion;
    }

    public Tipo_Eval(String nombre_evaluacion) {
        this.nombre_evaluacion = nombre_evaluacion;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_evaluacion() {
        return nombre_evaluacion;
    }

    public void setNombre_evaluacion(String nombre_evaluacion) {
        this.nombre_evaluacion = nombre_evaluacion;
    }
    
    
}
