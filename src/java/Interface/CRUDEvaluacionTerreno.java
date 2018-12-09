package Interface;

import Entidades.Area;
import VO.EvaluacionLiteVO;
import VO.EvaluacionVO;
import java.util.List;

public interface CRUDEvaluacionTerreno {
    public List listar();
    public EvaluacionLiteTerrenoVO list(int id);
    public List<EvaluacionLiteTerrenoVO> listLite(String rutEmpresa);
    public boolean add(EvaluacionVO are);
    public boolean edit(EvaluacionVO are);
    public boolean delete(int id);
    
}
