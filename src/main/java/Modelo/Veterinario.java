package Modelo;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Veterinario {
    
    private int codigoVeterinario;
    private String nombres;
    private String apellidos;
    private String sexo;
    private Date fechaNacimiento;
    private String direccion;
    private String grado;

    public Veterinario() {
    }

    public Veterinario(int codigoVeterinario, String nombres, String apellidos, String sexo, Date fechaNacimiento, String direccion, String grado) {
        this.codigoVeterinario = codigoVeterinario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.grado = grado;
    }

    public int getCodigoVeterinario() {
        return codigoVeterinario;
    }

    public void setCodigoVeterinario(int codigoVeterinario) {
        this.codigoVeterinario = codigoVeterinario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "Veterinarios{" + "codigoVeterinario=" + codigoVeterinario + ", nombres=" + nombres + ", apellidos=" + apellidos + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", grado=" + grado + '}';
    }
}

