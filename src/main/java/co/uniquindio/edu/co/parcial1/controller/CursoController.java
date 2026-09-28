package co.uniquindio.edu.co.parcial1.controller;
import co.uniquindio.edu.co.parcial1.model.*;

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

        if (buscarCurso(codigo) != null) {
            throw new IllegalArgumentException("Ya existe un curso con el código: " + codigo);
        }

        Curso curso;

        switch (tipo) {
            case "Regular":
                CursoRegularFactory regularFactory = new CursoRegularFactory();
                CursoRegular regular = (CursoRegular) regularFactory.crearCurso(
                        codigo, nombre, idioma, descripcion,
                        duracion, valorMensual, estado, descuento);
                regular.setAccesoPlataforma(accesoPlataforma);
                regular.setMaterialDidactico(materialDidactico);
                curso = regular;
                break;

            case "Intensivo":
                CursoIntensivoFactory intensivoFactory = new CursoIntensivoFactory();
                CursoIntensivo intensivo = (CursoIntensivo) intensivoFactory.crearCurso(
                        codigo, nombre, idioma, descripcion,
                        duracion, valorMensual, estado, descuento);
                intensivo.setClubConversacion(clubConversacion);
                curso = intensivo;
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

    public Curso buscarCurso(String codigo) {
        if (codigo == null) return null;
        for (Curso c : academia.getCursos()) {
            if (c.getCodigo() != null && c.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return c;
            }
        }
        return null;
    }
}
