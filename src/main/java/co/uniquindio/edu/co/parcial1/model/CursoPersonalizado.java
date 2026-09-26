package co.uniquindio.edu.co.parcial1.model;

public class CursoPersonalizado extends Curso{
    private final int sesionesConProfesor;
    private final NivelReferencia nivelReferencia;
    private final String objetivo;
    private final boolean accesoPlataforma;

    private CursoPersonalizado(Builder builder){
        super(builder.codigo, builder.nombre, builder.idioma, builder.descripcion,
                builder.duracionMeses, builder.valorMensual, builder.estadoCurso);
        this.sesionesConProfesor = builder.sesionesConProfesor;
        this.nivelReferencia = builder.nivelReferencia;
        this.objetivo = builder.objetivo;
        this.accesoPlataforma = builder.accesoPlataforma;

    }



    public static class Builder {
        private String codigo, nombre, idioma, descripcion;
        private int duracionMeses;
        private double valorMensual;
        private EstadoCurso estadoCurso;
        private int sesionesConProfesor;
        private NivelReferencia nivelReferencia;
        private String objetivo;
        private boolean accesoPlataforma;


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


        }
    @Override
    public double calcularValorMatricula() {
        return 0;
    }

    }

