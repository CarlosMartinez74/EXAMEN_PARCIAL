package Controlador;

import Modelo.Mascotas;
import Modelo.MascotasDAO;
import Vista.Registrar_Mascota;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ControladorMascotas implements ActionListener {

    private MascotasDAO dao;
    private Mascotas mascota;
    private Registrar_Mascota vista;
    private DefaultTableModel modelo;
    
    

    public ControladorMascotas(Registrar_Mascota vista) {
        this.vista = vista;
        this.dao = new MascotasDAO();  // Inicializar DAO
        this.mascota = new Mascotas();  // Inicializar objeto Mascotas

        // Agregar los listeners a los botones
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnEditar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
        this.vista.getBtnRefrescar().addActionListener(this);

        listar(vista.getTableDatosMascota());  // Llenar la tabla al inicio
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnGuardar()) {
            agregar();
        }
        if (e.getSource() == vista.getBtnEditar()) {
            editar();
        }
        if (e.getSource() == vista.getBtnEliminar()) {
            eliminar();
        }
        if (e.getSource() == vista.getBtnRefrescar()) {
            listar(vista.getTableDatosMascota());
        }
    }

    public void limpiarCampos() {
        vista.getTxtCodigo().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtEspecie().setText("");
        vista.getTxtRaza().setText("");
        vista.getJtxtCaracteristicas().setText("");
        vista.getCboxSexo().setSelectedIndex(0);
        vista.getCboxCastrado().setSelectedIndex(0);
        vista.getDateNacimiento().setDate(null);
        vista.getTxtPeso().setText("");
        vista.getTxtPropietario().setText("");  // Propietario
        vista.getTxtNumPropietario().setText("");  // NumPropietario
    }

    // Método para listar datos en la tabla
    public void listar(javax.swing.JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);  // Limpiar la tabla
        for (Mascotas m : dao.listar()) {
            modelo.addRow(new Object[]{
                m.getCodigoMascota(),
                m.getNombre(),
                m.getEspecie(),
                m.getRaza(),
                m.getCaracteristicas(),
                m.getSexo(),
                m.isCastrado(),
                m.getFechaNacimiento(), // Asegúrate que este valor es del tipo Date
                m.getPeso(),
                m.getPropietario(),
                m.getNumPropietario()
            });
        }
    }

    // Método para agregar una nueva mascota
    public void agregar() {
        String nombre = vista.getTxtNombre().getText();
        String especie = vista.getTxtEspecie().getText();
        String raza = vista.getTxtRaza().getText();
        String caracteristicas = vista.getJtxtCaracteristicas().getText();
        String sexo = vista.getCboxSexo().getSelectedItem().toString();
        boolean castrado = vista.getCboxCastrado().getSelectedItem().toString().equals("Sí");
        java.util.Date utilFechaNacimiento = vista.getDateNacimiento().getDate();
        java.sql.Date fechaNacimiento = new java.sql.Date(utilFechaNacimiento.getTime());
        double peso = Double.parseDouble(vista.getTxtPeso().getText());
        String propietario = vista.getTxtPropietario().getText();
        String numPropietario = vista.getTxtNumPropietario().getText();

        mascota.setNombre(nombre);
        mascota.setEspecie(especie);
        mascota.setRaza(raza);
        mascota.setCaracteristicas(caracteristicas);
        mascota.setSexo(sexo);
        mascota.setCastrado(castrado);
        mascota.setFechaNacimiento(fechaNacimiento);
        mascota.setPeso(peso);
        mascota.setPropietario(propietario);
        mascota.setNumPropietario(numPropietario);

        int resultado = dao.agregar(mascota);
        if (resultado == 1) {
            vista.mostrarMensaje("Mascota registrada correctamente");
            listar(vista.getTableDatosMascota());
            limpiarCampos();
        } else {
            vista.mostrarMensaje("Error al registrar la mascota");
        }
    }

    // Método para editar una mascota
    public void editar() {
        int fila = vista.getTableDatosMascota().getSelectedRow();
        if (fila == -1) {
            vista.mostrarMensaje("Debe seleccionar una fila");
        } else {
            int codigoMascota = Integer.parseInt(vista.getTxtCodigo().getText());
            String nombre = vista.getTxtNombre().getText();
            String especie = vista.getTxtEspecie().getText();
            String raza = vista.getTxtRaza().getText();
            String caracteristicas = vista.getJtxtCaracteristicas().getText();
            String sexo = vista.getCboxSexo().getSelectedItem().toString();
            boolean castrado = vista.getCboxCastrado().getSelectedItem().toString().equals("Sí");
            java.util.Date utilFechaNacimiento = vista.getDateNacimiento().getDate();
            java.sql.Date fechaNacimiento = new java.sql.Date(utilFechaNacimiento.getTime());
            double peso = Double.parseDouble(vista.getTxtPeso().getText());
            String propietario = vista.getTxtPropietario().getText();
            String numPropietario = vista.getTxtNumPropietario().getText();

            mascota.setCodigoMascota(codigoMascota);
            mascota.setNombre(nombre);
            mascota.setEspecie(especie);
            mascota.setRaza(raza);
            mascota.setCaracteristicas(caracteristicas);
            mascota.setSexo(sexo);
            mascota.setCastrado(castrado);
            mascota.setFechaNacimiento(fechaNacimiento);
            mascota.setPeso(peso);
            mascota.setPropietario(propietario);
            mascota.setNumPropietario(numPropietario);

            int resultado = dao.actualizar(mascota);
            if (resultado == 1) {
                vista.mostrarMensaje("Mascota actualizada correctamente");
                listar(vista.getTableDatosMascota());
            } else {
                vista.mostrarMensaje("Error al actualizar la mascota");
            }
        }
    }

    // Método para eliminar una mascota
    public void eliminar() {
        int fila = vista.getTableDatosMascota().getSelectedRow();
        if (fila == -1) {
            vista.mostrarMensaje("Debe seleccionar una fila");
        } else {
            int codigoMascota = Integer.parseInt(vista.getTableDatosMascota().getValueAt(fila, 0).toString());
            dao.eliminar(codigoMascota);
            vista.mostrarMensaje("Mascota eliminada correctamente");
            listar(vista.getTableDatosMascota());
        }
    }
}
