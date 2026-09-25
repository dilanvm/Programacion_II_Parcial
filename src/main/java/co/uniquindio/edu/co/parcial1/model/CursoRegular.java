package co.uniquindio.edu.co.parcial1.model;

public class CursoRegular extends Curso{


    public CursoRegular(String codigo, String nombre, String idioma, String descripcion, int duracionEnMeses, double valorMensual, EstadoCurso estadoCurso) {
        super(codigo, nombre, idioma, descripcion, duracionEnMeses, valorMensual, estadoCurso);
    }

    @Override
    public double calcularValorMatricula() {
        return 0;
    }


}
