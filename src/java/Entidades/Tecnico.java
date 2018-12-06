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
public class Tecnico {
    private String rut_tecnico;
    private int id_perfil;
    private String nombre;
    private String apellido;
    private String correo_electronico;

    public Tecnico() {
    }

    public Tecnico(String rut_tecnico, int id_perfil, String nombre, String apellido, String correo_electronico) {
        this.rut_tecnico = rut_tecnico;
        this.id_perfil = id_perfil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
    }
    
    

    public Tecnico(String rut_tecnico, int id_perfil, String nombre, String apellido) {
        this.rut_tecnico = rut_tecnico;
        this.id_perfil = id_perfil;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getRut_tecnico() {
        return rut_tecnico;
    }

    public void setRut_tecnico(String rut_tecnico) {
        this.rut_tecnico = rut_tecnico;
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

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    
    
    
    
}
