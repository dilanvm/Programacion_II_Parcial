package co.uniquindio.edu.co.parcial1.model;

public class CursoRegularFactory extends CursoFactory {

    @Override
    public Curso crearCurso(String codigo, String nombre, String idioma,
                            String descripcion, int duracionMeses,
                            double valorMensual, EstadoCurso estado,double descuento) {
        return new CursoRegular(codigo, nombre, idioma, descripcion,
                duracionMeses, valorMensual, estado,descuento,
                false, false);
    }
}