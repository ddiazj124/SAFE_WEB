package VO;

public class EmpresaVO {
private String  rut_empresa;
private String  razon_social;
private int     id_perfil;
private String  nombre_perfil;
private String  direccion;

    public EmpresaVO(){
        
    }
    
    public EmpresaVO(String rut_empresa, String razon_social, int id_perfil,
                    String nombre_perfil, String direccion) {
        this.rut_empresa    = rut_empresa;
        this.razon_social   = razon_social;
        this.id_perfil      = id_perfil;
        this.nombre_perfil  = nombre_perfil;
        this.direccion      = direccion;
    }

    public String getRut_empresa() {
        return rut_empresa;
    }

    public void setRut_empresa(String rut_empresa) {
        this.rut_empresa = rut_empresa;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
