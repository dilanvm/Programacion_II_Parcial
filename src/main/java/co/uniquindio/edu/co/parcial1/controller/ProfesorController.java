package co.uniquindio.edu.co.parcial1.controller;
import co.uniquindio.edu.co.parcial1.model.Profesor;

public class ProfesorController {
    public Profesor registrarProfesor(String nombre, String identificacion, String idioma, String telefono, double tarifaSesion) {
        if (nombre == null || nombre.isBlank() || identificacion == null || identificacion.isBlank()) {
            throw new IllegalArgumentException("Nombre e identificación son obligatorios");
        }

        return new Profesor(nombre, identificacion, idioma, telefono, tarifaSesion);
    }
}
