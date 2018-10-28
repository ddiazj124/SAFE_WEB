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
public class Trabajador {
    private String rut_trabajador;
    private int id_perfil;
    private String rut_empresa;
    private String nombre;
    private String Apellido;

    public Trabajador() {
    }

    public Trabajador(String rut_trabajador, int id_perfil, String rut_empresa, String nombre, String Apellido) {
        this.rut_trabajador = rut_trabajador;
        this.id_perfil = id_perfil;
        this.rut_empresa = rut_empresa;
        this.nombre = nombre;
        this.Apellido = Apellido;
    }

    public String getRut_trabajador() {
        return rut_trabajador;
    }

    public void setRut_trabajador(String rut_trabajador) {
        this.rut_trabajador = rut_trabajador;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getRut_empresa() {
        return rut_empresa;
    }

    public void setRut_empresa(String rut_empresa) {
        this.rut_empresa = rut_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
    
}
