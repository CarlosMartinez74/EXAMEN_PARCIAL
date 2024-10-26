package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecetasDAO {

    private Conexion conexion = new Conexion();

    // Método para verificar si una mascota existe
    public boolean existeMascota(int mascotaId) {
        String sql = "SELECT COUNT(*) FROM Mascota WHERE codigoMascota = ?";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, mascotaId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Si devuelve más de 0, la mascota existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int agregar(Recetas receta) {
        if (!existeMascota(receta.getMascotaId())) {
            System.out.println("Error: La mascota con ID " + receta.getMascotaId() + " no existe.");
            return 0;
        }

        String sql = "INSERT INTO Receta (fecha, hora, medicamento, cantidad, cadaCuantasHoras, mascota, dueño, proximaConsulta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaSql = new java.sql.Date(receta.getFecha().getTime());
            ps.setDate(1, fechaSql);

            // Asignar hora
            ps.setTime(2, receta.getHora());
            ps.setString(3, receta.getMedicamento());
            ps.setInt(4, receta.getCantidad());
            ps.setString(5, receta.getCadaCuantasHoras());
            ps.setInt(6, receta.getMascotaId());
            ps.setString(7, receta.getDueño());

            // Verificar si la próxima consulta es nula antes de asignar
            if (receta.getProximaConsulta() != null) {
                java.sql.Date proximaConsultaSql = new java.sql.Date(receta.getProximaConsulta().getTime());
                ps.setDate(8, proximaConsultaSql);
            } else {
                ps.setNull(8, java.sql.Types.DATE); // Asigna NULL si no hay próxima consulta
            }

            return ps.executeUpdate(); // Devuelve 1 si se ejecuta correctamente

        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // Indica que hubo un error
        }
    }

    public int actualizar(Recetas receta) {
        if (!existeMascota(receta.getMascotaId())) {
            System.out.println("Error: La mascota con ID " + receta.getMascotaId() + " no existe.");
            return 0;
        }

        String sql = "UPDATE Receta SET fecha = ?, hora = ?, medicamento = ?, cantidad = ?, cadaCuantasHoras = ?, mascota = ?, dueño = ?, proximaConsulta = ? WHERE idReceta = ?";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Convertir java.util.Date a java.sql.Date para la fecha
            java.sql.Date fechaSql = new java.sql.Date(receta.getFecha().getTime());
            ps.setDate(1, fechaSql);

            // Asignar la hora
            ps.setTime(2, receta.getHora());

            // Asignar el resto de los parámetros
            ps.setString(3, receta.getMedicamento());
            ps.setInt(4, receta.getCantidad());
            ps.setString(5, receta.getCadaCuantasHoras());
            ps.setInt(6, receta.getMascotaId());
            ps.setString(7, receta.getDueño());

            // Verificar si la próxima consulta es nula antes de asignar
            if (receta.getProximaConsulta() != null) {
                java.sql.Date proximaConsultaSql = new java.sql.Date(receta.getProximaConsulta().getTime());
                ps.setDate(8, proximaConsultaSql);
            } else {
                ps.setNull(8, java.sql.Types.DATE); // Asigna NULL si no hay próxima consulta
            }

            // Asignar el ID de la receta para la cláusula WHERE
            ps.setInt(9, receta.getIdReceta());

            return ps.executeUpdate(); // Devuelve 1 si se ejecuta correctamente

        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // Indica que hubo un error
        }
    }

    public int eliminar(int idReceta) {
        String sql = "DELETE FROM Receta WHERE idReceta = ?";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idReceta);
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Recetas> listar() {
        List<Recetas> lista = new ArrayList<>();
        String sql = "SELECT * FROM Receta";
        try (Connection con = conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Recetas receta = new Recetas();
                receta.setIdReceta(rs.getInt("idReceta"));
                receta.setFecha(rs.getDate("fecha"));
                receta.setHora(rs.getTime("hora"));
                receta.setMedicamento(rs.getString("medicamento"));
                receta.setCantidad(rs.getInt("cantidad"));
                receta.setCadaCuantasHoras(rs.getString("cadaCuantasHoras"));
                receta.setMascotaId(rs.getInt("mascota"));
                receta.setDueño(rs.getString("dueño"));
                receta.setProximaConsulta(rs.getDate("proximaConsulta"));

                lista.add(receta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
