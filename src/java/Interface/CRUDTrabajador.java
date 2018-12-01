package Interface;

import VO.TrabajadorVO;
import java.util.List;

public interface CRUDTrabajador {
    public List listar();
    public List listarPorRutEmpresa(String rutEmpresa);
    public TrabajadorVO list(String ruTrabajador);
    public boolean add(TrabajadorVO vo);
    public boolean edit(TrabajadorVO vo);
    public boolean delete(int id);
    
}
