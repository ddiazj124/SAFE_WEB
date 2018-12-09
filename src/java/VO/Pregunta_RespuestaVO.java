package VO;

public class Pregunta_RespuestaVO {

    public Pregunta_RespuestaVO(){
        
    }
    
    public Pregunta_RespuestaVO(String DETALLE_PREGUNTA, String DETALLE_RESPUESTA) {
        this.DETALLE_PREGUNTA = DETALLE_PREGUNTA;
        this.DETALLE_RESPUESTA = DETALLE_RESPUESTA;
    }
    private String DETALLE_PREGUNTA;
    private String DETALLE_RESPUESTA;

    public String getDETALLE_PREGUNTA() {
        return DETALLE_PREGUNTA;
    }

    public void setDETALLE_PREGUNTA(String DETALLE_PREGUNTA) {
        this.DETALLE_PREGUNTA = DETALLE_PREGUNTA;
    }

    public String getDETALLE_RESPUESTA() {
        return DETALLE_RESPUESTA;
    }

    public void setDETALLE_RESPUESTA(String DETALLE_RESPUESTA) {
        this.DETALLE_RESPUESTA = DETALLE_RESPUESTA;
    }

    public Pregunta_RespuestaVO(String DETALLE_PREGUNTA) {
        this.DETALLE_PREGUNTA = DETALLE_PREGUNTA;
    }

}
