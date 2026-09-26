package co.uniquindio.edu.co.parcial1.model;

import java.util.List;

public class CursoIntensivo extends Curso {
    private boolean clubConversacion;

    public CursoIntensivo(String codigo, String nombre, String idioma, String descripcion, int duracionEnMeses, double valorMensual, EstadoCurso estadoCurso, boolean clubConversacion) {
        super(codigo, nombre, idioma, descripcion, duracionEnMeses, valorMensual, estadoCurso);
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
    public double calcularValorMatricula(double valorMensual, int duracionEnMeses, double descuento, List<ServicioAdicional> servicioAdicionalList) throws IllegalAccessException {
        double totalMensualServicios= 0;
        if(servicioAdicionalList!=null){
            for(ServicioAdicional servicioAdicional1:servicioAdicionalList){
                totalMensualServicios+=servicioAdicional1.getPrecio();
            }
        }
        double total= (valorMensual+totalMensualServicios)*duracionEnMeses;
        if(descuento<0||descuento>100){
            throw new IllegalAccessException("El descuento debe estar entre 0 y 100");
        }
        return total*(1-descuento/100.0);

    }

}
