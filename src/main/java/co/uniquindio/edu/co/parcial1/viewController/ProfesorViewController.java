
    package co.uniquindio.edu.co.parcial1.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

    public class ProfesorViewController {

        @FXML
        private TextField nombreField;

        @FXML
        private TextField identificacionField;

        @FXML
        private TextField idiomaField;

        @FXML
        private TextField telefonoField;

        @FXML
        private TextField tarifaField;

        @FXML
        private void siguiente() {
            String nombre = nombreField.getText().trim();
            String identificacion = identificacionField.getText().trim();
            String idioma = idiomaField.getText().trim();
            String telefono = telefonoField.getText().trim();
            String tarifaTexto = tarifaField.getText().trim();

            if (nombre.isEmpty() || identificacion.isEmpty()
                    || idioma.isEmpty() || telefono.isEmpty() || tarifaTexto.isEmpty()) {
                mostrarAlerta("Faltan datos", "Completa todos los campos.");
                return;
            }

            double tarifa;
            try {
                tarifa = Double.parseDouble(tarifaTexto);
                if (tarifa < 0) {
                    mostrarAlerta("Tarifa inválida", "La tarifa no puede ser negativa.");
                    return;
                }
            } catch (NumberFormatException e) {
                mostrarAlerta("Tarifa inválida", "Ingresa la tarifa como número, por ejemplo: 50000.");
                return;
            }

            mostrarAlerta(
                    "Profesor registrado",
                    "Nombre: " + nombre
                            + "\nIdentificación: " + identificacion
                            + "\nIdioma: " + idioma
                            + "\nTeléfono: " + telefono
                            + "\nTarifa por sesión: " + tarifa
            );
        }

        private void mostrarAlerta(String titulo, String mensaje) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle(titulo);
            alerta.setHeaderText(null);
            alerta.setContentText(mensaje);
            alerta.showAndWait();
        }
    }
}
