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

    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;
    private List<Curso> cursos;
    private List<ServicioAdicional> serviciosAdicionales;
    private List<Matricula> matriculas;

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
}