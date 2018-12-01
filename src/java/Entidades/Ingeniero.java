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
public class Ingeniero {
    private String rut_ingeniero;
    private int id_perfil;
    private String nombre;
    private String apellido;

    public Ingeniero() {
    }

    public Ingeniero(String rut_ingeniero, int id_perfil, String nombre, String apellido) {
        this.rut_ingeniero = rut_ingeniero;
        this.id_perfil = id_perfil;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getRut_ingeniero() {
        return rut_ingeniero;
    }

    public void setRut_ingeniero(String rut_ingeniero) {
        this.rut_ingeniero = rut_ingeniero;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
}
