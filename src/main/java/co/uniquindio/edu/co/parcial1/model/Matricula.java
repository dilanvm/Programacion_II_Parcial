package co.uniquindio.edu.co.parcial1.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Matricula {
    private final Estudiante estudiante;
    private final Curso curso;
    private final LocalDate fecha;
    private final Profesor profesor;
    private final List<ServicioAdicional> servicios;

    private double valorFinal;

    private Matricula(Builder builder) {
        this.estudiante = builder.estudiante;
        this.curso = builder.curso;
        this.fecha = builder.fecha;
        this.profesor = builder.profesor;
        this.servicios = builder.servicios;

        this.valorFinal = calcularTotal();
    }



    public double getValorFinal() { return valorFinal; }
    public Estudiante getEstudiante() { return estudiante; }
    public Curso getCurso() { return curso; }
    public LocalDate getFecha() { return fecha; }
    public Profesor getProfesor() { return profesor; }
    public List<ServicioAdicional> getServicios() { return servicios; }

    public static class Builder {
        private Estudiante estudiante;
        private Curso curso;
        private LocalDate fecha = LocalDate.now();
        private Profesor profesor;
        private List<ServicioAdicional> servicios = new ArrayList<>();
        private double descuento = 0;

        public Builder estudiante(Estudiante estudiante) {
            this.estudiante = estudiante; return this;
        }
        public Builder curso(Curso curso) {
            this.curso = curso; return this;
        }
        public Builder fecha(LocalDate fecha) {
            this.fecha = fecha; return this;
        }
        public Builder profesor(Profesor profesor) {
            this.profesor = profesor; return this;
        }
        public Builder servicios(List<ServicioAdicional> servicios) {
            this.servicios = servicios; return this;
        }


        public Matricula build() {
            return new Matricula(this);
        }
    }

    public double calcularTotal() {
        double total = curso.calcularValorMatricula();
        for (ServicioAdicional s : servicios) {
            total += s.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Matricula :" + '\n' +
                "Estudiante :" + estudiante.getNombreCompleto() +'\n' +
                "Curso :" + curso +'\n' +
                "Fecha :" + fecha +'\n' +
                "Profesor :" + profesor +'\n' +
                "Servicios :" + servicios +'\n' +
                "Valor Final :" + valorFinal;
    }
}