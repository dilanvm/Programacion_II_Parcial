package co.uniquindio.edu.co.parcial1.model;

public class Profesor {
    private String nombre;
    private int identifiacion;
    private String idioma;
    private int telefono;
    private double tarifaSesion;

    public Profesor(String nombre, int identifiacion, String idioma, int telefono, double tarifaSesion) {
        this.nombre = nombre;
        this.identifiacion = identifiacion;
        this.idioma = idioma;
        this.telefono = telefono;
        this.tarifaSesion = tarifaSesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentifiacion() {
        return identifiacion;
    }

    public void setIdentifiacion(int identifiacion) {
        this.identifiacion = identifiacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public double getTarifaSesion() {
        return tarifaSesion;
    }

    public void setTarifaSesion(double tarifaSesion) {
        this.tarifaSesion = tarifaSesion;
    }

    @Override
    public String toString() {
        return "Datos del profesor :" +
                "Nombre :" + nombre + '\'' +
                "Identifiacion :" + identifiacion +
                "Idioma :" + idioma + '\'' +
                "Telefono :" + telefono +
                "Tarifa sesion :" + tarifaSesion;
    }
}
