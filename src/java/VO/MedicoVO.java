package VO;

public class MedicoVO {
private String  rut_medico;
private int     id_perfil;
private String  perfil_descripcion;
private String  nombre;
private String  apellido;
private String  correo;

    public MedicoVO(){
        
    }
    
    public MedicoVO(String rut_medico, int id_perfil, String perfil_descripcion
                , String nombre, String apellido, String correo) {
        this.rut_medico         = rut_medico;
        this.id_perfil          = id_perfil;
        this.perfil_descripcion = perfil_descripcion;
        this.nombre             = nombre;
        this.apellido           = apellido;
        this.correo             = correo;
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

    public String getPerfil_descripcion() {
        return perfil_descripcion;
    }

    public void setPerfil_descripcion(String perfil_descripcion) {
        this.perfil_descripcion = perfil_descripcion;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
