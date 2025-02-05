package com.ecsa.eokz;

import javax.swing.*;
import java.awt.*;

public class IngresoMercaderiaView {
    private ProductoController controller;

    public IngresoMercaderiaView() {
        controller = new ProductoController();
    }

    public JPanel getPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 2));

        JTextField codigoField = new JTextField();
        JTextField descripcionField = new JTextField();
        JTextField materialField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField precioField = new JTextField();
        JTextField stockField = new JTextField();

        panel.add(new JLabel("Código:"));
        panel.add(codigoField);
        panel.add(new JLabel("Descripción:"));
        panel.add(descripcionField);
        panel.add(new JLabel("Material:"));
        panel.add(materialField);
        panel.add(new JLabel("Color:"));
        panel.add(colorField);
        panel.add(new JLabel("Precio:"));
        panel.add(precioField);
        panel.add(new JLabel("Stock:"));
        panel.add(stockField);

        JButton btnAgregar = new JButton("Agregar Producto");
        btnAgregar.addActionListener(e -> {
            Producto producto = new Producto(
                    codigoField.getText(),
                    descripcionField.getText(),
                    materialField.getText(),
                    colorField.getText(),
                    Double.parseDouble(precioField.getText()),
                    Integer.parseInt(stockField.getText())
            );
            controller.agregarProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente.");
        });

        panel.add(btnAgregar);

        return panel;
    }
}