package VO;

public class EvaluacionLiteVO {
private int     id;
private String  titulo;

    public EvaluacionLiteVO(){
        
    }
    
    public EvaluacionLiteVO(int id, String titulo) {
        this.id        = id;
        this.titulo    = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
