package co.uniquindio.edu.co.parcial1.model;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Academia {
    private static Academia instancia;
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

    public static Academia getInstancia() {
        return instancia;
    }

    public static void setInstancia(Academia instancia) {
        Academia.instancia = instancia;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
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

    public double calcularIngresos(LocalDate fechaInicio, LocalDate fechaFin) {
        double total = 0;
        for (Matricula m : matriculas) {
            if (!m.getFecha().isBefore(fechaInicio) && !m.getFecha().isAfter(fechaFin)) {
                total += m.getValorFinal();
            }
        }
        return total;
    }
}