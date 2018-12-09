package VO;

import java.sql.Date;

public class EvaPer_TerVO {
    private String  TITULO_EVA;
    private String  RAZON_SOCIAL;
    private String  RUT_EMPRESA;
    private Date    FECHA_EVAL;
    private String  DESCRIPCION_EVA;
    private String  DESCRIPCION_EVA_TER;
    private String  ESTADO_EVA;
    private String  DESCRIPCION_EVA_PERS;
    private String  RUT_TRABAJADOR;

    public EvaPer_TerVO(){
        
    }
    
    public EvaPer_TerVO(String TITULO_EVA, String RAZON_SOCIAL, String RUT_EMPRESA, Date FECHA_EVAL, 
            String DESCRIPCION_EVA, String DESCRIPCION_EVA_TER, String ESTADO_EVA, String DESCRIPCION_EVA_PERS, 
            String RUT_TRABAJADOR) {
        this.TITULO_EVA             = TITULO_EVA;
        this.RAZON_SOCIAL           = RAZON_SOCIAL;
        this.RUT_EMPRESA            = RUT_EMPRESA;
        this.FECHA_EVAL             = FECHA_EVAL;
        this.DESCRIPCION_EVA        = DESCRIPCION_EVA;
        this.DESCRIPCION_EVA_TER    = DESCRIPCION_EVA_TER;
        this.ESTADO_EVA             = ESTADO_EVA;
        this.DESCRIPCION_EVA_PERS   = DESCRIPCION_EVA_PERS;
        this.RUT_TRABAJADOR         = RUT_TRABAJADOR;
    }

    public String getDESCRIPCION_EVA_TER() {
        return DESCRIPCION_EVA_TER;
    }

    public void setDESCRIPCION_EVA_TER(String DESCRIPCION_EVA_TER) {
        this.DESCRIPCION_EVA_TER = DESCRIPCION_EVA_TER;
    }

    public String getRAZON_SOCIAL() {
        return RAZON_SOCIAL;
    }

    public void setRAZON_SOCIAL(String RAZON_SOCIAL) {
        this.RAZON_SOCIAL = RAZON_SOCIAL;
    }
    

    public String getTITULO_EVA() {
        return TITULO_EVA;
    }

    public void setTITULO_EVA(String TITULO_EVA) {
        this.TITULO_EVA = TITULO_EVA;
    }

    public String getRUT_EMPRESA() {
        return RUT_EMPRESA;
    }

    public void setRUT_EMPRESA(String RUT_EMPRESA) {
        this.RUT_EMPRESA = RUT_EMPRESA;
    }

    public Date getFECHA_EVAL() {
        return FECHA_EVAL;
    }

    public void setFECHA_EVAL(Date FECHA_EVAL) {
        this.FECHA_EVAL = FECHA_EVAL;
    }

    public String getDESCRIPCION_EVA() {
        return DESCRIPCION_EVA;
    }

    public void setDESCRIPCION_EVA(String DESCRIPCION_EVA) {
        this.DESCRIPCION_EVA = DESCRIPCION_EVA;
    }

    public String getESTADO_EVA() {
        return ESTADO_EVA;
    }

    public void setESTADO_EVA(String ESTADO_EVA) {
        this.ESTADO_EVA = ESTADO_EVA;
    }

    public String getDESCRIPCION_EVA_PERS() {
        return DESCRIPCION_EVA_PERS;
    }

    public void setDESCRIPCION_EVA_PERS(String DESCRIPCION_EVA_PERS) {
        this.DESCRIPCION_EVA_PERS = DESCRIPCION_EVA_PERS;
    }

    public String getRUT_TRABAJADOR() {
        return RUT_TRABAJADOR;
    }

    public void setRUT_TRABAJADOR(String RUT_TRABAJADOR) {
        this.RUT_TRABAJADOR = RUT_TRABAJADOR;
    }
    
    
}
