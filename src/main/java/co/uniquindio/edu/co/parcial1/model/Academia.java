package co.uniquindio.edu.co.parcial1.model;
import java.util.List;
import java.util.ArrayList;

public class Academia {

    public static Academia instancia;

    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefono;
    private String correo;
    private String paginaWeb;

    private final List<Estudiante> estudiantes;
    private final List<Profesor> profesores;
    private final List<Curso> cursos;
    private final List<ServicioAdicional> serviciosAdicionales;
    private final List<Matricula> matriculas;

    private Academia() {
        estudiantes = new ArrayList<>();
        profesores = new ArrayList<>();
        cursos = new ArrayList<>();
        serviciosAdicionales = new ArrayList<>();
        matriculas = new ArrayList<>();
    }

    public static Academia getInstance(){
        if (instancia==null){
            instancia=new Academia();
        }
        return instancia;
    }
    public void agregarEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }
    public void agregarProfesor(Profesor profesor){
        profesores.add(profesor);
    }
    public void agregarCurso(Curso curso){
        cursos.add(curso);
    }
    public void agregarServicioAdicional(ServicioAdicional servicioAdicional){
        serviciosAdicionales.add(servicioAdicional);
    }
    public void agregarMatricula(Matricula matricula){
        matriculas.add(matricula);
    }
    public Estudiante buscarEstudiante(int numeroIdentidad){
        for(Estudiante estudiante:estudiantes){
            if(estudiante.getNumeroIdentidad()==numeroIdentidad){
                return estudiante;
            }
        }
        return null;

    }
    public Profesor buscarProfesor(int identificacion){
        for(Profesor profesor:profesores){
            if(profesor.getIdentificacion()==identificacion){
                return profesor;
            }
        }
        return null;

    }
}