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
public class EvaluacionTerreno {
    private  int id;
    private String descripcion;
    private int id_tipo;
    private int id_evaluacion;
    
    public EvaluacionTerreno() {
    }

    public EvaluacionTerreno(int id, String descripcion, int id_tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.id_tipo = id_tipo;
    }

    public EvaluacionTerreno(int id, String descripcion, int id_tipo, int id_evaluacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.id_tipo = id_tipo;
        this.id_evaluacion = id_evaluacion;
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

    public int getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(int id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
    }
    
    
}
