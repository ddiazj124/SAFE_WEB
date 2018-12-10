package Interface;

import Entidades.Plan_Anual;
import VO.PlanAnualEmpresaVO;
import VO.PlanVO;
import java.util.List;

public interface CRUDPlanAnualEmpresa {
    public List listar();
    public PlanVO list(int id);
    public boolean add(PlanAnualEmpresaVO plan);
    public boolean edit(PlanAnualEmpresaVO plan);
    public boolean delete(int id);
    
}
