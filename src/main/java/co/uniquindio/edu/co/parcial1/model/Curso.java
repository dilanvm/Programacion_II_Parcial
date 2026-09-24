package co.uniquindio.edu.co.parcial1.model;

public abstract class Curso {
    protected String codigo;
    protected String nombre;
    protected String idioma;
    protected String descripcion;
    protected int duracionEnMeses;
    protected double valorMensual;
    protected EstadoCurso estadoCurso;

    public Curso(String codigo, String nombre, String idioma, String descripcion, int duracionEnMeses, double valorMensual, EstadoCurso estadoCurso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idioma = idioma;
        this.descripcion = descripcion;
        this.duracionEnMeses = duracionEnMeses;
        this.valorMensual = valorMensual;
        this.estadoCurso = estadoCurso;
    }

    public abstract double calcularValorMatricula();
}
