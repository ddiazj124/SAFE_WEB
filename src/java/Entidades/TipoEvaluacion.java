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
public class TipoEvaluacion {
    private int tipo_evaluacion;
    private String nombre_evaluacion;

    public TipoEvaluacion() {
    }

    public TipoEvaluacion(int tipo_evaluacion, String nombre_evaluacion) {
        this.tipo_evaluacion = tipo_evaluacion;
        this.nombre_evaluacion = nombre_evaluacion;
    }

    public int getTipo_evaluacion() {
        return tipo_evaluacion;
    }

    public void setTipo_evaluacion(int tipo_evaluacion) {
        this.tipo_evaluacion = tipo_evaluacion;
    }

    public String getNombre_evaluacion() {
        return nombre_evaluacion;
    }

    public void setNombre_evaluacion(String nombre_evaluacion) {
        this.nombre_evaluacion = nombre_evaluacion;
    }
    
    
   
}
