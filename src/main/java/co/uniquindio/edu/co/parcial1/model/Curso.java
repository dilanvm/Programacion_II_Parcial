package co.uniquindio.edu.co.parcial1.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Curso {
    protected String codigo, nombre, idioma, descripcion;
    protected int duracionEnMeses;
    protected double valorMensual;
    protected EstadoCurso estadoCurso;
    protected List<ServicioAdicional> servicioAdicional;
    protected double descuento;

    public Curso(String codigo, String nombre, String idioma, String descripcion, int duracionEnMeses, double valorMensual, EstadoCurso estadoCurso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idioma = idioma;
        this.descripcion = descripcion;
        this.duracionEnMeses = duracionEnMeses;
        this.valorMensual = valorMensual;
        this.estadoCurso = estadoCurso;
        this.descuento = descuento;
        this.servicioAdicional = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracionEnMeses() {
        return duracionEnMeses;
    }

    public void setDuracionEnMeses(int duracionEnMeses) {
        this.duracionEnMeses = duracionEnMeses;
    }

    public double getValorMensual() {
        return valorMensual;
    }

    public void setValorMensual(double valorMensual) {
        this.valorMensual = valorMensual;
    }

    public EstadoCurso getEstadoCurso() {
        return estadoCurso;
    }

    public void setEstadoCurso(EstadoCurso estadoCurso) {
        this.estadoCurso = estadoCurso;
    }

    public List<ServicioAdicional> getServicioAdicional() {
        return servicioAdicional;
    }

    public void setServicioAdicional(List<ServicioAdicional> servicioAdicional) {
        this.servicioAdicional = servicioAdicional;
    }

    @Override
    public String toString() {
        return "Curso :" +
                "Codigo :" + codigo + '\'' +
                "Nombre :" + nombre + '\'' +
                "Idioma :" + idioma + '\'' +
                "Descripcion :" + descripcion + '\'' +
                "Duracion en meses :" + duracionEnMeses +
                "Valor mensual :" + valorMensual +
                "Estado curso :" + estadoCurso;
    }

    public abstract double calcularValorMatricula(double valorMensual, int duracionEnMeses, double descuento, List<ServicioAdicional> servicioAdicionalList) throws IllegalAccessException;
}