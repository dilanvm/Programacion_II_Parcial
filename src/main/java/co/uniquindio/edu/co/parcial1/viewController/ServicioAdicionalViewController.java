package co.uniquindio.edu.co.parcial1.viewController;
import co.uniquindio.edu.co.parcial1.controller.ServicioAdicionalController;
import co.uniquindio.edu.co.parcial1.model.ServicioAdicional;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

    public class ServicioAdicionalViewController {
        @FXML private TextField txtCodigo;
        @FXML private TextField txtNombreServicio;
        @FXML private TextArea txtDescripcion;
        @FXML private TextField txtPrecio;
        @FXML private CheckBox checkDisponibilidad;
        @FXML private Label lblMensaje;

        @FXML private TableView<ServicioAdicional> tablaServicios;
        @FXML private TableColumn<ServicioAdicional, String> colCodigo;
        @FXML private TableColumn<ServicioAdicional, String> colNombre;
        @FXML private TableColumn<ServicioAdicional, String> colDescripcion;
        @FXML private TableColumn<ServicioAdicional, String> colPrecio;
        @FXML private TableColumn<ServicioAdicional, String> colDisponibilidad;

        private final ServicioAdicionalController servicioController =
                new ServicioAdicionalController();

        @FXML
        private void initialize() {
            configurarTabla();
            actualizarTabla();
        }

        @FXML
        private void onRegistrarServicio() {
            try {
                double precio = Double.parseDouble(txtPrecio.getText().trim());

                servicioController.registrarServicio(
                        txtCodigo.getText(),
                        txtNombreServicio.getText(),
                        txtDescripcion.getText(),
                        precio,
                        checkDisponibilidad.isSelected()
                );

                actualizarTabla();
                lblMensaje.setText("Servicio registrado correctamente.");
                limpiarCampos();

            } catch (NumberFormatException e) {
                mostrarError("El precio debe ser un número válido.");
            } catch (IllegalArgumentException e) {
                mostrarError(e.getMessage());
            }
        }

        @FXML
        private void onLimpiar() {
            limpiarCampos();
            lblMensaje.setText("");
        }

        private void configurarTabla() {
            colCodigo.setCellValueFactory(fila ->
                    new SimpleStringProperty(fila.getValue().getCodigo()));
            colNombre.setCellValueFactory(fila ->
                    new SimpleStringProperty(fila.getValue().getNombreServicio()));
            colDescripcion.setCellValueFactory(fila ->
                    new SimpleStringProperty(fila.getValue().getDescripcion()));
            colPrecio.setCellValueFactory(fila ->
                    new SimpleStringProperty(
                            String.valueOf(fila.getValue().getPrecio())
                    ));
            colDisponibilidad.setCellValueFactory(fila ->
                    new SimpleStringProperty(
                            fila.getValue().isDisponibilidad() ? "Sí" : "No"
                    ));
        }

        private void actualizarTabla() {
            tablaServicios.setItems(
                    FXCollections.observableArrayList(
                            servicioController.obtenerServicios()
                    )
            );
        }

        private void limpiarCampos() {
            txtCodigo.clear();
            txtNombreServicio.clear();
            txtDescripcion.clear();
            txtPrecio.clear();
            checkDisponibilidad.setSelected(true);
        }

        private void mostrarError(String mensaje) {
            new Alert(Alert.AlertType.ERROR, mensaje).showAndWait();
        }
    }

