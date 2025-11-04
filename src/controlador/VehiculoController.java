package controlador;

import vista.VehiculoView;
import dominio.vehiculo.Vehiculo;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class VehiculoController {
    private final VehiculoView view;
    private final List<Vehiculo> vehiculos = new ArrayList<>();
    private final DefaultTableModel model;

    public VehiculoController(VehiculoView view) {
        this.view = view;
        this.model = new DefaultTableModel(new Object[]{"Patente", "Marca", "Modelo", "Año", "Cliente"}, 0);
        view.getTablaVehiculos().setModel(model);
        inicializar();
    }

    private void inicializar() {
        view.getBtnGuardar().addActionListener(e -> guardarVehiculo());
        view.getBtnCancelar().addActionListener(e -> view.limpiarFormulario());
    }

    private void guardarVehiculo() {
        String patente = view.getPatente();
        String marca = view.getMarca();
        String modelo = view.getModelo();
        int anio = view.getAnio();
        String cliente = view.getCliente();

        if (patente.isEmpty() || marca.isEmpty() || modelo.isEmpty() || anio <= 0) {
            view.mostrarMensaje("Complete todos los campos correctamente.");
            return;
        }

        Vehiculo vehiculo = new Vehiculo(patente, marca, modelo, anio, cliente);
        vehiculos.add(vehiculo);
        model.addRow(new Object[]{patente, marca, modelo, anio, cliente});
        view.mostrarMensaje("Vehículo guardado correctamente.");
        view.limpiarFormulario();
    }

    private void eliminarVehiculo() {
        int fila = view.getTablaVehiculos().getSelectedRow();
        if (fila >= 0) {
            vehiculos.remove(fila);
            model.removeRow(fila);
            view.mostrarMensaje("Vehículo eliminado.");
        } else {
            view.mostrarMensaje("Seleccione un vehículo para eliminar.");
        }
    }
}
