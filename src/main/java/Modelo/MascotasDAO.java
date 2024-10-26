package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascotasDAO {

    Conexion conectar = new Conexion();  // Usa tu clase de conexión
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Listar todas las mascotas
    public List<Mascotas> listar() {
        List<Mascotas> datos = new ArrayList<>();
        String sql = "SELECT * FROM Mascota";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mascotas m = new Mascotas();
                m.setCodigoMascota(rs.getInt("codigoMascota"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));
                m.setCaracteristicas(rs.getString("caracteristicas"));
                m.setSexo(rs.getString("sexo"));
                m.setCastrado(rs.getBoolean("castrado"));
                m.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                m.setPeso(rs.getDouble("peso"));
                m.setPropietario(rs.getString("propietario"));
                m.setNumPropietario(rs.getString("numPropietario"));
                datos.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datos;
    }

    // Agregar una nueva mascota
    public int agregar(Mascotas m) {
        String sql = "INSERT INTO Mascota (nombre, especie, raza, caracteristicas, sexo, castrado, fechaNacimiento, peso, propietario, numPropietario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setString(4, m.getCaracteristicas());
            ps.setString(5, m.getSexo());
            ps.setBoolean(6, m.isCastrado());
            ps.setDate(7, new java.sql.Date(m.getFechaNacimiento().getTime()));
            ps.setDouble(8, m.getPeso());
            ps.setString(9, m.getPropietario());
            ps.setString(10, m.getNumPropietario());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    // Actualizar una mascota
    public int actualizar(Mascotas m) {
        String sql = "UPDATE Mascota SET nombre=?, especie=?, raza=?, caracteristicas=?, sexo=?, castrado=?, fechaNacimiento=?, peso=?, propietario=?, numPropietario=? WHERE codigoMascota=?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setString(4, m.getCaracteristicas());
            ps.setString(5, m.getSexo());
            ps.setBoolean(6, m.isCastrado());
            ps.setDate(7, new java.sql.Date(m.getFechaNacimiento().getTime()));
            ps.setDouble(8, m.getPeso());
            ps.setString(9, m.getPropietario());
            ps.setString(10, m.getNumPropietario());
            ps.setInt(11, m.getCodigoMascota());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    // Eliminar una mascota
    public void eliminar(int codigoMascota) {
        String sql = "DELETE FROM Mascota WHERE codigoMascota=?";
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigoMascota);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
