package co.uniquindio.edu.co.parcial1.model;

public class ServicioAdicional {
    // código, nombre, descripción, precio y disponibilidad.
    private String codigo;
    private String nombreServicio;
    private double precio;
    private boolean disponibilidad;

        public ServicioAdicional(String codigo, String nombreServicio, double precio, boolean disponibilidad) {
            this.codigo = codigo;
            this.nombreServicio = nombreServicio;
            this.precio = precio;
            this.disponibilidad = disponibilidad;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getNombreServicio() {
            return nombreServicio;
        }

        public void setNombreServicio(String nombreServicio) {
            this.nombreServicio = nombreServicio;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public boolean isDisponibilidad() {
            return disponibilidad;
        }

        public void setDisponibilidad(boolean disponibilidad) {
            this.disponibilidad = disponibilidad;
        }

    @Override
    public String toString() {
        return "Datos del servicio adicional :" +
                "Codigo :" + codigo + '\'' +
                "Nombre servicio :" + nombreServicio + '\'' +
                "Precio :" + precio +
                "Disponibilidad :" + disponibilidad ;
    }
}
