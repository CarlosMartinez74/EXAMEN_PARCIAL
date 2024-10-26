package Vista;

import Modelo.Mascotas;
import Modelo.MascotasDAO;
import Modelo.Recetas;
import Modelo.RecetasDAO;
import Modelo.Veterinario;
import Modelo.VeterinarioDAO;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class INICIO extends javax.swing.JFrame {

    /**
     * Creates new form INICIO
     */
    public INICIO() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuReportes = new javax.swing.JDesktopPane();
        jMenuInicio = new javax.swing.JMenuBar();
        jMenuVeterinaria = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenuMascotas = new javax.swing.JMenu();
        jMenuRegistrarMascota = new javax.swing.JMenuItem();
        jMenuVeterinario = new javax.swing.JMenu();
        jMenuRegistrarVeterinario = new javax.swing.JMenuItem();
        jMenuServicios = new javax.swing.JMenu();
        jMenuRecetas = new javax.swing.JMenuItem();
        jMenuRReportes = new javax.swing.JMenu();
        jMenuReVeterinario = new javax.swing.JMenuItem();
        jMenuMascota = new javax.swing.JMenuItem();
        jMenuItemReceta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jMenuReportesLayout = new javax.swing.GroupLayout(jMenuReportes);
        jMenuReportes.setLayout(jMenuReportesLayout);
        jMenuReportesLayout.setHorizontalGroup(
            jMenuReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1016, Short.MAX_VALUE)
        );
        jMenuReportesLayout.setVerticalGroup(
            jMenuReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );

        jMenuInicio.setBorder(null);
        jMenuInicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuVeterinaria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuVeterinaria.setText("  VETERINARIA  ");

        jMenuSalir.setText("SALIR");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenuVeterinaria.add(jMenuSalir);

        jMenuInicio.add(jMenuVeterinaria);

        jMenuMascotas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuMascotas.setText("  MASCOTAS  ");

        jMenuRegistrarMascota.setText("REGISTRAR MASCOTA");
        jMenuRegistrarMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegistrarMascotaActionPerformed(evt);
            }
        });
        jMenuMascotas.add(jMenuRegistrarMascota);

        jMenuInicio.add(jMenuMascotas);

        jMenuVeterinario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuVeterinario.setText("   VETERINARIOS   ");

        jMenuRegistrarVeterinario.setText("REGISTRAR VETERINARIO");
        jMenuRegistrarVeterinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegistrarVeterinarioActionPerformed(evt);
            }
        });
        jMenuVeterinario.add(jMenuRegistrarVeterinario);

        jMenuInicio.add(jMenuVeterinario);

        jMenuServicios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuServicios.setText("  SERVICIOS  ");
        jMenuServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuServiciosActionPerformed(evt);
            }
        });

        jMenuRecetas.setText("RECETAS");
        jMenuRecetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRecetasActionPerformed(evt);
            }
        });
        jMenuServicios.add(jMenuRecetas);

        jMenuInicio.add(jMenuServicios);

        jMenuRReportes.setText("   REPORTES   ");

        jMenuReVeterinario.setText("Generar Reporte Veterinario");
        jMenuReVeterinario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuReVeterinarioActionPerformed(evt);
            }
        });
        jMenuRReportes.add(jMenuReVeterinario);

        jMenuMascota.setText("Genrerar Reporte Mascotas");
        jMenuMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMascotaActionPerformed(evt);
            }
        });
        jMenuRReportes.add(jMenuMascota);

        jMenuItemReceta.setText("Generar Reporte Recetas");
        jMenuItemReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRecetaActionPerformed(evt);
            }
        });
        jMenuRReportes.add(jMenuItemReceta);

        jMenuInicio.add(jMenuRReportes);

        setJMenuBar(jMenuInicio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMenuReportes)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMenuReportes, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuServiciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuServiciosActionPerformed

    private void jMenuRegistrarMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegistrarMascotaActionPerformed
        // Crear una nueva instancia del formulario Registrar_Mascota
        Registrar_Mascota registrarMascotaForm = new Registrar_Mascota();

        // Agregar el formulario al JDesktopPane
        jMenuReportes.add(registrarMascotaForm);

        // Hacer visible el formulario
        registrarMascotaForm.setVisible(true);

        try {
            // Poner el formulario en primer plano
            registrarMascotaForm.setSelected(true);
        } catch (java.beans.PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jMenuRegistrarMascotaActionPerformed

    private void jMenuRegistrarVeterinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegistrarVeterinarioActionPerformed
        abrirRegistrarVeterinario();
    }//GEN-LAST:event_jMenuRegistrarVeterinarioActionPerformed

    private void jMenuRecetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRecetasActionPerformed
        abrirServicioRecetas();
    }//GEN-LAST:event_jMenuRecetasActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        // Muestra un cuadro de diálogo de confirmación para salir
        int confirm = javax.swing.JOptionPane.showConfirmDialog(null,
                "¿Estás seguro de que deseas salir?",
                "Confirmar Salida",
                javax.swing.JOptionPane.YES_NO_OPTION);

        // Si el usuario confirma, cierra la aplicación
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0); // Cierra el programa
        }
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenuReVeterinarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuReVeterinarioActionPerformed
         try {
        // Crear un archivo para guardar veterinarios
        FileWriter writer = new FileWriter("veterinarios.txt");

        // Consultar veterinarios desde la base de datos
        VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
        List<Veterinario> listaVeterinarios = veterinarioDAO.listar();

        // Escribir los datos en el archivo
        for (Veterinario veterinario : listaVeterinarios) {
            writer.write("ID Veterinario: " + veterinario.getCodigoVeterinario() + "\n");
            writer.write("Nombres: " + veterinario.getNombres() + "\n");
            writer.write("Apellidos: " + veterinario.getApellidos() + "\n");
            writer.write("Sexo: " + veterinario.getSexo() + "\n");
            writer.write("Fecha de Nacimiento: " + veterinario.getFechaNacimiento() + "\n");
            writer.write("Grado: " + veterinario.getGrado() + "\n");
            writer.write("\n");
        }

        // Cerrar el archivo
        writer.close();

        JOptionPane.showMessageDialog(null, "Datos de veterinarios guardados exitosamente en veterinarios.txt");

    } catch (IOException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jMenuReVeterinarioActionPerformed

    private void jMenuMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMascotaActionPerformed
       try {
        // Crear un archivo para guardar mascotas
        FileWriter writer = new FileWriter("mascotas.txt");

        // Consultar mascotas desde la base de datos
        MascotasDAO mascotasDAO = new MascotasDAO();
        List<Mascotas> listaMascotas = mascotasDAO.listar();

        // Escribir los datos en el archivo
        for (Mascotas mascota : listaMascotas) {
            writer.write("ID Mascota: " + mascota.getCodigoMascota() + "\n");
            writer.write("Nombre: " + mascota.getNombre() + "\n");
            writer.write("Especie: " + mascota.getEspecie() + "\n");
            writer.write("Raza: " + mascota.getRaza() + "\n");
            writer.write("Propietario: " + mascota.getPropietario() + "\n");
            writer.write("Peso: " + mascota.getPeso() + " kg\n");
            writer.write("\n");
        }

        // Cerrar el archivo
        writer.close();

        JOptionPane.showMessageDialog(null, "Datos de mascotas guardados exitosamente en mascotas.txt");

    } catch (IOException e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_jMenuMascotaActionPerformed

    private void jMenuItemRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRecetaActionPerformed
        try {
            // Crear un archivo para guardar recetas
            FileWriter writer = new FileWriter("recetas.txt");

            // Consultar recetas desde la base de datos
            RecetasDAO recetasDAO = new RecetasDAO();
            List<Recetas> listaRecetas = recetasDAO.listar();

            // Escribir los datos en el archivo
            for (Recetas receta : listaRecetas) {
                writer.write("ID Receta: " + receta.getIdReceta() + "\n");
                writer.write("Fecha: " + receta.getFecha() + "\n");
                writer.write("Hora: " + receta.getHora() + "\n");
                writer.write("Medicamento: " + receta.getMedicamento() + "\n");
                writer.write("Cantidad: " + receta.getCantidad() + "\n");
                writer.write("Cada Cuantas Horas: " + receta.getCadaCuantasHoras() + "\n");
                writer.write("Próxima Consulta: " + receta.getProximaConsulta() + "\n");
                writer.write("\n");
            }

            // Cerrar el archivo
            writer.close();

            JOptionPane.showMessageDialog(null, "Datos de recetas guardados exitosamente en recetas.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItemRecetaActionPerformed

    // Método para abrir la ventana de Registrar_Veterinario
    private void abrirRegistrarVeterinario() {
        Registrar_Veterinario registrarVeterinario = new Registrar_Veterinario();
        jMenuReportes.add(registrarVeterinario);  // Agregar la ventana al JDesktopPane
        registrarVeterinario.setVisible(true);
        try {
            registrarVeterinario.setSelected(true);  // Traer al frente la ventana
        } catch (java.beans.PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }

// Método para abrir la ventana de Servicio_Recetas
    private void abrirServicioRecetas() {
        Servicio_Recetas servicioRecetas = new Servicio_Recetas();
        jMenuReportes.add(servicioRecetas);  // Agregar la ventana al JDesktopPane
        servicioRecetas.setVisible(true);
        try {
            servicioRecetas.setSelected(true);  // Traer al frente la ventana
        } catch (java.beans.PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INICIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuInicio;
    private javax.swing.JMenuItem jMenuItemReceta;
    private javax.swing.JMenuItem jMenuMascota;
    private javax.swing.JMenu jMenuMascotas;
    private javax.swing.JMenu jMenuRReportes;
    private javax.swing.JMenuItem jMenuReVeterinario;
    private javax.swing.JMenuItem jMenuRecetas;
    private javax.swing.JMenuItem jMenuRegistrarMascota;
    private javax.swing.JMenuItem jMenuRegistrarVeterinario;
    private javax.swing.JDesktopPane jMenuReportes;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JMenu jMenuServicios;
    private javax.swing.JMenu jMenuVeterinaria;
    private javax.swing.JMenu jMenuVeterinario;
    // End of variables declaration//GEN-END:variables
}