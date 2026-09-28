package co.uniquindio.edu.co.parcial1.viewController;

import co.uniquindio.edu.co.parcial1.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Inicializar datos de prueba para la sustentación y demostración
            cargarDatosIniciales();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AcademiaView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 950, 700);
            stage.setTitle("Academia de Idiomas - LenguajeCafetero (Programación II)");
            stage.setScene(scene);
            stage.setMinWidth(850);
            stage.setMinHeight(600);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga datos iniciales del dominio para que la interfaz gráfica
     * cuente con información precargada lista para probar y sustentar.
     */
    private void cargarDatosIniciales() {
        Academia academia = Academia.getInstance();

        // 1. Estudiantes de prueba
        Estudiante est1 = new Estudiante(
                "Dilan Ruiz", 10949001, 7451001,
                "dilan@uniquindio.edu.co", 20, LocalDate.now().minusDays(15));
        Estudiante est2 = new Estudiante(
                "Laura Morales", 10949002, 7451002,
                "laura@uniquindio.edu.co", 21, LocalDate.now().minusDays(10));
        Estudiante est3 = new Estudiante(
                "Mateo Gómez", 10949003, 7451003,
                "mateo@uniquindio.edu.co", 22, LocalDate.now().minusDays(5));

        academia.agregarEstudiante(est1);
        academia.agregarEstudiante(est2);
        academia.agregarEstudiante(est3);

        // 2. Profesores de prueba
        Profesor prof1 = new Profesor("Carlos Restrepo", "10980001", "Inglés", "3154445566", 45000);
        Profesor prof2 = new Profesor("Sophie Martin", "10980002", "Francés", "3167778899", 50000);
        Profesor prof3 = new Profesor("Thiago Silva", "10980003", "Portugués", "3178889900", 40000);

        academia.agregarProfesor(prof1);
        academia.agregarProfesor(prof2);
        academia.agregarProfesor(prof3);

        // 3. Cursos de prueba (Regular, Intensivo y Personalizado)
        CursoRegular cursoRegular = new CursoRegular(
                "CUR-REG-01", "Inglés General B1", "Inglés",
                "Curso regular con enfoque comunicativo y gramatical.",
                6, 180000, EstadoCurso.ACTIVO, 5.0, true, true);

        CursoIntensivo cursoIntensivo = new CursoIntensivo(
                "CUR-INT-02", "Francés Acelerado A2", "Francés",
                "Curso intensivo con enfoque de inmersión rápida.",
                3, 260000, EstadoCurso.ACTIVO, true, 10.0);

        CursoPersonalizado cursoPersonalizado = new CursoPersonalizado.Builder()
                .codigo("CUR-PER-03")
                .nombre("Portugués de Negocios VIP")
                .idioma("Portugués")
                .descripcion("Sesiones individuales enfocadas en el entorno empresarial y comercial.")
                .duracionMeses(4)
                .valorMensual(320000)
                .estadoCurso(EstadoCurso.ACTIVO)
                .sesionesConProfesor(8)
                .nivelReferencia(NivelReferencia.B2)
                .objetivo("Preparación para entrevistas y negociaciones internacionales.")
                .accesoPlataforma(true)
                .descuento(0.0)
                .build();
        cursoPersonalizado.setProfesor(prof3);

        academia.agregarCurso(cursoRegular);
        academia.agregarCurso(cursoIntensivo);
        academia.agregarCurso(cursoPersonalizado);

        // 4. Servicios Adicionales de prueba
        ServicioAdicional srv1 = new ServicioAdicional(
                "SRV-01", "Simulacro TOEFL / DELF",
                "Simulacro completo con calificación y retroalimentación personalizada.",
                80000, true);
        ServicioAdicional srv2 = new ServicioAdicional(
                "SRV-02", "Tutoría de Refuerzo",
                "Sesión de 1 hora para resolución de dudas gramaticales.",
                35000, true);
        ServicioAdicional srv3 = new ServicioAdicional(
                "SRV-03", "Taller de Conversación Extra",
                "Acceso extendido a clubes de debate y conversación.",
                45000, true);
        ServicioAdicional srv4 = new ServicioAdicional(
                "SRV-04", "Material Didáctico Impreso",
                "Libro de ejercicios y lecturas en físico.",
                60000, true);

        academia.agregarServicioAdicional(srv1);
        academia.agregarServicioAdicional(srv2);
        academia.agregarServicioAdicional(srv3);
        academia.agregarServicioAdicional(srv4);

        // 5. Matrículas de prueba iniciales
        List<ServicioAdicional> serviciosMat1 = new ArrayList<>();
        serviciosMat1.add(srv1);

        Matricula mat1 = new Matricula.Builder()
                .estudiante(est1)
                .curso(cursoRegular)
                .fecha(LocalDate.now().minusDays(8))
                .servicios(serviciosMat1)
                .descuento(5.0)
                .build();
        academia.agregarMatricula(mat1);
        est1.agregarMatricula(mat1);

        List<ServicioAdicional> serviciosMat2 = new ArrayList<>();
        serviciosMat2.add(srv2);
        serviciosMat2.add(srv3);

        Matricula mat2 = new Matricula.Builder()
                .estudiante(est2)
                .curso(cursoPersonalizado)
                .fecha(LocalDate.now().minusDays(2))
                .profesor(prof3)
                .servicios(serviciosMat2)
                .descuento(0.0)
                .build();
        academia.agregarMatricula(mat2);
        est2.agregarMatricula(mat2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
