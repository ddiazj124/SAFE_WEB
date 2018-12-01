package Interface;

import VO.AsistenciaVO;
import java.util.List;

public interface CRUDAsistencia {
    public List listar();
    public List<AsistenciaVO> list(int id);
    public boolean add(AsistenciaVO asi);
    public boolean edit(AsistenciaVO asi);
    public boolean delete(int id);
     public List<AsistenciaVO> list2(int id);
    
}
