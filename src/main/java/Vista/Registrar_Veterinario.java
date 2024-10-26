package Vista;

import Controlador.ControladorVeterinario;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Registrar_Veterinario extends javax.swing.JInternalFrame {

    /**
     * Creates new form Registrar_Veterinario
     */
     // Definir el modelo para la tabla
    private DefaultTableModel modeloTabla;
    
    public Registrar_Veterinario() {
        initComponents();
        
         // Inicializar el modelo de la tabla con los nombres de las columnas
        modeloTabla = new DefaultTableModel(new String[]{"Código", "Nombres", "Apellidos", "Sexo", "Fecha Nacimiento", "Dirección", "Grado"}, 0);
        jTableVeterinario.setModel(modeloTabla); // Asignar el modelo a la tabla

        // Configurar el ComboBox de Sexo
        cboxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"MASCULINO", "FEMENINO"}));

        // Configurar el ComboBox de Grado
        jComboGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"PRACTICANTE", "EGRESADO", "TITULADO"}));
    }

    // Getters para los botones
    public javax.swing.JButton getBtnRefrescar() {
        return btnRefrescar; // Asume que 'btnRefrescar' es el botón que refresca la lista
    }

    public javax.swing.JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public javax.swing.JButton getBtnEditar() {
        return btnEditar;
    }

    public javax.swing.JButton getBtnEliminar() {
        return btnEliminar;
    }

    // Getters para la tabla
    public javax.swing.JTable getTableVeterinario() {
        return jTableVeterinario;
    }

    // Getters para los campos de texto
    public javax.swing.JTextField getTxtCodigoVeterinario() {
        return txtCodigoVeterinario;
    }

    public javax.swing.JTextField getTxtNombre() {
        return txtNombre;
    }

    public javax.swing.JTextField getTxtApellidos() {
        return txtApellidos;
    }

    public javax.swing.JTextField getTxtDireccion() {
        return txtDireccion;
    }

    // Getter para el ComboBox de Sexo
    public javax.swing.JComboBox<String> getCboxSexo() {
        return cboxSexo;
    }

    // Getter para la fecha de nacimiento (JDateChooser)
    public com.toedter.calendar.JDateChooser getDateNacimiento() {
        return dateNacimiento;
    }

    // Getter para el ComboBox de Grado
    public javax.swing.JComboBox<String> getJComboGrado() {
        return jComboGrado;
    }

    public void mostrarMensaje(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanelMascota = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblEspecie = new javax.swing.JLabel();
        lblFechaNac = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        txtCodigoVeterinario = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        dateNacimiento = new com.toedter.calendar.JDateChooser();
        cboxSexo = new javax.swing.JComboBox<>();
        JPanelBotonesVe = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRefrescar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboGrado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVeterinario = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("REGSITRO DEL VETERINARIO");

        jPanelMascota.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DEL VETERINARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(204, 0, 0))); // NOI18N

        lblCodigo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCodigo.setText("CODIGO DE VETERINARIO:");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNombre.setText("NOMBRES:");

        lblEspecie.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEspecie.setText("APELLIDOS:");

        lblFechaNac.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFechaNac.setText("FECHA DE NACIMIENTO:");

        lblSexo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSexo.setText("SEXO:");

        lblPeso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPeso.setText("DIRECCIÓN:");

        txtCodigoVeterinario.setEditable(false);
        txtCodigoVeterinario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtApellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        txtDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        dateNacimiento.setForeground(new java.awt.Color(0, 0, 204));
        dateNacimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cboxSexo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cboxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        JPanelBotonesVe.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRefrescar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefrescar.setText("ACTUALIZAR");
        btnRefrescar.setPreferredSize(new java.awt.Dimension(35, 35));
        btnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrescarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanelBotonesVeLayout = new javax.swing.GroupLayout(JPanelBotonesVe);
        JPanelBotonesVe.setLayout(JPanelBotonesVeLayout);
        JPanelBotonesVeLayout.setHorizontalGroup(
            JPanelBotonesVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelBotonesVeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnEditar)
                .addGap(57, 57, 57)
                .addComponent(btnEliminar)
                .addGap(14, 14, 14))
            .addGroup(JPanelBotonesVeLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelBotonesVeLayout.setVerticalGroup(
            JPanelBotonesVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelBotonesVeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPanelBotonesVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("GRADO:");

        jComboGrado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelMascotaLayout = new javax.swing.GroupLayout(jPanelMascota);
        jPanelMascota.setLayout(jPanelMascotaLayout);
        jPanelMascotaLayout.setHorizontalGroup(
            jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMascotaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMascotaLayout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addGap(6, 6, 6)
                        .addComponent(txtCodigoVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(537, 553, Short.MAX_VALUE))
                    .addGroup(jPanelMascotaLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(6, 6, 6)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JPanelBotonesVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
            .addGroup(jPanelMascotaLayout.createSequentialGroup()
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMascotaLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblEspecie)
                        .addGap(9, 9, 9)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelMascotaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMascotaLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelMascotaLayout.createSequentialGroup()
                                    .addComponent(lblFechaNac)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelMascotaLayout.createSequentialGroup()
                                    .addComponent(lblPeso)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDireccion))
                                .addGroup(jPanelMascotaLayout.createSequentialGroup()
                                    .addComponent(lblSexo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMascotaLayout.setVerticalGroup(
            jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMascotaLayout.createSequentialGroup()
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMascotaLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblCodigo))
                    .addComponent(txtCodigoVeterinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPanelBotonesVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelMascotaLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMascotaLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblEspecie))
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSexo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaNac)
                            .addComponent(dateNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeso)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMascotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jComboGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jTableVeterinario.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableVeterinario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVeterinarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVeterinario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(56, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelMascota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // Crear una instancia del controlador
    ControladorVeterinario controlador = new ControladorVeterinario(this);

    // Llamar al método agregar del controlador
    controlador.agregar();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
      // Crear una instancia del controlador
    ControladorVeterinario controlador = new ControladorVeterinario(this);

    // Llamar al método editar del controlador
    controlador.editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         // Crear una instancia del controlador
    ControladorVeterinario controlador = new ControladorVeterinario(this);

    // Llamar al método eliminar del controlador
    controlador.eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrescarActionPerformed
        // Crear una instancia del controlador
    ControladorVeterinario controlador = new ControladorVeterinario(this);

    // Llamar al método listar para refrescar los datos en la tabla
    controlador.listar(jTableVeterinario);
    }//GEN-LAST:event_btnRefrescarActionPerformed

    private void jTableVeterinarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVeterinarioMouseClicked
          // Obtener la fila seleccionada
    int fila = jTableVeterinario.getSelectedRow();

    // Cargar los datos de la fila seleccionada en los campos de texto
    txtCodigoVeterinario.setText(jTableVeterinario.getValueAt(fila, 0).toString());
    txtNombre.setText(jTableVeterinario.getValueAt(fila, 1).toString());
    txtApellidos.setText(jTableVeterinario.getValueAt(fila, 2).toString());
    cboxSexo.setSelectedItem(jTableVeterinario.getValueAt(fila, 3).toString());
    dateNacimiento.setDate(java.sql.Date.valueOf(jTableVeterinario.getValueAt(fila, 4).toString())); // Conversión de String a Date
    txtDireccion.setText(jTableVeterinario.getValueAt(fila, 5).toString());
    jComboGrado.setSelectedItem(jTableVeterinario.getValueAt(fila, 6).toString());
    }//GEN-LAST:event_jTableVeterinarioMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
             char c = evt.getKeyChar();
    
    // Verifica si el carácter no es una letra
    if (!Character.isLetter(c)) {
        evt.consume(); // Ignora el carácter si no es letra
    }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
              char c = evt.getKeyChar();
    
    // Verifica si el carácter no es una letra
    if (!Character.isLetter(c)) {
        evt.consume(); // Ignora el carácter si no es letra
    }
    }//GEN-LAST:event_txtApellidosKeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelBotonesVe;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRefrescar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboxSexo;
    private com.toedter.calendar.JDateChooser dateNacimiento;
    private javax.swing.JComboBox<String> jComboGrado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelMascota;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVeterinario;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEspecie;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCodigoVeterinario;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}