package co.uniquindio.edu.co.parcial1.viewController;

import co.uniquindio.edu.co.parcial1.controller.AcademiaController;
import co.uniquindio.edu.co.parcial1.model.Academia;
import co.uniquindio.edu.co.parcial1.model.Matricula;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

public class AcademiaViewController {

    @FXML private Label lblNombreAcademia;
    @FXML private Label lblNit;
    @FXML private Label lblDireccion;
    @FXML private Label lblTelefono;
    @FXML private Label lblCorreo;
    @FXML private Label lblWeb;

    @FXML private DatePicker dpFechaInicio;
    @FXML private DatePicker dpFechaFin;
    @FXML private Label lblTotalIngresos;

    @FXML private TableView<Matricula> tablaReporteMatriculas;
    @FXML private TableColumn<Matricula, String> colRepFecha;
    @FXML private TableColumn<Matricula, String> colRepEstudiante;
    @FXML private TableColumn<Matricula, String> colRepCurso;
    @FXML private TableColumn<Matricula, String> colRepValor;

    private final AcademiaController academiaController = new AcademiaController();

    @FXML
    private void initialize() {
        Academia ac = academiaController.obtenerAcademia();
        if (lblNombreAcademia != null) lblNombreAcademia.setText(ac.getNombreComercial());
        if (lblNit != null) lblNit.setText(ac.getNit());
        if (lblDireccion != null) lblDireccion.setText(ac.getDireccion());
        if (lblTelefono != null) lblTelefono.setText(ac.getTelefono());
        if (lblCorreo != null) lblCorreo.setText(ac.getCorreo());
        if (lblWeb != null) lblWeb.setText(ac.getPaginaWeb());

        if (dpFechaInicio != null) dpFechaInicio.setValue(LocalDate.now().minusMonths(1));
        if (dpFechaFin != null) dpFechaFin.setValue(LocalDate.now().plusMonths(1));

        configurarTablaReporte();
        actualizarReporte();
    }

    private void configurarTablaReporte() {
        if (tablaReporteMatriculas == null) return;

        colRepFecha.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getFecha() != null ? c.getValue().getFecha().toString() : ""));
        colRepEstudiante.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getEstudiante() != null ? c.getValue().getEstudiante().getNombreCompleto() : ""));
        colRepCurso.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getCurso() != null ? c.getValue().getCurso().getNombre() : ""));
        colRepValor.setCellValueFactory(c ->
                new SimpleStringProperty(String.format("$ %,.2f", c.getValue().getValorFinal())));
    }

    private void actualizarReporte() {
        if (dpFechaInicio != null && dpFechaFin != null && dpFechaInicio.getValue() != null && dpFechaFin.getValue() != null) {
            onCalcularIngresos();
        }
    }

    @FXML
    private void onCalcularIngresos() {
        try {
            LocalDate inicio = dpFechaInicio.getValue();
            LocalDate fin = dpFechaFin.getValue();

            double total = academiaController.calcularIngresos(inicio, fin);
            lblTotalIngresos.setText(String.format("$ %,.2f", total));

            List<Matricula> filtradas = academiaController.obtenerMatriculasEnPeriodo(inicio, fin);
            tablaReporteMatriculas.setItems(FXCollections.observableArrayList(filtradas));

        } catch (IllegalArgumentException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }
}
