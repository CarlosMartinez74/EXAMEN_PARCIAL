package Controlador;

import Modelo.Recetas;
import Modelo.RecetasDAO;
import Modelo.Mascotas;
import Vista.Servicio_Recetas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class ControladorRecetas implements ActionListener {

    private RecetasDAO dao;
    private Recetas receta;
    private Servicio_Recetas vista;
    private DefaultTableModel modelo;

    public ControladorRecetas(Servicio_Recetas vista) {
        this.vista = vista;
        this.dao = new RecetasDAO();
        this.receta = new Recetas();

        // Quita cualquier ActionListener existente para evitar duplicación
        for (ActionListener al : this.vista.getBtnGuardar().getActionListeners()) {
            this.vista.getBtnGuardar().removeActionListener(al);
        }
        for (ActionListener al : this.vista.getBtnEditar().getActionListeners()) {
            this.vista.getBtnEditar().removeActionListener(al);
        }
        for (ActionListener al : this.vista.getBtnEliminar().getActionListeners()) {
            this.vista.getBtnEliminar().removeActionListener(al);
        }

        // Agregar ActionListeners
        this.vista.getBtnGuardar().addActionListener(this);
        this.vista.getBtnEditar().addActionListener(this);
        this.vista.getBtnEliminar().addActionListener(this);

        this.vista.getTablaRecetas().addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seleccionarReceta();
            }
        });

        listarRecetas();
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
    }

    public void agregar() {
        Recetas receta = new Recetas();

        // Obtener la fecha desde el label que ya tiene la fecha actual
        String fechaTexto = vista.getLabelFecha().getText().trim();

        // Convertir el texto de fecha al tipo java.sql.Date
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        try {
            java.util.Date fechaUtil = formatoFecha.parse(fechaTexto);
            receta.setFecha(new java.sql.Date(fechaUtil.getTime()));  // Guardar fecha convertida
        } catch (Exception e) {
            vista.mostrarMensaje("Error al convertir la fecha.");
            return;
        }

        // Obtener la hora desde el label y convertirla a java.sql.Time
        String horaTexto = vista.getLabelHora().getText().trim();
        try {
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            java.util.Date horaUtil = formatoHora.parse(horaTexto);
            Time horaSql = new Time(horaUtil.getTime());
            receta.setHora(horaSql);  // Guardar la hora en formato TIME
        } catch (Exception e) {
            vista.mostrarMensaje("Error al convertir la hora.");
            return;
        }

        // Los demás valores se toman de los campos correspondientes
        receta.setMedicamento(vista.getMedicamento().getText());
        receta.setCantidad(Integer.parseInt(vista.getCantidad().getText()));
        receta.setCadaCuantasHoras(vista.getHorasTiempo().getText());

        // Obtener el ID de la mascota seleccionada
        String selectedText = vista.getMascotaSeleccionada();
        Mascotas mascotaSeleccionada = vista.getMascotaMap().get(selectedText);
        if (mascotaSeleccionada != null) {
            receta.setMascotaId(mascotaSeleccionada.getCodigoMascota());
        }

        receta.setDueño(vista.getDueño().getText());

        // Verificar si se seleccionó una próxima consulta antes de guardarla
        if (vista.getJDateConsulta().getDate() != null) {
            receta.setProximaConsulta(new java.sql.Date(vista.getJDateConsulta().getDate().getTime()));
        } else {
            receta.setProximaConsulta(null);  // O asignar un valor por defecto si es opcional
        }

        // Guardar la receta usando el DAO
        int resultado = dao.agregar(receta);
        if (resultado == 1) {
            vista.mostrarMensaje("Receta guardada correctamente");
            listarRecetas();  // Actualiza la tabla después de guardar
        } else {
            vista.mostrarMensaje("Error al guardar la receta");
        }
    }

    public void editar() {
        int fila = vista.getTablaRecetas().getSelectedRow();
        if (fila == -1) {
            vista.mostrarMensaje("Debe seleccionar una receta para editar");
        } else {
            receta.setIdReceta((int) vista.getTablaRecetas().getValueAt(fila, 0));
            receta.setFecha((java.sql.Date) vista.getTablaRecetas().getValueAt(fila, 1));

            // Verificar que la hora sea válida
            String horaTexto = vista.getTablaRecetas().getValueAt(fila, 2).toString();
            if (horaTexto.matches("\\d{2}:\\d{2}:\\d{2}")) {  // Formato HH:mm:ss
                receta.setHora(Time.valueOf(horaTexto));
            } else {
                vista.mostrarMensaje("La hora no es válida. Formato esperado: HH:mm:ss");
                return;  // Salir del método si la hora no es válida
            }

            receta.setMedicamento(vista.getTablaRecetas().getValueAt(fila, 6).toString());
            receta.setCantidad(Integer.parseInt(vista.getTablaRecetas().getValueAt(fila, 7).toString()));
            receta.setCadaCuantasHoras(vista.getTablaRecetas().getValueAt(fila, 8).toString());
            receta.setDueño(vista.getTablaRecetas().getValueAt(fila, 4).toString());
            receta.setProximaConsulta((java.sql.Date) vista.getTablaRecetas().getValueAt(fila, 5));

            int resultado = dao.actualizar(receta);
            if (resultado == 1) {
                vista.mostrarMensaje("Receta actualizada correctamente");
                listarRecetas();
            } else {
                vista.mostrarMensaje("Error al actualizar la receta");
            }
        }
    }

    public void eliminar() {
        int fila = vista.getTablaRecetas().getSelectedRow();
        if (fila == -1) {
            vista.mostrarMensaje("Debe seleccionar una receta para eliminar");
        } else {
            try {
                int idReceta = Integer.parseInt(vista.getTablaRecetas().getValueAt(fila, 0).toString());
                dao.eliminar(idReceta);
                vista.mostrarMensaje("Receta eliminada correctamente");
                listarRecetas();
            } catch (NumberFormatException ex) {
                vista.mostrarMensaje("Error: no se pudo convertir el ID de la receta a un número válido");
            }
        }
    }

    public void listarRecetas() {
        modelo = (DefaultTableModel) vista.getTablaRecetas().getModel();
        modelo.setRowCount(0);
        for (Recetas r : dao.listar()) {
            modelo.addRow(new Object[]{
                r.getIdReceta(),
                r.getFecha(),
                r.getHora(),
                r.getMascotaId(),
                r.getDueño(),
                r.getProximaConsulta(),
                r.getMedicamento(),
                r.getCantidad(),
                r.getCadaCuantasHoras()
            });
        }
    }

    public void seleccionarReceta() {
        int fila = vista.getTablaRecetas().getSelectedRow();
        if (fila != -1) {
            // Asegúrate de que estás accediendo solo a columnas válidas
            vista.getJDateConsulta().setDate((java.util.Date) vista.getTablaRecetas().getValueAt(fila, 1));
            vista.getLabelHora().setText(vista.getTablaRecetas().getValueAt(fila, 2).toString());
            vista.getMedicamento().setText(vista.getTablaRecetas().getValueAt(fila, 6).toString());
            vista.getCantidad().setText(vista.getTablaRecetas().getValueAt(fila, 7).toString());
            vista.getHorasTiempo().setText(vista.getTablaRecetas().getValueAt(fila, 8).toString());  // Verifica el índice aquí
            vista.getDueño().setText(vista.getTablaRecetas().getValueAt(fila, 4).toString());
            vista.getJDateConsulta().setDate((java.util.Date) vista.getTablaRecetas().getValueAt(fila, 5));
        }
    }
}
