package co.uniquindio.edu.co.parcial1.model;


import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombreCompleto;
    private int numeroIdentidad;
    private int telefono;
    private String correoElectronico;
    private int edad;
    private String fechaRegistro;

    private List<Matricula> matriculas;

        public void Estudiante (String nombreCompleto, int numeroIdentidad, int telefono, String correoElectronico, int edad, String fechaRegistro, Matricula matriculas){
            this.nombreCompleto = nombreCompleto;
            this.numeroIdentidad = numeroIdentidad;
            this.telefono = telefono;
            this.correoElectronico = correoElectronico;
            this.edad = edad;
            this.fechaRegistro = fechaRegistro;
            this.matriculas = new ArrayList<>();
        }

        public String getNombreCompleto (){
            return nombreCompleto;
        }

        public void setNombreCompleto(String nombreCompleto){
            this.nombreCompleto = nombreCompleto;
        }

        public int getNumeroIdentidad() {
            return numeroIdentidad;
        }

        public void setNumeroIdentidad(int numeroIdentidad) {
            this.numeroIdentidad = numeroIdentidad;
        }

        public int getTelefono() {
            return telefono;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

        public String getCorreoElectronico() {
            return correoElectronico;
        }

        public void setCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
        }

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getFechaRegistro() {
            return fechaRegistro;
        }

        public void setFechaRegistro(String fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
        }

        public List<Matricula> getMatriculas() {
            return matriculas;
        }

        public void setMatriculas(List<Matricula> matriculas) {
            this.matriculas = matriculas;
        }


    @Override
    public String toString() {
        return "Datos del estudiante" +
                "Nombre completo :" + nombreCompleto + '\'' +
                "Numero identidad :" + numeroIdentidad +
                "Telefono :" + telefono +
                "Correo electronico :" + correoElectronico + '\'' +
                "Edad :" + edad +
                "Fecha registro :" + fechaRegistro + '\'' +
                "Matriculas :" + matriculas ;
    }
}
