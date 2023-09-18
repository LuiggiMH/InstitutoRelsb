package sys.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import sys.dao.AlumnoDAO;
import sys.impl.AlumnoDAOImpl;
import sys.modelo.Alumno;

@ManagedBean   //Controlador
@Named(value = "alumnoBean")
@ViewScoped
public class AlumnoBean {

    private Alumno alumno = null;
    private List<Alumno> alumnos = null;

    public AlumnoBean() {
    }

    //Establecer las acciones sobre la vista
    public List<Alumno> getAlumnos() {
        AlumnoDAO datos = new AlumnoDAOImpl();
        this.alumnos = datos.select();
        return alumnos;
    }

    public void prepareAlumno() {
        this.alumno = new Alumno(); 
    }

    public void insertAlumno() {
        AlumnoDAO datos = new AlumnoDAOImpl();
        datos.insert(alumno);
    }

    public void updateAlumno() {
        AlumnoDAO datos = new AlumnoDAOImpl();
        datos.update(alumno);
        this.alumno = new Alumno();
    }

    public void deleteAlumno() {
        AlumnoDAO datos = new AlumnoDAOImpl();
        datos.delete(alumno);
        this.alumno = new Alumno();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

}
