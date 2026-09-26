package co.uniquindio.edu.co.parcial1.model;

import java.util.List;

public class CursoPersonalizado extends Curso {
    private final int sesionesConProfesor;
    private final NivelReferencia nivelReferencia;
    private final String objetivo;
    private final boolean accesoPlataforma;
    private Profesor profesor;

    private CursoPersonalizado(Builder builder) {
        super(builder.codigo, builder.nombre, builder.idioma, builder.descripcion,
                builder.duracionMeses, builder.valorMensual, builder.estadoCurso, builder.descuento);
        this.sesionesConProfesor = builder.sesionesConProfesor;
        this.nivelReferencia = builder.nivelReferencia;
        this.objetivo = builder.objetivo;
        this.accesoPlataforma = builder.accesoPlataforma;
    }

    @Override
    public double calcularValorMatricula() {
        double costoSesiones=sesionesConProfesor*profesor.getTarifaSesion();
        if(descuento<0||descuento>100){
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
        }
        double totalMensualServicios=0;
        List<ServicioAdicional>servicioAdicionalList=getServicioAdicional();
        if(servicioAdicionalList!=null){
            for(ServicioAdicional servicioAdicional1:servicioAdicionalList){
                totalMensualServicios+=servicioAdicional1.getPrecio();
            }
        }
        double total= (valorMensual+totalMensualServicios*duracionEnMeses+costoSesiones);
        return total*(1-descuento/100.0);
    }

    public static class Builder {
        private String codigo;
        private String nombre;
        private String idioma;
        private String descripcion;
        private int duracionMeses;
        private double valorMensual;
        private EstadoCurso estadoCurso;
        private int sesionesConProfesor;
        private NivelReferencia nivelReferencia;
        private String objetivo;
        private boolean accesoPlataforma;
        private double descuento;


        public Builder codigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }


        public Builder idioma(String idioma) {
            this.idioma = idioma;
            return this;
        }


        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }


        public Builder duracionMeses(int duracionMeses) {
            this.duracionMeses = duracionMeses;
            return this;
        }


        public Builder valorMensual(double valorMensual) {
            this.valorMensual = valorMensual;
            return this;
        }


        public Builder estadoCurso(EstadoCurso estadoCurso) {
            this.estadoCurso = estadoCurso;
            return this;
        }
        public Builder sesionesConProfesor(int sesionesConProfesor) {
            this.sesionesConProfesor = sesionesConProfesor;
            return this;
        }

        public Builder nivelReferencia(NivelReferencia nivelReferencia) {
            this.nivelReferencia = nivelReferencia;
            return this;
        }

        public Builder objetivo(String objetivo) {
            this.objetivo = objetivo;
            return this;
        }

        public Builder accesoPlataforma(boolean accesoPlataforma) {
            this.accesoPlataforma = accesoPlataforma;
            return this;
        }

        public Builder descuento(double descuento) {
            this.descuento = descuento;
            return this;
        }
        public CursoPersonalizado build() {
            return new CursoPersonalizado(this);
        }
    }
}


