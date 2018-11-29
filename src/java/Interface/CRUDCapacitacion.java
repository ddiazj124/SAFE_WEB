package Interface;

import Entidades.Capacitacion;
import VO.CapacitacionVO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface CRUDCapacitacion {
    public List listar();
    public CapacitacionVO list(int id);
    public boolean add(CapacitacionVO cap);
    public boolean edit(CapacitacionVO cap);
    public boolean delete(int id);
    
}
