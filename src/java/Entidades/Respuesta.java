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
public class Respuesta {
    private int idRespuesta;
    private int idPregunta;
    private String detalleRespuesta;

    public Respuesta() {
    }

    public Respuesta(int idRespuesta, int idPregunta, String detalleRespuesta) {
        this.idRespuesta = idRespuesta;
        this.idPregunta = idPregunta;
        this.detalleRespuesta = detalleRespuesta;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDetalleRespuesta() {
        return detalleRespuesta;
    }

    public void setDetalleRespuesta(String detalleRespuesta) {
        this.detalleRespuesta = detalleRespuesta;
    }
    
    
}
