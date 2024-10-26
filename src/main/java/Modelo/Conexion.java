package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String url = "jdbc:sqlserver://conexion-q01151h.database.windows.net:1433;databaseName=AS_PARCIAL;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private final String user = "Martinez"; // Usuario
    private final String password = "12345C@rlos"; // Contraseña
    private Connection con = null;

    public Connection getConexion() {
        try {
            // Registrar el controlador JDBC de SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establecer la conexión
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos AS_PARCIAL.");
        } catch (SQLException e) {
            System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el controlador JDBC.");
        }
        return con;
    }

    public void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
