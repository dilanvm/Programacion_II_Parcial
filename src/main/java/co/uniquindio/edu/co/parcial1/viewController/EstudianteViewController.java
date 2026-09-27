package co.uniquindio.edu.co.parcial1.viewController;

import co.uniquindio.edu.co.parcial1.controller.EstudianteController;
import co.uniquindio.edu.co.parcial1.model.Estudiante;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EstudianteViewController {
    @FXML private TextField txtNombre;
    @FXML private TextField txtDocumento;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtEdad;
    @FXML private DatePicker dpFechaRegistro;

    private final EstudianteController estudianteController = new EstudianteController();

    @FXML
    private void registrarEstudiante() {
        try {estudianteController.registrarEstudiante(
                    txtNombre.getText().trim(),
                    Integer.parseInt(txtDocumento.getText().trim()),
                    Integer.parseInt(txtTelefono.getText().trim()),
                    txtCorreo.getText().trim(),
                    Integer.parseInt(txtEdad.getText().trim()),
                    dpFechaRegistro.getValue());

            mostrarMensaje("Estudiante registrado correctamente.");
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarError("Documento, teléfono y edad deben ser números.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    private void buscarEstudiante() {
        try {int documento = Integer.parseInt(txtDocumento.getText().trim());

            Estudiante estudiante =
                    estudianteController.buscarEstudiante(documento);

            if (estudiante == null) {mostrarError("No se encontró un estudiante con ese documento.");
                return;
            }

            txtNombre.setText(estudiante.getNombreCompleto());
            txtTelefono.setText(String.valueOf(estudiante.getTelefono()));
            txtCorreo.setText(estudiante.getCorreoElectronico());
            txtEdad.setText(String.valueOf(estudiante.getEdad()));
            dpFechaRegistro.setValue(estudiante.getFechaRegistro());
        } catch (NumberFormatException e) {
            mostrarError("Ingresa un documento numérico válido.");
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtDocumento.clear();
        txtTelefono.clear();
        txtCorreo.clear();
        txtEdad.clear();
        dpFechaRegistro.setValue(null);
    }

    private void mostrarMensaje(String texto) {
        new Alert(Alert.AlertType.INFORMATION, texto).showAndWait();
    }

    private void mostrarError(String texto) {
        new Alert(Alert.AlertType.ERROR, texto).showAndWait();
    }
}
