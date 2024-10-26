package com.mycompany.ar_so_examen_parcial_q01151h;

import Vista.INICIO;
import Modelo.Conexion;
import java.sql.Connection;

public class AR_SO_EXAMEN_PARCIAL_Q01151H {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();  // Crear la instancia fuera del try
        Connection con = null;  // Declaro la conexión
        try {
            // Obtener la conexión
            con = conexion.getConexion();

            // Verificar si la conexión se estableció correctamente
            if (con != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                
                // Iniciar la interfaz gráfica INICIO
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new INICIO().setVisible(true);
                    }
                });
                
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }

        } catch (Exception e) {
            // Captura cualquier excepción y muestra el mensaje de error
            System.out.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace(); // Muestra la pila de llamadas para depuración
        } finally {
            // Cerrar la conexión cuando sea necesario
            conexion.cerrarConexion();  // No se pasa la conexión, solo se llama al método de la clase
        }
    }
}
