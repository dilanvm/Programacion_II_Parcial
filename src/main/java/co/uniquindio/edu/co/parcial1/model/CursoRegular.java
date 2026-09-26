package co.uniquindio.edu.co.parcial1.model;

import java.util.List;

public class CursoRegular extends Curso{
    private boolean accesoPlataforma;
    private boolean materialDidactico;


    public CursoRegular(String codigo, String nombre, String idioma, String descripcion, int duracionEnMeses, double valorMensual, EstadoCurso estadoCurso, boolean accesoPlataforma, boolean materialDidactico) {
        super(codigo, nombre, idioma, descripcion, duracionEnMeses, valorMensual, estadoCurso, descuento);
        this.accesoPlataforma = accesoPlataforma;
        this.materialDidactico = materialDidactico;
    }

    public boolean isAccesoPlataforma() {
        return accesoPlataforma;
    }

    public void setAccesoPlataforma(boolean accesoPlataforma) {
        this.accesoPlataforma = accesoPlataforma;
    }

    public boolean isMaterialDidactico() {
        return materialDidactico;
    }

    public void setMaterialDidactico(boolean materialDidactico) {
        this.materialDidactico = materialDidactico;
    }

    @Override
    public String toString() {
        return "Curso Regular" + super.toString() +
                "Acceso plataforma :" + accesoPlataforma +
                "Material didactico :" + materialDidactico;
    }

    @Override
    public double calcularValorMatricula() {
        if(descuento<0.0||descuento>100.0){
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
        }
        double totalMensualServicios=0.0;
        List<ServicioAdicional>servicioAdicionalList=getServicioAdicional();
        if(servicioAdicionalList!=null){
            for(ServicioAdicional servicioAdicional1:servicioAdicionalList){
                totalMensualServicios+=servicioAdicional1.getPrecio();
            }
        }
        double total= (valorMensual+totalMensualServicios)*duracionEnMeses;
        return total*(1-descuento/100.0);
    }

}
