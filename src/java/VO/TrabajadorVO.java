package VO;

public class TrabajadorVO {
private String  rut_trabajador;
private String  nombre;
private String  apellido;
private int     id_perfil;
private String  nombre_perfil;
private String  rut_empresa;
private String  razon_social_empresa;

    public TrabajadorVO(){
        
    }
    
    public TrabajadorVO(    String  rut_trabajador,
                            String  nombre,
                            String  apellido,
                            int     id_perfil,
                            String  nombre_perfil,
                            String  rut_empresa,
                            String  razon_social_empresa) {
        this.rut_trabajador        = rut_trabajador;
        this.nombre    = nombre;
        this.apellido = apellido;
        this.id_perfil = id_perfil;
        this.nombre_perfil = nombre_perfil;
        this.rut_empresa = rut_empresa;
        this.razon_social_empresa = razon_social_empresa;       
    }

    public String getRut_trabajador() {
        return rut_trabajador;
    }

    public void setRut_trabajador(String rut_trabajador) {
        this.rut_trabajador = rut_trabajador;
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

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNombre_perfil() {
        return nombre_perfil;
    }

    public void setNombre_perfil(String nombre_perfil) {
        this.nombre_perfil = nombre_perfil;
    }

    public String getRut_empresa() {
        return rut_empresa;
    }

    public void setRut_empresa(String rut_empresa) {
        this.rut_empresa = rut_empresa;
    }

    public String getRazon_social_empresa() {
        return razon_social_empresa;
    }

    public void setRazon_social_empresa(String razon_social_empresa) {
        this.razon_social_empresa = razon_social_empresa;
    }

   

}
