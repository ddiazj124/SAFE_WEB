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
public class Pregunta {
    private int idPregunta;
    private int idEv;
    private String detallePregunta;

    public Pregunta() {
    }

    public Pregunta(int idPregunta, int idEv, String detallePregunta) {
        this.idPregunta = idPregunta;
        this.idEv = idEv;
        this.detallePregunta = detallePregunta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdEv() {
        return idEv;
    }

    public void setIdEv(int idEv) {
        this.idEv = idEv;
    }

    public String getDetallePregunta() {
        return detallePregunta;
    }

    public void setDetallePregunta(String detallePregunta) {
        this.detallePregunta = detallePregunta;
    }
    
    
}
