package co.uniquindio.edu.co.parcial1.controller;

import co.uniquindio.edu.co.parcial1.model.Academia;
import co.uniquindio.edu.co.parcial1.model.Estudiante;
import java.time.LocalDate;

    public class EstudianteController {
        private final Academia academia = Academia.getInstance();

        public void registrarEstudiante(String nombre, int documento, int telefono, String correo, int edad, LocalDate fechaRegistro) {

            if (nombre == null || nombre.isBlank() || correo == null || correo.isBlank() || fechaRegistro == null) {
                throw new IllegalArgumentException("Completa todos los campos.");
            }

            if (documento <= 0 || telefono <= 0 || edad <= 0) {
                throw new IllegalArgumentException("Documento, teléfono y edad deben ser valores positivos.");
            }

            if (academia.buscarEstudiante(documento) != null) {
                throw new IllegalArgumentException("Ya existe un estudiante con ese documento.");
            }

            Estudiante estudiante = new Estudiante(nombre, documento, telefono, correo, edad, fechaRegistro);

            academia.agregarEstudiante(estudiante);
        }

        public Estudiante buscarEstudiante(int documento) {
            return academia.buscarEstudiante(documento);
        }
    }
}
