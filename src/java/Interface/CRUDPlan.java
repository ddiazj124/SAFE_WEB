package Interface;

import Entidades.Plan_Anual;
import VO.PlanVO;
import java.util.List;

public interface CRUDPlan {
    public List listar();
    public PlanVO list(int id);
    public boolean add(Plan_Anual plan);
    public boolean edit(Plan_Anual plan);
    public boolean delete(int id);
    
}
