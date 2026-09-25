package co.uniquindio.edu.co.parcial1.model;

public class CursoIntensivo extends Curso {



    public CursoIntensivo(String codigo, String nombre, String idioma, String descripcion, int duracionEnMeses, double valorMensual, EstadoCurso estadoCurso) {
        super(codigo, nombre, idioma, descripcion, duracionEnMeses, valorMensual, estadoCurso);

    }


    @Override
    public double calcularValorMatricula() {
        return 0;
    }


}

