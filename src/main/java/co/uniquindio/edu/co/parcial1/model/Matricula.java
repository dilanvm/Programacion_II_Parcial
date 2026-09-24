package co.uniquindio.edu.co.parcial1.model;

public class Matricula {
    private final String estudiante;
    private final String curso;
    private final int fecha;
    private final String profesor;
    private final String agregarServicio;
    private final double descuento;
    private Matricula(Builder builder){
        this.estudiante=builder.estudiante;
        this.curso=builder.curso;
        this.fecha=builder.fecha;
        this.profesor=builder.profesor;
        this.agregarServicio=builder.agregarServicio;
        this.descuento=builder.descuento;
    }
    public static class Builder{
        private String estudiante;
        private String curso;
        private int fecha;
        private String profesor;
        private String agregarServicio;
        private double descuento;

        public Builder estudiante(String estudiante) {
            this.estudiante = estudiante;
            return this;
        }

        public Builder curso(String curso) {
            this.curso = curso;
            return this;
        }

        public Builder fecha(int fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder profesor(String profesor) {
            this.profesor = profesor;
            return this;
        }

        public Builder agregarServicio(String agregarServicio) {
            this.agregarServicio = agregarServicio;
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
