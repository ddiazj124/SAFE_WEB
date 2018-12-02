package Interface;

import Entidades.Area;
import VO.EvaluacionLiteVO;
import VO.EvaluacionVO;
import java.util.List;

public interface CRUDEvaluacion {
    public List listar();
    public EvaluacionVO list(int id);
    public List<EvaluacionLiteVO> listLite(String rutEmpresa);
    public boolean add(EvaluacionVO are);
    public boolean edit(EvaluacionVO are);
    public boolean delete(int id);
    
}
