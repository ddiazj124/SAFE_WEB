package Interface;

import Entidades.Area;
import VO.EvaPer_TerVO;
import VO.EvaluacionLiteVO;
import VO.EvaluacionVO;
import VO.Pregunta_RespuestaVO;
import java.util.List;

public interface CRUDEvaluacion {
    public List listar();
    public EvaluacionVO list(int id);
    public List<EvaluacionLiteVO> listLite(String rutEmpresa);
    public boolean add(EvaluacionVO are);
    public boolean edit(EvaluacionVO are);
    public boolean delete(int id);
    
    public EvaPer_TerVO EvaPersonaPorId(int id);
    public EvaPer_TerVO EvaTerrenoPorId(int id);
    
    public List<Pregunta_RespuestaVO> Pregunta_RespuestaPorIdEva(int id);
    
    public int getEvaPer(int id);
    public int getEvaTer(int id);
    
    public List<EvaluacionLiteVO> listLiteProcesadaPersona(String rutEmpresa);
    public List<EvaluacionLiteVO> listLiteProcesadaTerreno(String rutEmpresa);    
    
    public boolean finalizarEvaluacion(int id);
}
