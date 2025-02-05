package com.ecsa.eokz;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class InventarioView {
    private ProductoController controller;

    public InventarioView() {
        controller = new ProductoController();
    }

    public JPanel getPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Botón para agregar producto
        JButton btnAgregar = new JButton("Agregar Producto");
        btnAgregar.addActionListener(e -> agregarProducto());

        // Tabla para mostrar productos
        String[] columnNames = {"ID", "Código", "Descripción", "Material", "Color", "Precio", "Stock"};
        List<Producto> productos = controller.obtenerProductos();
        Object[][] data = new Object[productos.size()][7];
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            data[i][0] = p.getId();
            data[i][1] = p.getCodigo();
            data[i][2] = p.getDescripcion();
            data[i][3] = p.getMaterial();
            data[i][4] = p.getColor();
            data[i][5] = p.getPrecio();
            data[i][6] = p.getStock();
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(btnAgregar, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void agregarProducto() {
        // Código para agregar producto (ya implementado)
    }
}
