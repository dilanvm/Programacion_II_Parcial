package co.uniquindio.edu.co.parcial1.viewController;

import co.uniquindio.edu.co.parcial1.controller.ProfesorController;
import co.uniquindio.edu.co.parcial1.model.Profesor;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class ProfesorViewController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtIdentificacion;
    @FXML private TextField txtIdioma;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtTarifaSesion;

    private final ProfesorController profesorController = new ProfesorController();

    @FXML
    private void registrarProfesor() {
        try {
            String nombre = txtNombre.getText().trim();
            String identificacion = txtIdentificacion.getText().trim();
            String idioma = txtIdioma.getText().trim();
            String telefono = txtTelefono.getText().trim();
            String tarifaStr = txtTarifaSesion.getText().trim();

            if (nombre.isEmpty() || identificacion.isEmpty() || idioma.isEmpty() || tarifaStr.isEmpty()) {
                mostrarError("Nombre, identificación, idioma y tarifa son obligatorios.");
                return;
            }

            double tarifa = Double.parseDouble(tarifaStr);

            profesorController.registrarProfesor(nombre, identificacion, idioma, telefono, tarifa);

            mostrarMensaje("Profesor Registrado", "El profesor " + nombre + " ha sido registrado exitosamente.");
            limpiarCampos();

        } catch (NumberFormatException e) {
            mostrarError("La tarifa por sesión debe ser un valor numérico válido (ej. 45000).");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void buscarProfesor() {
        try {
            String identificacion = txtIdentificacion.getText().trim();
            if (identificacion.isEmpty()) {
                mostrarError("Ingresa la identificación del profesor que deseas buscar.");
                return;
            }

            Profesor profesor = profesorController.buscarProfesor(identificacion);
            if (profesor == null) {
                mostrarError("No se encontró ningún profesor registrado con la identificación: " + identificacion);
                return;
            }

            txtNombre.setText(profesor.getNombre());
            txtIdioma.setText(profesor.getIdioma());
            txtTelefono.setText(profesor.getTelefono());
            txtTarifaSesion.setText(String.valueOf(profesor.getTarifaSesion()));

            mostrarMensaje("Profesor Encontrado", "Datos cargados correctamente para: " + profesor.getNombre());

        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void limpiarCampos() {
        txtNombre.clear();
        txtIdentificacion.clear();
        txtIdioma.clear();
        txtTelefono.clear();
        txtTarifaSesion.clear();
    }

    private void mostrarMensaje(String titulo, String texto) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(texto);
        alerta.showAndWait();
    }

    private void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
