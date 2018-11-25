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
public class Evaluacion_Estado {
    private int evaluacion_estado_id;
    private int descripcion;

    public Evaluacion_Estado() {
    }

    public Evaluacion_Estado(int evaluacion_estado_id, int descripcion) {
        this.evaluacion_estado_id = evaluacion_estado_id;
        this.descripcion = descripcion;
    }

    public int getEvaluacion_estado_id() {
        return evaluacion_estado_id;
    }

    public void setEvaluacion_estado_id(int evaluacion_estado_id) {
        this.evaluacion_estado_id = evaluacion_estado_id;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
