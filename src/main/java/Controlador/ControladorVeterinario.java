package Controlador;

import Modelo.Veterinario;
import Modelo.VeterinarioDAO;
import Vista.Registrar_Veterinario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ControladorVeterinario implements ActionListener {

    private VeterinarioDAO dao;
    private Veterinario v;
    private Registrar_Veterinario vista;
    private DefaultTableModel modelo;

    public ControladorVeterinario(Registrar_Veterinario vista) {
        this.vista = vista;
        this.dao = new VeterinarioDAO();  // Inicializar DAO
        this.v = new Veterinario();  // Inicializar objeto Veterinario

        // Agregar los listeners a los botones usando los getters
        this.vista.getBtnRefrescar().addActionListener(this);
        this.vista.getBtnRegistrar().addActionListener(this);
        this.vista.getBtnEditar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnRefrescar()) {
            listar(vista.getTableVeterinario());
        }
        if (e.getSource() == vista.getBtnRegistrar()) {
            agregar();
        }
        if (e.getSource() == vista.getBtnEditar()) {
            editar();
        }
        if (e.getSource() == vista.getBtnEliminar()) {
            eliminar();
        }
    }

    public void limpiarCampos() {
        vista.getTxtCodigoVeterinario().setText("");
        vista.getTxtNombre().setText("");
        vista.getTxtApellidos().setText("");
        vista.getCboxSexo().setSelectedIndex(0);
        vista.getDateNacimiento().setDate(null);
        vista.getTxtDireccion().setText("");
        vista.getJComboGrado().setSelectedIndex(0);
    }

// Método para listar datos 
    public void listar(javax.swing.JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);  // Limpiar la tabla

        // Llenar la tabla con los datos de la base de datos
        for (Veterinario v : dao.listar()) {
            modelo.addRow(new Object[]{
                v.getCodigoVeterinario(),
                v.getNombres(),
                v.getApellidos(),
                v.getSexo(),
                v.getFechaNacimiento(),
                v.getDireccion(),
                v.getGrado()
            });
        }
    }

    // Método para agregar un nuevo veterinario
    public void agregar() {
        String nombres = vista.getTxtNombre().getText();
        String apellidos = vista.getTxtApellidos().getText();
        String sexo = vista.getCboxSexo().getSelectedItem().toString();
        java.util.Date utilFechaNacimiento = vista.getDateNacimiento().getDate();
        java.sql.Date fechaNacimiento = new java.sql.Date(utilFechaNacimiento.getTime());
        String direccion = vista.getTxtDireccion().getText();
        String grado = vista.getJComboGrado().getSelectedItem().toString();

        v.setNombres(nombres);
        v.setApellidos(apellidos);
        v.setSexo(sexo);
        v.setFechaNacimiento(fechaNacimiento);
        v.setDireccion(direccion);
        v.setGrado(grado);

        int resultado = dao.agregar(v);
        if (resultado == 1) {
            vista.mostrarMensaje("Veterinario agregado correctamente");
            listar(vista.getTableVeterinario());
            limpiarCampos();  // Limpiar los campos después de guardar
        } else {
            vista.mostrarMensaje("Error al agregar el veterinario");
        }
    }

    // Método para editar un veterinario
    public void editar() {
        // Obtener los datos de los campos de texto
        int codigoVeterinario = Integer.parseInt(vista.getTxtCodigoVeterinario().getText());
        String nombres = vista.getTxtNombre().getText();
        String apellidos = vista.getTxtApellidos().getText();
        String sexo = vista.getCboxSexo().getSelectedItem().toString();
        java.util.Date utilFechaNacimiento = vista.getDateNacimiento().getDate();
        java.sql.Date fechaNacimiento = new java.sql.Date(utilFechaNacimiento.getTime());
        String direccion = vista.getTxtDireccion().getText();
        String grado = vista.getJComboGrado().getSelectedItem().toString();

        // Configurar los datos del veterinario
        v.setCodigoVeterinario(codigoVeterinario);
        v.setNombres(nombres);
        v.setApellidos(apellidos);
        v.setSexo(sexo);
        v.setFechaNacimiento(fechaNacimiento);
        v.setDireccion(direccion);
        v.setGrado(grado);

        // Actualizar el registro en la base de datos
        int resultado = dao.actualizar(v);
        if (resultado == 1) {
            vista.mostrarMensaje("Veterinario actualizado correctamente");  // Mostrar el mensaje solo una vez
            listar(vista.getTableVeterinario());  // Refrescar la tabla después de editar
        } else {
            vista.mostrarMensaje("Error al actualizar el veterinario");
        }
    }

// Método para eliminar un veterinario
    public void eliminar() {
        int fila = vista.getTableVeterinario().getSelectedRow();
        if (fila == -1) {
            vista.mostrarMensaje("Debe seleccionar una fila para eliminar");
        } else {
            int codigoVeterinario = Integer.parseInt(vista.getTableVeterinario().getValueAt(fila, 0).toString());
            dao.eliminar(codigoVeterinario);  // Eliminar de la base de datos

            vista.mostrarMensaje("Veterinario eliminado correctamente");  // Mostrar el mensaje solo una vez
            listar(vista.getTableVeterinario());  // Refrescar la tabla después de eliminar
        }
    }

}
