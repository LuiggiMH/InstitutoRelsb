package sys.dao;

import java.util.List;
import sys.modelo.Alumno;

public interface AlumnoDAO {
    
    public List<Alumno> select();
    public void insert(Alumno alumno);
    public void update(Alumno alumno);
    public void delete(Alumno alumno);
}