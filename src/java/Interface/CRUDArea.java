package Interface;

import Entidades.Area;
import java.util.List;

public interface CRUDArea {
    public List listar();
    public Area list(int id);
    public boolean add(Area are);
    public boolean edit(Area are);
    public boolean delete(int id);
    
    public String getCorreoPorRut(String rutMedico);
}
