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
public class Participante {
    private int id_participante;
    private String rut_trabajador;

    public Participante() {
    }

    public Participante(int id_participante, String rut_trabajador) {
        this.id_participante = id_participante;
        this.rut_trabajador = rut_trabajador;
    }

    public int getId_participante() {
        return id_participante;
    }

    public void setId_participante(int id_participante) {
        this.id_participante = id_participante;
    }

    public String getRut_trabajador() {
        return rut_trabajador;
    }

    public void setRut_trabajador(String rut_trabajador) {
        this.rut_trabajador = rut_trabajador;
    }
    
    
}
