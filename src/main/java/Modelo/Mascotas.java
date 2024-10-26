package Modelo;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Mascotas {

    private int codigoMascota;
    private String nombre;
    private String especie;
    private String raza;
    private String caracteristicas;
    private String sexo;
    private boolean castrado;
    private Date fechaNacimiento;
    private double peso;
    private String propietario;
    private String numPropietario;

    public Mascotas() {
    }

    public Mascotas(int codigoMascota, String nombre, String especie, String raza, String caracteristicas, String sexo, boolean castrado, Date fechaNacimiento, double peso, String propietario, String numPropietario) {
        this.codigoMascota = codigoMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.caracteristicas = caracteristicas;
        this.sexo = sexo;
        this.castrado = castrado;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.propietario = propietario;
        this.numPropietario = numPropietario;
    }

    public int getCodigoMascota() {
        return codigoMascota;
    }

    public void setCodigoMascota(int codigoMascota) {
        this.codigoMascota = codigoMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getNumPropietario() {
        return numPropietario;
    }

    public void setNumPropietario(String numPropietario) {
        this.numPropietario = numPropietario;
    }

    @Override
    public String toString() {
        return "Mascotas{" + "codigoMascota=" + codigoMascota + ", nombre=" + nombre + ", especie=" + especie + ", raza=" + raza + ", caracteristicas=" + caracteristicas + ", sexo=" + sexo + ", castrado=" + castrado + ", fechaNacimiento=" + fechaNacimiento + ", peso=" + peso + ", propietario=" + propietario + ", numPropietario=" + numPropietario + '}';
    }

    public String getComboBoxDisplay() {
        return nombre + " - " + especie;
    }

}
