package VO;

public class ObservacionVO {
private int     ID_OBSERVACION;
private int     ID_EVALUACION;
private String  DETALLE_OBSERVACION;

public ObservacionVO(){
    
}

    public int getID_OBSERVACION() {
        return ID_OBSERVACION;
    }

    public void setID_OBSERVACION(int ID_OBSERVACION) {
        this.ID_OBSERVACION = ID_OBSERVACION;
    }

    public int getID_EVALUACION() {
        return ID_EVALUACION;
    }

    public void setID_EVALUACION(int ID_EVALUACION) {
        this.ID_EVALUACION = ID_EVALUACION;
    }

    public String getDETALLE_OBSERVACION() {
        return DETALLE_OBSERVACION;
    }

    public void setDETALLE_OBSERVACION(String DETALLE_OBSERVACION) {
        this.DETALLE_OBSERVACION = DETALLE_OBSERVACION;
    }


    public ObservacionVO(int ID_OBSERVACION, int ID_EVALUACION, String DETALLE_OBSERVACION) {
        this.ID_OBSERVACION = ID_OBSERVACION;
        this.ID_EVALUACION = ID_EVALUACION;
        this.DETALLE_OBSERVACION = DETALLE_OBSERVACION;
    }


        


}
