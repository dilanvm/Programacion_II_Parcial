package co.uniquindio.edu.co.parcial1.controller;
import co.uniquindio.edu.co.parcial1.model.Academia;
import co.uniquindio.edu.co.parcial1.model.Curso;
import co.uniquindio.edu.co.parcial1.model.CursoIntensivo;
import co.uniquindio.edu.co.parcial1.model.CursoPersonalizado;
import co.uniquindio.edu.co.parcial1.model.CursoRegular;
import co.uniquindio.edu.co.parcial1.model.EstadoCurso;
import co.uniquindio.edu.co.parcial1.model.NivelReferencia;

import java.util.List;

public class CursoController {
    private final Academia academia = Academia.getInstance();

    public Curso crearCurso(String tipo, String codigo, String nombre, String idioma, String descripcion,
            int duracion,
            double valorMensual,
            EstadoCurso estado,
            double descuento,
            boolean accesoPlataforma,
            boolean materialDidactico,
            boolean clubConversacion,
            int sesiones,
            NivelReferencia nivel,
            String objetivo) {

        if (codigo == null || codigo.isBlank()
                || nombre == null || nombre.isBlank()
                || idioma == null || idioma.isBlank()
                || descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException(
                    "Completa los datos generales del curso.");
        }

        if (duracion <= 0 || valorMensual < 0) {
            throw new IllegalArgumentException(
                    "La duración debe ser positiva y el valor no puede ser negativo.");
        }

        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException(
                    "El descuento debe estar entre 0 y 100.");
        }

        Curso curso;

        switch (tipo) {
            case "Regular":
                curso = new CursoRegular(
                        codigo, nombre, idioma, descripcion,
                        duracion, valorMensual, estado,
                        accesoPlataforma, materialDidactico);
                curso.setDescuento(descuento);
                break;

            case "Intensivo":
                curso = new CursoIntensivo(
                        codigo, nombre, idioma, descripcion,
                        duracion, valorMensual, estado,
                        clubConversacion);
                curso.setDescuento(descuento);
                break;

            case "Personalizado":
                if (sesiones <= 0 || nivel == null
                        || objetivo == null || objetivo.isBlank()) {
                    throw new IllegalArgumentException(
                            "Completa las sesiones, el nivel y los objetivos del curso personalizado.");
                }

                curso = new CursoPersonalizado.Builder()
                        .codigo(codigo)
                        .nombre(nombre)
                        .idioma(idioma)
                        .descripcion(descripcion)
                        .duracionMeses(duracion)
                        .valorMensual(valorMensual)
                        .estadoCurso(estado)
                        .sesionesConProfesor(sesiones)
                        .nivelReferencia(nivel)
                        .objetivo(objetivo)
                        .accesoPlataforma(accesoPlataforma)
                        .descuento(descuento)
                        .build();
                break;

            default:
                throw new IllegalArgumentException(
                        "Selecciona un tipo de curso válido.");
        }

        academia.agregarCurso(curso);
        return curso;
    }

    public List<Curso> obtenerCursos() {
        return academia.getCursos();
    }
}
