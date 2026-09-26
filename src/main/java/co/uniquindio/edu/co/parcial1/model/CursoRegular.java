package co.uniquindio.edu.co.parcial1.model;

public class CursoRegular extends Curso{
    private boolean accesoPlataforma;
    private boolean materialDidactico;


    public CursoRegular(String codigo, String nombre, String idioma, String descripcion, int duracionEnMeses, double valorMensual, EstadoCurso estadoCurso, boolean accesoPlataforma, boolean materialDidactico) {
        super(codigo, nombre, idioma, descripcion, duracionEnMeses, valorMensual, estadoCurso);
        this.accesoPlataforma = accesoPlataforma;
        this.materialDidactico = materialDidactico;
    }

    public boolean isAccesoPlataforma() {
        return accesoPlataforma;
    }

    public void setAccesoPlataforma(boolean accesoPlataforma) {
        this.accesoPlataforma = accesoPlataforma;
    }

    public boolean isMaterialDidactico() {
        return materialDidactico;
    }

    public void setMaterialDidactico(boolean materialDidactico) {
        this.materialDidactico = materialDidactico;
    }

    @Override
    public String toString() {
        return "Curso Regular" + super.toString() +
                "Acceso plataforma :" + accesoPlataforma +
                "Material didactico :" + materialDidactico;
    }

    @Override
    public double calcularValorMatricula() {
        return 0;
    }


}
