package co.uniquindio.edu.co.parcial1.controller;

import co.uniquindio.edu.co.parcial1.model.*;
import java.time.LocalDate;
import java.util.List;

    public class MatriculaController {
        private final Academia academia = Academia.getInstance();

        public List<Estudiante> obtenerEstudiantes() {
            return academia.getEstudiantes();
        }

        public List<Curso> obtenerCursos() {
            return academia.getCursos();
        }

        public List<Profesor> obtenerProfesores() {
            return academia.getProfesores();
        }

        public List<ServicioAdicional> obtenerServicios() {
            return academia.getServiciosAdicionales();
        }

        public List<Matricula> obtenerMatriculas() {
            return academia.getMatriculas();
        }

        public Matricula registrarMatricula(
                Estudiante estudiante,
                Curso curso,
                LocalDate fecha,
                Profesor profesor,
                List<ServicioAdicional> servicios,
                double descuento) {

            if (estudiante == null || curso == null || fecha == null) {
                throw new IllegalArgumentException(
                        "Selecciona estudiante, curso y fecha."
                );
            }

            if (descuento < 0 || descuento > 100) {
                throw new IllegalArgumentException(
                        "El descuento debe estar entre 0 y 100."
                );
            }

            Matricula matricula = new Matricula.Builder()
                    .estudiante(estudiante)
                    .curso(curso)
                    .fecha(fecha)
                    .profesor(profesor)
                    .servicioAdicional(servicios)
                    .descuento(descuento)
                    .build();

            academia.agregarMatricula(matricula);
            estudiante.agregarMatricula(matricula);

            return matricula;
        }
    }
