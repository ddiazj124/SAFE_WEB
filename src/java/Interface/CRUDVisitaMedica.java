package Interface;

import VO.VisitaMedicaVO;
import java.util.List;

public interface CRUDVisitaMedica {
    public List listar();
    public VisitaMedicaVO list(int id);
    public boolean add(VisitaMedicaVO vis);
    public boolean edit(VisitaMedicaVO vis);
    public boolean delete(int id);
    
}
