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
public class Certificado {
private int id_certificado;
private String nombre_certificado;
private int id_participante;
private int id_capacitacion;

    public Certificado() {
    }

    public Certificado(int id_certificado, String nombre_certificado, int id_participante, int id_capacitacion) {
        this.id_certificado = id_certificado;
        this.nombre_certificado = nombre_certificado;
        this.id_participante = id_participante;
        this.id_capacitacion = id_capacitacion;
    }

    public int getId_certificado() {
        return id_certificado;
    }

    public void setId_certificado(int id_certificado) {
        this.id_certificado = id_certificado;
    }

    public String getNombre_certificado() {
        return nombre_certificado;
    }

    public void setNombre_certificado(String nombre_certificado) {
        this.nombre_certificado = nombre_certificado;
    }

    public int getId_participante() {
        return id_participante;
    }

    public void setId_participante(int id_participante) {
        this.id_participante = id_participante;
    }

    public int getId_capacitacion() {
        return id_capacitacion;
    }

    public void setId_capacitacion(int id_capacitacion) {
        this.id_capacitacion = id_capacitacion;
    }


}
