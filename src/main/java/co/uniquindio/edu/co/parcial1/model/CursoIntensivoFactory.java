package co.uniquindio.edu.co.parcial1.model;

public class CursoIntensivoFactory extends CursoFactory {

    @Override
    public Curso crearCurso(String codigo, String nombre, String idioma,
                            String descripcion, int duracionMeses,
                            double valorMensual, EstadoCurso estado,double descuento) {

        return new CursoIntensivo(codigo, nombre, idioma, descripcion,
                        duracionMeses, valorMensual, estado, false, descuento);

    }
}