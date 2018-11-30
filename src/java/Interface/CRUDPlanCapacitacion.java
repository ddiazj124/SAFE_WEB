package Interface;

import VO.PlanCapacitacionVO;
import java.util.List;

public interface CRUDPlanCapacitacion {
    public List listar();
    public PlanCapacitacionVO list(int id);
    public boolean add(PlanCapacitacionVO plan);
    public boolean edit(PlanCapacitacionVO plan);
    public boolean delete(int id);
    
}
