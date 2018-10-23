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
public class Examen {
    private int id_examen;
    private String observacion;
    private String resultado;
    private String fecha_visita;
    private int id_visita;

    public Examen() {
    }

    public Examen(int id_examen, String observacion, String resultado, String fecha_visita, int id_visita) {
        this.id_examen = id_examen;
        this.observacion = observacion;
        this.resultado = resultado;
        this.fecha_visita = fecha_visita;
        this.id_visita = id_visita;
    }

    public int getId_examen() {
        return id_examen;
    }

    public void setId_examen(int id_examen) {
        this.id_examen = id_examen;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(String fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public int getId_visita() {
        return id_visita;
    }

    public void setId_visita(int id_visita) {
        this.id_visita = id_visita;
    }
    
    
    
}
