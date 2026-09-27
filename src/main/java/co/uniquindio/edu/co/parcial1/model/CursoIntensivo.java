package co.uniquindio.edu.co.parcial1.model;

public class CursoIntensivo extends Curso {
    private boolean clubConversacion;// estos datos se tendran que cambiar en el main usando sus setters, ya que por defecto seran creados en false

    public CursoIntensivo(String codigo, String nombre, String idioma, String descripcion, int duracionEnMeses, double valorMensual, EstadoCurso estadoCurso, boolean clubConversacion) {
        super(codigo, nombre, idioma, descripcion, duracionEnMeses, valorMensual, estadoCurso);
        this.clubConversacion = clubConversacion;
    }

    public boolean isClubConversacion() {
        return clubConversacion;
    }

    public void setClubConversacion(boolean clubConversacion) {
        this.clubConversacion = clubConversacion;
    }

    @Override
    public String toString() {
        return "Curso Intensivo: " + '\n' + super.toString() +
                "Club conversacion :" + clubConversacion;
    }

    @Override
    public double calcularValorMatricula() {
        return 0;
    }
}
