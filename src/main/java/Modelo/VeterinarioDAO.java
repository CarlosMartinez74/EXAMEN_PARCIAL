package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAO {

    Conexion conectar = new Conexion();  // Usa tu clase de conexión
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Listar todos los veterinarios
    public List<Veterinario> listar() {
        
        List<Veterinario> datos = new ArrayList<>();
        String sql = "SELECT * FROM Veterinario";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Veterinario v = new Veterinario();
                v.setCodigoVeterinario(rs.getInt("codigoVeterinario"));
                v.setNombres(rs.getString("nombres"));
                v.setApellidos(rs.getString("apellidos"));
                v.setSexo(rs.getString("sexo"));
                v.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                v.setDireccion(rs.getString("direccion"));
                v.setGrado(rs.getString("grado"));
                datos.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }

    // Agregar un nuevo veterinario
    public int agregar(Veterinario v) {
         String sql = "INSERT INTO Veterinario (nombres, apellidos, sexo, fechaNacimiento, direccion, grado) VALUES (?, ?, ?, ?, ?, ?)";
    try {
        con = conectar.getConexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, v.getNombres());
        ps.setString(2, v.getApellidos());
        ps.setString(3, v.getSexo());

        // Convertir java.util.Date a java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(v.getFechaNacimiento().getTime());
        ps.setDate(4, sqlDate);

        ps.setString(5, v.getDireccion());
        ps.setString(6, v.getGrado());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        return 0;
    }
    return 1;
    }

    // Actualizar un veterinario
    public int actualizar(Veterinario v) {
         String sql = "UPDATE Veterinario SET nombres=?, apellidos=?, sexo=?, fechaNacimiento=?, direccion=?, grado=? WHERE codigoVeterinario=?";
    try {
        con = conectar.getConexion();
        ps = con.prepareStatement(sql);
        ps.setString(1, v.getNombres());
        ps.setString(2, v.getApellidos());
        ps.setString(3, v.getSexo());

        // Convertir java.util.Date a java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(v.getFechaNacimiento().getTime());
        ps.setDate(4, sqlDate);

        ps.setString(5, v.getDireccion());
        ps.setString(6, v.getGrado());
        ps.setInt(7, v.getCodigoVeterinario());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        return 0;
    }
    return 1;
    }

    // Eliminar un veterinario por su ID
    public void eliminar(int codigoVeterinario) {
        String sql = "DELETE FROM Veterinario WHERE codigoVeterinario=?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoVeterinario);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
