package co.uniquindio.edu.co.parcial1.controller;

import co.uniquindio.edu.co.parcial1.model.Academia;
import co.uniquindio.edu.co.parcial1.model.Profesor;

import java.util.List;

public class ProfesorController {
    private final Academia academia = Academia.getInstance();

    public Profesor registrarProfesor(String nombre, String identificacion, String idioma, String telefono, double tarifaSesion) {
        if (nombre == null || nombre.isBlank() || identificacion == null || identificacion.isBlank() || idioma == null || idioma.isBlank()) {
            throw new IllegalArgumentException("Nombre, identificación e idioma son obligatorios.");
        }

        if (tarifaSesion < 0) {
            throw new IllegalArgumentException("La tarifa por sesión no puede ser negativa.");
        }

        if (academia.buscarProfesor(identificacion.trim()) != null) {
            throw new IllegalArgumentException("Ya existe un profesor con la identificación: " + identificacion);
        }

        Profesor profesor = new Profesor(
                nombre.trim(),
                identificacion.trim(),
                idioma.trim(),
                telefono != null ? telefono.trim() : "",
                tarifaSesion
        );

        academia.agregarProfesor(profesor);
        return profesor;
    }

    public Profesor buscarProfesor(String identificacion) {
        if (identificacion == null || identificacion.isBlank()) {
            throw new IllegalArgumentException("Ingresa un documento o identificación para buscar.");
        }
        return academia.buscarProfesor(identificacion.trim());
    }

    public List<Profesor> obtenerProfesores() {
        return academia.getProfesores();
    }
}
