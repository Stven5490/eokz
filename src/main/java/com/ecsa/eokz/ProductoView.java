package com.ecsa.eokz;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ProductoView extends JFrame {
    private ProductoController controller;

    public ProductoView() {
        controller = new ProductoController();
        initializeUI();
    }



    private void initializeUI() {
        setTitle("Gestión de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Botón para agregar producto
        JButton btnAgregar = new JButton("Agregar Producto");
        btnAgregar.addActionListener(e -> agregarProducto());

        // En ProductoView.java
        JButton btnVentas = new JButton("Registrar Venta");
        btnVentas.addActionListener(e -> new VentaView().getPanel().setVisible(true));
        //btnVentas.addActionListener(e -> new VentaView().setVisible(true));
        panel.add(btnVentas, BorderLayout.SOUTH);

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

        add(panel);
    }

    private void agregarProducto() {
        JTextField codigoField = new JTextField();
        JTextField descripcionField = new JTextField();
        JTextField materialField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField precioField = new JTextField();
        JTextField stockField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(6, 2));
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

        int result = JOptionPane.showConfirmDialog(null, panel, "Agregar Producto", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
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
        }
    }
}
