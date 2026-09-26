package co.uniquindio.edu.co.parcial1.model;

import java.time.LocalDate;

public class Matricula {
    private final Estudiante estudiante;
    private final Curso curso;
    private final LocalDate fecha;
    private final Profesor profesor;
    private final ServicioAdicional servicioAdicional;
    private final double descuento;
    private Matricula(Builder builder){
        this.estudiante=builder.estudiante;
        this.curso=builder.curso;
        this.fecha=builder.fecha;
        this.profesor=builder.profesor;
        this.servicioAdicional=builder.servicioAdicional;
        this.descuento=builder.descuento;
    }
    public static class Builder{
        private Estudiante estudiante;
        private Curso curso;
        private LocalDate fecha;
        private Profesor profesor;
        private ServicioAdicional servicioAdicional;
        private double descuento;

        public Builder estudiante(Estudiante estudiante) {
            this.estudiante = estudiante;
            return this;
        }

        public Builder curso(Curso curso) {
            this.curso = curso;
            return this;
        }

        public Builder fecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder profesor(Profesor profesor) {
            this.profesor = profesor;
            return this;
        }

        public Builder servicioAdicional(ServicioAdicional servicioAdicional) {
            this.servicioAdicional = servicioAdicional;
            return this;
        }

        public Builder descuento(double descuento) {
            this.descuento = descuento;
            return this;
        }
        public Matricula build(){
            return new Matricula(this);
        }
    }
}
