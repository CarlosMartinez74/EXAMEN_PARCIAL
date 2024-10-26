package Vista;

import Controlador.ControladorRecetas;
import Modelo.Mascotas;
import Modelo.MascotasDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Servicio_Recetas extends javax.swing.JInternalFrame {

    /**
     * Creates new form Registrar_Veterinario
     */
    private ControladorRecetas controlador;
    private DefaultTableModel modeloTablaRecetas;

    public Servicio_Recetas() {
        initComponents();
        establecerFechaActual(labelFecha);
        establecerHoraActual(labelHora);
        addComboBoxListener();
        cargarMascotasEnComboBox();

        controlador = new ControladorRecetas(this);

        // Inicializar el modelo de la tabla con los nombres de las columnas
        modeloTablaRecetas = new DefaultTableModel(new String[]{
            "ID", "Fecha", "Hora", "ID Mascota", "Dueño y Mascota", "Próxima Consulta",
            "Medicamento", "Cantidad", "Cada Cuantas Horas"
        }, 0);
        jTableRecetas.setModel(modeloTablaRecetas);
    }

// Asignar el modelo a la tabla de recetas
    private void addComboBoxListener() {
        jComboMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMascotasActionPerformed(evt);  // Llamada cuando se selecciona una mascota
            }
        });
    }

    public void establecerFechaActual(JLabel labelFecha) {
        // Crear un objeto Date con la fecha y hora actuales
        Date fechaActual = new Date();

        // Definir el formato deseado para la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

        // Formatear la fecha actual según el formato definido
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Establecer la fecha formateada en el JLabel
        labelFecha.setText(fechaFormateada);
    }

    public void establecerHoraActual(JLabel labelHora) {
        // Crear un Timer que se ejecute cada segundo
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un objeto Date con la hora actual
                Date horaActual = new Date();

                // Definir el formato deseado para la hora
                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

                // Formatear la hora actual según el formato definido
                String horaFormateada = formatoHora.format(horaActual);

                // Establecer la hora formateada en el JLabel
                labelHora.setText(horaFormateada);
            }
        });

        // Iniciar el Timer para que comience a actualizar la hora cada segundo
        timer.start();
    }

    // Getters
    public javax.swing.JButton getBtnGuardar() {
        return btnGuardar;
    }

    public javax.swing.JButton getBtnEditar() {
        return btnEditar;
    }

    public javax.swing.JButton getBtnEliminar() {
        return btnEliminar;
    }

    public javax.swing.JTextField getMedicamento() {
        return txtMedicamento;
    }

    public javax.swing.JTextField getCantidad() {
        return txtCantidad;
    }

    public javax.swing.JTextField getHorasTiempo() {
        return txtHorasTiempo;
    }

    public javax.swing.JTextField getDueño() {
        return txtDueño;
    }

    public javax.swing.JTable getTablaRecetas() {
        return jTableRecetas;
    }

    public javax.swing.JLabel getLabelFecha() {
        return labelFecha;
    }

    public javax.swing.JLabel getLabelHora() {
        return labelHora;
    }

    public com.toedter.calendar.JDateChooser getJDateConsulta() {
        return jDateConsulta;
    }

    public String getMascotaSeleccionada() {
        return jComboMascotas.getSelectedItem().toString();
    }

    public Map<String, Mascotas> getMascotaMap() {
        return mascotaMap;
    }

    public void mostrarMensaje(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje);
    }

    // Método para autocompletar el campo "dueño"
    private void jComboMascotasActionPerformed(java.awt.event.ActionEvent evt) {
         String selectedText = (String) jComboMascotas.getSelectedItem();
    Mascotas selectedMascota = mascotaMap.get(selectedText);

    if (selectedMascota != null) {
        System.out.println("Mascota seleccionada: ID = " + selectedMascota.getCodigoMascota());
        txtDueño.setText(selectedMascota.getEspecie() + " - " + selectedMascota.getNombre() + " - " + selectedMascota.getPropietario());
    } else {
        System.out.println("Error: La mascota con ID " + selectedText + " no está en el mapa.");
        txtDueño.setText("Mascota no encontrada");
    }
    }

    // Método para cargar las mascotas en el JComboBox
    public void cargarMascotasEnComboBox() {
        MascotasDAO mascotasDAO = new MascotasDAO();
        List<Mascotas> listaMascotas = mascotasDAO.listar();

        jComboMascotas.removeAllItems();
        mascotaMap.clear();

        for (Mascotas mascota : listaMascotas) {
            String displayText = String.valueOf(mascota.getCodigoMascota());  // Mostrar solo el ID
            jComboMascotas.addItem(displayText);
            mascotaMap.put(displayText, mascota);  // Guardar la referencia en el mapa

            // Agregar debug para verificar los datos
            System.out.println("Mascota cargada: ID = " + mascota.getCodigoMascota() + ", Nombre = " + mascota.getNombre());
        }
    }

    private Map<String, Mascotas> mascotaMap = new HashMap<>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDueño = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDateConsulta = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMedicamento = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtHorasTiempo = new javax.swing.JTextField();
        labelFecha = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        jPanelBotonesRec = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jComboMascotas = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableRecetas = new javax.swing.JTable();

        setClosable(true);
        setMinimumSize(new java.awt.Dimension(1016, 616));
        setPreferredSize(new java.awt.Dimension(1016, 616));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("REGSITRO RECETAS");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("FECHA:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 37, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("HORA:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 78, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ID-MASCOTA:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 123, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("DUEÑO Y MASCOTA:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 171, -1, -1));

        txtDueño.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtDueño, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 316, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("PROXIMA CONSULTA:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 222, -1, -1));

        jDateConsulta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(jDateConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 220, 166, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("MEDICAMENTO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("CANTIDAD:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("CADA CUANTAS HORAS:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, -1, 16));

        txtMedicamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 197, -1));

        txtCantidad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 114, -1));

        txtHorasTiempo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtHorasTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 110, 106, -1));

        labelFecha.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        labelFecha.setForeground(new java.awt.Color(0, 153, 51));
        labelFecha.setText("jLabel6");
        jPanel1.add(labelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 37, -1, -1));

        labelHora.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        labelHora.setForeground(new java.awt.Color(0, 153, 51));
        labelHora.setText("jLabel10");
        jPanel1.add(labelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 78, -1, -1));

        jPanelBotonesRec.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 3, true));
        jPanelBotonesRec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanelBotonesRec.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanelBotonesRec.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanelBotonesRec.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jPanel1.add(jPanelBotonesRec, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 360, 40));

        jComboMascotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboMascotas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboMascotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 200, 30));

        jTableRecetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableRecetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRecetasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableRecetas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(376, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(404, 404, 404))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        controlador.agregar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        controlador.editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        controlador.eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jTableRecetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRecetasMouseClicked
        int filaSeleccionada = jTableRecetas.getSelectedRow();  // Obtener la fila seleccionada
        if (filaSeleccionada != -1) {
            // Asegurar que solo se intenten convertir columnas que realmente contienen fechas

            // Verificar que el valor es una fecha antes de convertirlo
            Object valorFecha = jTableRecetas.getValueAt(filaSeleccionada, 0);  // Columna 0 debe ser fecha
            if (valorFecha instanceof java.util.Date) {
                jDateConsulta.setDate((java.util.Date) valorFecha);  // Asignar la fecha de la receta
            } else {
                // Si no es una fecha, manejar el caso (puedes mostrar un mensaje de error o manejarlo de otra manera)
                System.out.println("El valor en la columna de fecha no es una fecha válida.");
            }

            // Hora (columna 1) - Siempre debe ser un String
            String hora = jTableRecetas.getValueAt(filaSeleccionada, 1).toString();
            labelHora.setText(hora);  // Asignar la hora al JLabel

            // Medicamento (columna 5) - String
            String medicamento = jTableRecetas.getValueAt(filaSeleccionada, 5).toString();
            txtMedicamento.setText(medicamento);  // Asignar el medicamento

            // Cantidad (columna 6) - String o entero
            String cantidad = jTableRecetas.getValueAt(filaSeleccionada, 6).toString();
            txtCantidad.setText(cantidad);  // Asignar la cantidad

            // Cada Cuantas Horas (columna 7) - String
            String horasTiempo = jTableRecetas.getValueAt(filaSeleccionada, 7).toString();
            txtHorasTiempo.setText(horasTiempo);  // Asignar cada cuántas horas

            // Dueño y Mascota (columna 3) - String
            String dueñoMascota = jTableRecetas.getValueAt(filaSeleccionada, 3).toString();
            txtDueño.setText(dueñoMascota);  // Asignar el dueño y la mascota

            // Verificar que el valor es una fecha antes de convertirlo para la próxima consulta
            Object valorProximaConsulta = jTableRecetas.getValueAt(filaSeleccionada, 4);  // Columna 4 debe ser fecha
            if (valorProximaConsulta instanceof java.util.Date) {
                jDateConsulta.setDate((java.util.Date) valorProximaConsulta);  // Asignar la próxima consulta
            } else {
                // Si no es una fecha, manejar el caso
                System.out.println("El valor en la columna de próxima consulta no es una fecha válida.");
            }
        }
    }//GEN-LAST:event_jTableRecetasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> jComboMascotas;
    private com.toedter.calendar.JDateChooser jDateConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBotonesRec;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableRecetas;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHora;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDueño;
    private javax.swing.JTextField txtHorasTiempo;
    private javax.swing.JTextField txtMedicamento;
    // End of variables declaration//GEN-END:variables
}
