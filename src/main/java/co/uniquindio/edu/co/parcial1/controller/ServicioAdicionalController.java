package co.uniquindio.edu.co.parcial1.controller;
import co.uniquindio.edu.co.parcial1.model.Academia;
import co.uniquindio.edu.co.parcial1.model.ServicioAdicional;

import java.util.List;

public class ServicioAdicionalController {
    private final Academia academia = Academia.getInstance();

    public ServicioAdicional registrarServicio(
            String codigo,
            String nombre,
            String descripcion,
            double precio,
            boolean disponible) {

        if (codigo == null || codigo.isBlank()
                || nombre == null || nombre.isBlank()
                || descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException(
                    "Completa el código, el nombre y la descripción."
            );
        }

        if (precio < 0) {
            throw new IllegalArgumentException(
                    "El precio no puede ser negativo."
            );
        }

        ServicioAdicional servicio = new ServicioAdicional(
                codigo.trim(),
                nombre.trim(),
                descripcion.trim(),
                precio,
                disponible
        );

        academia.agregarServicioAdicional(servicio);
        return servicio;
    }

    public List<ServicioAdicional> obtenerServicios() {
        return academia.getServiciosAdicionales();
    }
}
