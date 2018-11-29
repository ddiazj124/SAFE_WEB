package Interface;

import VO.AsistenciaVO;
import java.util.List;

public interface CRUDAsistencia {
    public List listar();
    public AsistenciaVO list(int id);
    public boolean add(AsistenciaVO cap);
    public boolean edit(AsistenciaVO cap);
    public boolean delete(int id);
    
}
