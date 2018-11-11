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
public class Supervisor {
    private String rut_supervisor;
    private int id_perfil;
    private String nombre;
    private String apellido;

    public Supervisor() {
    }

    public Supervisor(String rut_supervisor, int id_perfil, String nombre, String apellido) {
        this.rut_supervisor = rut_supervisor;
        this.id_perfil = id_perfil;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getRut_supervisor() {
        return rut_supervisor;
    }

    public void setRut_supervisor(String rut_supervisor) {
        this.rut_supervisor = rut_supervisor;
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
