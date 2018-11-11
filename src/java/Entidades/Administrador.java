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
public class Administrador {

private String rut_administrador;
private int id_perfil;
private String nombre;
private String apellido;

    public Administrador() {
    }

    public Administrador(String rut_administrador, int id_perfil, String nombre, String apellido) {
        this.rut_administrador = rut_administrador;
        this.id_perfil = id_perfil;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getRut_administrador() {
        return rut_administrador;
    }

    public void setRut_administrador(String rut_administrador) {
        this.rut_administrador = rut_administrador;
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
