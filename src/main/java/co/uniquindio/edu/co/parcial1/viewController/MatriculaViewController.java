package co.uniquindio.edu.co.parcial1.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import co.uniquindio.edu.co.parcial1.controller.MatriculaController;
import co.uniquindio.edu.co.parcial1.model.*;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import java.time.LocalDate;

    public class MatriculaViewController {
        @FXML private ComboBox<Estudiante> comboEstudiante;
        @FXML private ComboBox<Curso> comboCurso;
        @FXML private DatePicker dpFecha;
        @FXML private TextField txtDescuento;
        @FXML private ListView<ServicioAdicional> listaServicios;
        @FXML private ComboBox<Profesor> cbProfesor;
        @FXML private Label lblValorEstimado;
        @FXML private TableView<Matricula> tablaMatriculas;

        private final MatriculaController controlador = new MatriculaController();

        @FXML
        private void initialize() {
            comboEstudiante.setItems(
                    FXCollections.observableArrayList(controlador.obtenerEstudiantes())
            );
            comboCurso.setItems(
                    FXCollections.observableArrayList(controlador.obtenerCursos())
            );
            cbProfesor.setItems(
                    FXCollections.observableArrayList(controlador.obtenerProfesores())
            );
            listaServicios.setItems(
                    FXCollections.observableArrayList(controlador.obtenerServicios())
            );
            listaServicios.getSelectionModel().setSelectionMode(
                    SelectionMode.MULTIPLE
            );
        }

        @FXML
        private void onMatricular() {
            try {
                double descuento = txtDescuento.getText().isBlank() ? 0
                        : Double.parseDouble(txtDescuento.getText().trim());

                Matricula matricula = controlador.registrarMatricula(
                        comboEstudiante.getValue(),
                        comboCurso.getValue(),
                        dpFecha.getValue(),
                        cbProfesor.getValue(),
                        listaServicios.getSelectionModel().getSelectedItems(),
                        descuento);

                tablaMatriculas.getItems().setAll(controlador.obtenerMatriculas());
                lblValorEstimado.setText("Matrícula registrada");
            } catch (NumberFormatException e) {
                mostrarError("El descuento debe ser un número.");
            } catch (IllegalArgumentException e) {
                mostrarError(e.getMessage());
            }
        }

        private void mostrarError(String mensaje) {
            new Alert(Alert.AlertType.ERROR, mensaje).showAndWait();
        }
    }

