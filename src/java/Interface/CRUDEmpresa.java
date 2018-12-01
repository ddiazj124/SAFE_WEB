package Interface;

import Entidades.Area;
import VO.EmpresaVO;
import java.util.List;

public interface CRUDEmpresa {
    public List listar();
    public EmpresaVO list(int id);
    public boolean add(EmpresaVO emp);
    public boolean edit(EmpresaVO emp);
    public boolean delete(int id);
    
}
