package co.uniquindio.edu.co.parcial1.controller;
import co.uniquindio.edu.co.parcial1.model.Profesor;
import co.uniquindio.edu.co.parcial1.model.Academia;

public class ProfesorController {

        private final Academia academia = Academia.getInstance();

        public void registrarProfesor(String nombre, int identificacion, String idioma, String telefono, double tarifaSesion) {

            if (nombre == null || nombre.isBlank()
                    || idioma == null || idioma.isBlank()
                    || telefono == null || telefono.isBlank()) {
                throw new IllegalArgumentException("Completa todos los campos.");
            }

            if (identificacion <= 0 || tarifaSesion < 0) {
                throw new IllegalArgumentException(
                        "La identificación debe ser positiva y la tarifa no puede ser negativa."
                );
            }

            if (academia.buscarProfesor(identificacion) != null) {
                throw new IllegalArgumentException(
                        "Ya existe un profesor con esa identificación."
                );
            }

            Profesor profesor = new Profesor(nombre, identificacion, idioma, telefono, tarifaSesion);
            academia.agregarProfesor(profesor);
        }
        public Profesor buscarProfesor(int identificacion) {
            return academia.buscarProfesor(identificacion);
        }
    }
}
