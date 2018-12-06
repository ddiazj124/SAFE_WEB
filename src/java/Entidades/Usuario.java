/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.sql.Timestamp;

/**
 *
 * @author Diego
 */
public class Usuario {
    private int id_usuario;
    private String nombre_usuario;
    private String contrasena;
    private String correo_electronico;
    private Timestamp create_at;
    private Timestamp update_at;
    private String rut_trabajador;
    private int id_perfil;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_usuario, String contrasena, String correo_electronico, Timestamp create_at, Timestamp update_at, String rut_trabajador, int id_perfil) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.correo_electronico = correo_electronico;
        this.create_at = create_at;
        this.update_at = update_at;
        this.rut_trabajador = rut_trabajador;
        this.id_perfil = id_perfil;
    }

    public Usuario(int id_usuario, String nombre_usuario, String contrasena, int id_perfil) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.id_perfil = id_perfil;
    }
    
    public Usuario(int id_usuario, String nombre_usuario, String contrasena, int id_perfil,String correo_electronico) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.id_perfil = id_perfil;
        this.correo_electronico = correo_electronico;
    }
    
    
    
    

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
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
}
