package sys.modelo;
// Generated 16/09/2023 20:32:27 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Profesor generated by hbm2java
 */
public class Profesor  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String direccion;
     private String telefono;
     private Set<Asignatura> asignaturas = new HashSet<Asignatura>(0);

    public Profesor() {
    }

	
    public Profesor(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    public Profesor(String nombre, String direccion, String telefono, Set<Asignatura> asignaturas) {
       this.nombre = nombre;
       this.direccion = direccion;
       this.telefono = telefono;
       this.asignaturas = asignaturas;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Set<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }
    
    public void setAsignaturas(Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }




}


