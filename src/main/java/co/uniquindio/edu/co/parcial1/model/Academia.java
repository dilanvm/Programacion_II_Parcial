package co.uniquindio.edu.co.parcial1.model;
import java.util.List;
import.java.util.ArrayList;


public class Academia {
    public static Academia instancia;
    private List<Estudiante> estudiantes;
    private List<Profesor> profesores;
    private List<Curso> cursos;
    private List<ServicioAdicional> servicioAdicional;
    private List<Matricula> matriculas;

    private Academia(){}
    public static Academia getInstance(){
        if (instancia==null){
            instancia=new Academia();
        }
        return instancia;
    }
}
