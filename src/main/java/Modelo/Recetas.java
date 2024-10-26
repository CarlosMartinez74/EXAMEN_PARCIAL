package Modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Recetas {
    
    private int idReceta;
    private Date fecha;
    private Time hora;
    private String medicamento;
    private int cantidad;
    private String cadaCuantasHoras;
    private int mascotaId;  // Cambiamos de String a int para almacenar el ID de la mascota
    private String dueño;
    private Date proximaConsulta;

    public Recetas() {
    }

    public Recetas(int idReceta, Date fecha, Time hora, String medicamento, int cantidad, String cadaCuantasHoras, int mascotaId, String dueño, Date proximaConsulta) {
        this.idReceta = idReceta;
        this.fecha = fecha;
        this.hora = hora;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.cadaCuantasHoras = cadaCuantasHoras;
        this.mascotaId = mascotaId;
        this.dueño = dueño;
        this.proximaConsulta = proximaConsulta;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCadaCuantasHoras() {
        return cadaCuantasHoras;
    }

    public void setCadaCuantasHoras(String cadaCuantasHoras) {
        this.cadaCuantasHoras = cadaCuantasHoras;
    }

    public int getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(int mascotaId) {
        this.mascotaId = mascotaId;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public Date getProximaConsulta() {
        return proximaConsulta;
    }

    public void setProximaConsulta(Date proximaConsulta) {
        this.proximaConsulta = proximaConsulta;
    }

    @Override
    public String toString() {
        return "Recetas{" + "idReceta=" + idReceta + ", fecha=" + fecha + ", hora=" + hora + ", medicamento=" + medicamento + ", cantidad=" + cantidad + ", cadaCuantasHoras=" + cadaCuantasHoras + ", mascotaId=" + mascotaId + ", due\u00f1o=" + dueño + ", proximaConsulta=" + proximaConsulta + '}';
    }

}
