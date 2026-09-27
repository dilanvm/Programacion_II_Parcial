package co.uniquindio.edu.co.parcial1;

import co.uniquindio.edu.co.parcial1.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Academia academia = Academia.getInstance();
        academia.setNombreComercial("LenguajeCafetero");
        academia.setNit("900123456-7");

        CursoFactory factoryRegular = new CursoRegularFactory();
        CursoRegular ingles = (CursoRegular) factoryRegular.crearCurso(
                "C001", "Inglés Básico", "Inglés", "Curso para principiantes",
                6, 200000, EstadoCurso.ACTIVO);
        ingles.setAccesoPlataforma(true);
        System.out.println(ingles);

        CursoPersonalizado frances = new CursoPersonalizado.Builder()
                .codigo("C002")
                .nombre("Francés Personalizado")
                .idioma("Francés")
                .descripcion("Curso para aprender como mas te gusta")
                .duracionMeses(3)
                .valorMensual(300000)
                .estadoCurso(EstadoCurso.ACTIVO)
                .sesionesConProfesor(10)
                .nivelReferencia(NivelReferencia.B1)
                .objetivo("Viaje de negocios")
                .build();
        System.out.println(frances);


        Estudiante juan = new Estudiante("Juan Pérez", 123456, "3001234567", "juan@mail.com", 22, "2026-01-15");
        Matricula matriculaIngles = new Matricula.Builder()
                .estudiante(juan)
                .curso(ingles)
                .build();
        juan.agregarMatricula(matriculaIngles);
        System.out.println(juan.getMatriculas().size());


        academia.agregarEstudiante(juan);
        academia.agregarMatricula(matriculaIngles);


        Estudiante encontrado = academia.buscarEstudiante(123456);
        System.out.println(encontrado);

        double ingresos = academia.calcularIngresos(LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 30));
        System.out.println("Ingresos: " + ingresos);
    }
}