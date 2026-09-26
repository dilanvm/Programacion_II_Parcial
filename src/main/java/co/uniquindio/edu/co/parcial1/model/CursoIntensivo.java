package co.uniquindio.edu.co.parcial1.model;

import java.util.List;

public class CursoIntensivo extends Curso {
    private boolean clubConversacion;
    private static final double RECARGO_INTENSIVO=0.20;

    public CursoIntensivo(String codigo, String nombre, String idioma, String descripcion, int duracionEnMeses, double valorMensual, EstadoCurso estadoCurso, boolean clubConversacion) {
        super(codigo, nombre, idioma, descripcion, duracionEnMeses, valorMensual, estadoCurso,descuento);
        this.clubConversacion = clubConversacion;
    }

    public boolean isClubConversacion() {
        return clubConversacion;
    }

    public void setClubConversacion(boolean clubConversacion) {
        this.clubConversacion = clubConversacion;
    }

    @Override
    public String toString() {
        return "Curso Intensivo: " + super.toString() +
                "Club conversacion :" + clubConversacion;
    }

    @Override
    public double calcularValorMatricula() throws IllegalArgumentException {
            if (descuento < 0.0 || descuento > 100.0) {
                throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
            }
            double totalMensualServicios = 0.;
            List<ServicioAdicional> servicios = getServicioAdicional();
            if (servicios != null) {
                for (ServicioAdicional servicio : servicios) {
                        totalMensualServicios += servicio.getPrecio();
                    }
                }
            double subtotal = (valorMensual + totalMensualServicios) * duracionEnMeses;
            double subtotalConRecargo = subtotal * (1 + RECARGO_INTENSIVO);
            return subtotalConRecargo * (1 - descuento / 100.0);
        }
    }
}
