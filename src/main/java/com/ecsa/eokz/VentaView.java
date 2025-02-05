package com.ecsa.eokz;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class VentaView {
    private VentaController controller;

    public VentaView() {
        controller = new VentaController();
    }

    public JPanel getPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField fechaField = new JTextField();
        JTextField valorTotalField = new JTextField();
        JTextField ivaField = new JTextField();
        JTextField valorRecibidoField = new JTextField();

        panel.add(new JLabel("Fecha:"));
        panel.add(fechaField);
        panel.add(new JLabel("Valor Total:"));
        panel.add(valorTotalField);
        panel.add(new JLabel("IVA:"));
        panel.add(ivaField);
        panel.add(new JLabel("Valor Recibido:"));
        panel.add(valorRecibidoField);

        JButton btnRegistrar = new JButton("Registrar Venta");
        btnRegistrar.addActionListener(e -> {
            Venta venta = new Venta(
                    fechaField.getText(),
                    Double.parseDouble(valorTotalField.getText()),
                    Double.parseDouble(ivaField.getText()),
                    Double.parseDouble(valorRecibidoField.getText())
            );
            // Aquí puedes agregar los detalles de la venta (productos vendidos)
            List<DetalleVenta> detalles = new ArrayList<>();
            controller.agregarVenta(venta, detalles);
            JOptionPane.showMessageDialog(null, "Venta registrada correctamente.");
        });

        panel.add(btnRegistrar);

        return panel;
    }
}
