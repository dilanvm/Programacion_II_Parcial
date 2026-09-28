package co.uniquindio.edu.co.parcial1.viewController;

import co.uniquindio.edu.co.parcial1.controller.MatriculaController;
import co.uniquindio.edu.co.parcial1.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MatriculaViewController {
    @FXML private ComboBox<Estudiante> comboEstudiante;
    @FXML private ComboBox<Curso> comboCurso;
    @FXML private DatePicker dpFecha;
    @FXML private TextField txtDescuento;
    @FXML private ListView<ServicioAdicional> listaServicios;
    @FXML private VBox panelProfesor;
    @FXML private ComboBox<Profesor> cbProfesor;
    @FXML private Label lblValorEstimado;

    @FXML private TableView<Matricula> tablaMatriculas;
    @FXML private TableColumn<Matricula, String> colEstudiante;
    @FXML private TableColumn<Matricula, String> colCurso;
    @FXML private TableColumn<Matricula, String> colFecha;
    @FXML private TableColumn<Matricula, String> colServicios;
    @FXML private TableColumn<Matricula, String> colDescuento;
    @FXML private TableColumn<Matricula, String> colValorFinal;

    private final MatriculaController controlador = new MatriculaController();

    @FXML
    private void initialize() {
        dpFecha.setValue(LocalDate.now());

        listaServicios.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        refrescarDatos();

        // Refrescar al abrir los combos por si se crearon elementos en otras pestañas
        comboEstudiante.setOnShowing(e -> comboEstudiante.setItems(FXCollections.observableArrayList(controlador.obtenerEstudiantes())));
        comboCurso.setOnShowing(e -> comboCurso.setItems(FXCollections.observableArrayList(controlador.obtenerCursos())));
        cbProfesor.setOnShowing(e -> cbProfesor.setItems(FXCollections.observableArrayList(controlador.obtenerProfesores())));

        // Controlar visibilidad del profesor si el curso es personalizado
        if (panelProfesor != null) {
            panelProfesor.setVisible(false);
            panelProfesor.setManaged(false);
        }

        comboCurso.setOnAction(e -> {
            Curso curso = comboCurso.getValue();
            boolean esPersonalizado = (curso instanceof CursoPersonalizado);
            if (panelProfesor != null) {
                panelProfesor.setVisible(esPersonalizado);
                panelProfesor.setManaged(esPersonalizado);
                if (!esPersonalizado) {
                    cbProfesor.setValue(null);
                }
            }
            calcularEstimado();
        });

        cbProfesor.setOnAction(e -> calcularEstimado());

        listaServicios.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> calcularEstimado());

        txtDescuento.textProperty().addListener((obs, oldV, newV) -> calcularEstimado());

        configurarTabla();
        actualizarTabla();
    }

    public void refrescarDatos() {
        comboEstudiante.setItems(FXCollections.observableArrayList(controlador.obtenerEstudiantes()));
        comboCurso.setItems(FXCollections.observableArrayList(controlador.obtenerCursos()));
        cbProfesor.setItems(FXCollections.observableArrayList(controlador.obtenerProfesores()));
        listaServicios.setItems(FXCollections.observableArrayList(controlador.obtenerServicios()));
    }

    private void configurarTabla() {
        colEstudiante.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getEstudiante() != null ? cell.getValue().getEstudiante().getNombreCompleto() : "N/A"));

        colCurso.setCellValueFactory(cell -> {
            Curso c = cell.getValue().getCurso();
            if (c == null) return new SimpleStringProperty("N/A");
            String tipo = (c instanceof CursoRegular) ? "Regular" : (c instanceof CursoIntensivo ? "Intensivo" : "Personalizado");
            return new SimpleStringProperty(c.getNombre() + " (" + tipo + ")");
        });

        colFecha.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getFecha() != null ? cell.getValue().getFecha().toString() : "N/A"));

        colServicios.setCellValueFactory(cell -> {
            List<ServicioAdicional> srvs = cell.getValue().getServicios();
            if (srvs == null || srvs.isEmpty()) return new SimpleStringProperty("Ninguno");
            return new SimpleStringProperty(srvs.stream().map(ServicioAdicional::getNombreServicio).collect(Collectors.joining(", ")));
        });

        colDescuento.setCellValueFactory(cell ->
                new SimpleStringProperty(String.format("%.1f%%", cell.getValue().getDescuento())));

        colValorFinal.setCellValueFactory(cell ->
                new SimpleStringProperty(String.format("$ %,.2f", cell.getValue().getValorFinal())));
    }

    private void actualizarTabla() {
        tablaMatriculas.setItems(FXCollections.observableArrayList(controlador.obtenerMatriculas()));
    }

    private void calcularEstimado() {
        Curso curso = comboCurso.getValue();
        if (curso == null) {
            lblValorEstimado.setText("$ 0.00");
            return;
        }

        double base = curso.getValorMensual() * curso.getDuracionEnMeses();
        if (curso instanceof CursoIntensivo) {
            base = base * 1.20; // 20% de recargo intensivo
        } else if (curso instanceof CursoPersonalizado cp) {
            Profesor p = cbProfesor.getValue();
            if (p != null) {
                base += cp.getSesionesConProfesor() * p.getTarifaSesion();
            }
        }

        if (curso.getDescuento() > 0) {
            base = base * (1.0 - (curso.getDescuento() / 100.0));
        }

        List<ServicioAdicional> seleccionados = listaServicios.getSelectionModel().getSelectedItems();
        if (seleccionados != null) {
            for (ServicioAdicional s : seleccionados) {
                base += s.getPrecio();
            }
        }

        double descMatricula = 0;
        try {
            if (txtDescuento.getText() != null && !txtDescuento.getText().isBlank()) {
                descMatricula = Double.parseDouble(txtDescuento.getText().trim());
                if (descMatricula > 0 && descMatricula <= 100) {
                    base = base * (1.0 - (descMatricula / 100.0));
                }
            }
        } catch (NumberFormatException ignored) {}

        lblValorEstimado.setText(String.format("$ %,.2f", base));
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

            actualizarTabla();
            lblValorEstimado.setText(String.format("$ %,.2f", matricula.getValorFinal()));

            mostrarMensaje("Matrícula Registrada",
                    "¡Matrícula procesada con éxito!\n"
                            + "Estudiante: " + matricula.getEstudiante().getNombreCompleto() + "\n"
                            + "Curso: " + matricula.getCurso().getNombre() + "\n"
                            + "Total pagado: " + String.format("$ %,.2f", matricula.getValorFinal()));

            limpiarFormulario();
        } catch (NumberFormatException e) {
            mostrarError("El descuento debe ser un valor numérico.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    private void limpiarFormulario() {
        comboEstudiante.setValue(null);
        comboCurso.setValue(null);
        cbProfesor.setValue(null);
        dpFecha.setValue(LocalDate.now());
        txtDescuento.clear();
        listaServicios.getSelectionModel().clearSelection();
        lblValorEstimado.setText("$ 0.00");
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
        alerta.setTitle("Error al registrar matrícula");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
