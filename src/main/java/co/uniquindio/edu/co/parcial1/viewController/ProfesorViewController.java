
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

    private final ProfesorController profesorController =
            new ProfesorController();

    @FXML
    private void registrarProfesor() {
        try {
            profesorController.registrarProfesor(txtNombre.getText().trim(),
                    Integer.parseInt(txtIdentificacion.getText().trim()),
                    txtIdioma.getText().trim(),
                    txtTelefono.getText().trim(),
                    Double.parseDouble(txtTarifaSesion.getText().trim()));

            mostrarMensaje("Profesor registrado correctamente.");
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarError("La identificación y la tarifa deben ser numéricas.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void buscarProfesor() {
        try {
            int identificacion =
                    Integer.parseInt(txtIdentificacion.getText().trim());

            Profesor profesor =
                    profesorController.buscarProfesor(identificacion);

            if (profesor == null) {
                mostrarError("No se encontró un profesor con esa identificación.");
                return;
            }

            txtNombre.setText(profesor.getNombre());
            txtIdioma.setText(profesor.getIdioma());
            txtTelefono.setText(profesor.getTelefono());
            txtTarifaSesion.setText(String.valueOf(profesor.getTarifaSesion())
            );
        } catch (NumberFormatException e) {
            mostrarError("Ingresa una identificación numérica válida.");
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtIdentificacion.clear();
        txtIdioma.clear();
        txtTelefono.clear();
        txtTarifaSesion.clear();
    }

    private void mostrarMensaje(String mensaje) {
        new Alert(Alert.AlertType.INFORMATION, mensaje).showAndWait();
    }

    private void mostrarError(String mensaje) {
        new Alert(Alert.AlertType.ERROR, mensaje).showAndWait();
    }
}