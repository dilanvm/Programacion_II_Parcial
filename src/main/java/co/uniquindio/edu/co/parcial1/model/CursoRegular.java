package co.uniquindio.edu.co.parcial1.model;

public class CursoRegular extends Curso{
    private boolean accesoPlataforma; // estos datos se tendran que cambiar en el main usando sus setters, ya que por defecto seran creados en false
    private boolean materialDidactico;


    public CursoRegular(String codigo, String nombre, String idioma, String descripcion, int duracionEnMeses, double valorMensual, EstadoCurso estadoCurso, boolean accesoPlataforma, boolean materialDidactico) {
        super(codigo, nombre, idioma, descripcion, duracionEnMeses, valorMensual, estadoCurso);
        this.accesoPlataforma = accesoPlataforma;
        this.materialDidactico = materialDidactico;
    }

    public boolean getAccesoPlataforma() {
        return accesoPlataforma;
    }

    public void setAccesoPlataforma(boolean accesoPlataforma) {
        this.accesoPlataforma = accesoPlataforma;
    }

    public boolean getMaterialDidactico() {
        return materialDidactico;
    }

    public void setMaterialDidactico(boolean materialDidactico) {
        this.materialDidactico = materialDidactico;
    }

    @Override
    public String toString() {
        return "Curso Regular" +'\n'+ super.toString() +
                "Acceso plataforma :" + accesoPlataforma + '\n'+
                "Material didactico :" + materialDidactico;
    }

    @Override
    public double calcularValorMatricula() {
        return 0;
    }


}
