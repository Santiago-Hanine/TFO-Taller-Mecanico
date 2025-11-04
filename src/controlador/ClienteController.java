package controlador;

import vista.ClienteView;
import dominio.cliente.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private final ClienteView view;
    private final List<Cliente> clientes = new ArrayList<>();
    private final DefaultTableModel model;

    public ClienteController(ClienteView view) {
        this.view = view;
        this.model = new DefaultTableModel(new Object[]{"Nombre", "Email", "Edad", "Teléfono"}, 0);
        view.getTablaClientes().setModel(model);
        inicializar();
    }

    private void inicializar() {
        view.getBtnGuardar().addActionListener(e -> guardarCliente());
        view.getBtnCancelar().addActionListener(e -> view.limpiarFormulario());
    }

    private void guardarCliente() {
        String nombre = view.getNombre();
        String email = view.getEmail();
        int edad = view.getEdad();
        int telefono = view.getTelefono();

        if (nombre.isEmpty() || email.isEmpty() || edad <= 0) {
            view.mostrarMensaje("Complete todos los campos correctamente.");
            return;
        }

        Cliente cliente = new Cliente(nombre, edad, telefono, email);
        clientes.add(cliente);
        model.addRow(new Object[]{nombre, email, edad, telefono});
        view.mostrarMensaje("Cliente guardado correctamente.");
        view.limpiarFormulario();
    }


}
