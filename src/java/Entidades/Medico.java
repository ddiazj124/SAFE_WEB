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
public class Medico {
    private String rut_medico;
    private int id_perfil;
    private String nombre;
    private String apellido;

    public Medico() {
    }

    public Medico(String rut_medico) {
        this.rut_medico = rut_medico;
    }
    

    public Medico(String rut_medico, int id_perfil, String nombre, String apellido) {
        this.rut_medico = rut_medico;
        this.id_perfil = id_perfil;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getRut_medico() {
        return rut_medico;
    }

    public void setRut_medico(String rut_medico) {
        this.rut_medico = rut_medico;
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
