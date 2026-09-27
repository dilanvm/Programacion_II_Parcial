package co.uniquindio.edu.co.parcial1.viewController;
import co.uniquindio.edu.co.parcial1.controller.CursoController;
import co.uniquindio.edu.co.parcial1.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CursoViewController {
        @FXML private ComboBox<String> cbTipoCurso;
        @FXML private TextField txtCodigo;
        @FXML private TextField txtNombre;
        @FXML private ComboBox<String> cbIdioma;
        @FXML private TextField txtDuracion;
        @FXML private TextField txtValorMensual;
        @FXML private ComboBox<EstadoCurso> cbEstado;
        @FXML private TextField txtDescuento;
        @FXML private TextArea txtDescripcion;

        @FXML private VBox panelRegular;
        @FXML private VBox panelIntensivo;
        @FXML private GridPane panelPersonalizado;

        @FXML private CheckBox checkAccesoPlataforma;
        @FXML private CheckBox checkMaterialDidactico;
        @FXML private CheckBox checkClubConversacion;
        @FXML private TextField txtSesiones;
        @FXML private ComboBox<NivelReferencia> cbNivelReferencia;
        @FXML private TextArea txtObjetivo;

        @FXML private Label lblMensaje;
        @FXML private TableView<Curso> tablaCursos;
        @FXML private TableColumn<Curso, String> colCodigo;
        @FXML private TableColumn<Curso, String> colNombre;
        @FXML private TableColumn<Curso, String> colIdioma;
        @FXML private TableColumn<Curso, String> colTipo;
        @FXML private TableColumn<Curso, String> colDuracion;
        @FXML private TableColumn<Curso, String> colValor;
        @FXML private TableColumn<Curso, String> colEstado;

        private final CursoController cursoController = new CursoController();

        @FXML
        private void initialize() {
            cbTipoCurso.setItems(FXCollections.observableArrayList(
                    "Regular", "Intensivo", "Personalizado"));
            cbIdioma.setItems(FXCollections.observableArrayList(
                    "Inglés", "Francés", "Portugués"));
            cbEstado.setItems(FXCollections.observableArrayList(
                    EstadoCurso.values()));
            cbNivelReferencia.setItems(FXCollections.observableArrayList(
                    NivelReferencia.values()));

            configurarTabla();
            actualizarTabla();
            ocultarPaneles();
        }

        @FXML
        private void onTipoCursoSeleccionado() {
            ocultarPaneles();

            String tipo = cbTipoCurso.getValue();
            if (tipo == null) {
                return;
            }

            switch (tipo) {
                case "Regular":
                    mostrar(panelRegular);
                    break;
                case "Intensivo":
                    mostrar(panelIntensivo);
                    break;
                case "Personalizado":
                    mostrar(panelPersonalizado);
                    break;
            }
        }

        @FXML
        private void onRegistrarCurso() {
            try {
                String tipo = cbTipoCurso.getValue();

                int duracion = Integer.parseInt(txtDuracion.getText().trim());
                double valor = Double.parseDouble(txtValorMensual.getText().trim());

                double descuento = txtDescuento.getText().isBlank()
                        ? 0
                        : Double.parseDouble(txtDescuento.getText().trim());

                int sesiones = txtSesiones.getText().isBlank()
                        ? 0
                        : Integer.parseInt(txtSesiones.getText().trim());

                Curso curso = cursoController.crearCurso(
                        tipo,
                        txtCodigo.getText().trim(),
                        txtNombre.getText().trim(),
                        cbIdioma.getValue(),
                        txtDescripcion.getText().trim(),
                        duracion,
                        valor,
                        cbEstado.getValue(),
                        descuento,
                        checkAccesoPlataforma.isSelected(),
                        checkMaterialDidactico.isSelected(),
                        checkClubConversacion.isSelected(),
                        sesiones,
                        cbNivelReferencia.getValue(),
                        txtObjetivo.getText().trim());

                actualizarTabla();
                lblMensaje.setText("Curso registrado: " + curso.getNombre());
                limpiarCampos();

            } catch (NumberFormatException e) {
                mostrarError("Duración, valor, descuento y sesiones deben ser numéricos.");
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
            colCodigo.setCellValueFactory(d ->
                    new SimpleStringProperty(d.getValue().getCodigo()));
            colNombre.setCellValueFactory(d ->
                    new SimpleStringProperty(d.getValue().getNombre()));
            colIdioma.setCellValueFactory(d ->
                    new SimpleStringProperty(d.getValue().getIdioma()));
            colTipo.setCellValueFactory(d ->
                    new SimpleStringProperty(tipoDeCurso(d.getValue())));
            colDuracion.setCellValueFactory(d ->
                    new SimpleStringProperty(
                            String.valueOf(d.getValue().getDuracionEnMeses())
                    ));
            colValor.setCellValueFactory(d ->
                    new SimpleStringProperty(
                            String.valueOf(d.getValue().getValorMensual())
                    ));
            colEstado.setCellValueFactory(d ->
                    new SimpleStringProperty(
                            String.valueOf(d.getValue().getEstadoCurso())
                    ));
        }

        private String tipoDeCurso(Curso curso) {
            if (curso instanceof CursoRegular) return "Regular";
            if (curso instanceof CursoIntensivo) return "Intensivo";
            if (curso instanceof CursoPersonalizado) return "Personalizado";
            return "Curso";
        }

        private void actualizarTabla() {
            tablaCursos.setItems(
                    FXCollections.observableArrayList(cursoController.obtenerCursos()));
        }

        private void ocultarPaneles() {
            ocultar(panelRegular);
            ocultar(panelIntensivo);
            ocultar(panelPersonalizado);
        }

        private void mostrar(javafx.scene.Node panel) {
            panel.setVisible(true);
            panel.setManaged(true);
        }

        private void ocultar(javafx.scene.Node panel) {
            panel.setVisible(false);
            panel.setManaged(false);
        }

        private void limpiarCampos() {
            txtCodigo.clear();
            txtNombre.clear();
            txtDuracion.clear();
            txtValorMensual.clear();
            txtDescuento.clear();
            txtDescripcion.clear();
            txtSesiones.clear();
            txtObjetivo.clear();

            cbTipoCurso.setValue(null);
            cbIdioma.setValue(null);
            cbEstado.setValue(null);
            cbNivelReferencia.setValue(null);

            checkAccesoPlataforma.setSelected(false);
            checkMaterialDidactico.setSelected(false);
            checkClubConversacion.setSelected(false);

            ocultarPaneles();
        }

        private void mostrarError(String mensaje) {
            new Alert(Alert.AlertType.ERROR, mensaje).showAndWait();
        }
    }
