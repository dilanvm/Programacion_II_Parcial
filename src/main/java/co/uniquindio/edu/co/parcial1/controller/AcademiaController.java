package co.uniquindio.edu.co.parcial1.controller;

import co.uniquindio.edu.co.parcial1.model.Academia;
import co.uniquindio.edu.co.parcial1.model.Matricula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AcademiaController {
    private final Academia academia = Academia.getInstance();

    public Academia obtenerAcademia() {
        return academia;
    }

    public double calcularIngresos(LocalDate fechaInicio, LocalDate fechaFin) {
        if (fechaInicio == null || fechaFin == null) {
            throw new IllegalArgumentException("Debe seleccionar una fecha inicial y una fecha final.");
        }
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha inicial no puede ser posterior a la fecha final.");
        }
        return academia.calcularIngresos(fechaInicio, fechaFin);
    }

    public List<Matricula> obtenerMatriculasEnPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
        if (fechaInicio == null || fechaFin == null) {
            return new ArrayList<>();
        }
        List<Matricula> resultado = new ArrayList<>();
        for (Matricula m : academia.getMatriculas()) {
            if (!m.getFecha().isBefore(fechaInicio) && !m.getFecha().isAfter(fechaFin)) {
                resultado.add(m);
            }
        }
        return resultado;
    }
}
