package Interface;

import Entidades.Area;
import VO.EvaPer_TerVO;
import VO.EvaluacionLiteVO;
import VO.EvaluacionVO;
import VO.ObservacionVO;
import VO.Pregunta_RespuestaVO;
import java.util.List;

public interface CRUDObservacion {
    public List listar();
    public ObservacionVO list(int id);
    public List<ObservacionVO> listLite(String rutIngeniero);
    public boolean add(ObservacionVO obs);
    public boolean edit(ObservacionVO obs);
    public boolean delete(int id);
}
