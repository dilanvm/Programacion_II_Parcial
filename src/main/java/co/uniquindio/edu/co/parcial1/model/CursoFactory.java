package co.uniquindio.edu.co.parcial1.model;

public abstract class CursoFactory {

    public abstract Curso crearCurso(String codigo, String nombre, String idioma,
                                   String descripcion, int duracionMeses, double valorMensual,
                                   EstadoCurso estado);

}