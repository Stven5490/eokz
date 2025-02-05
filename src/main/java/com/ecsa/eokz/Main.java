package com.ecsa.eokz;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Inicializar la base de datos
        DatabaseConnection.initializeDatabase();

        // Mostrar la interfaz gráfica
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tienda de Ropa");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            // Crear un JTabbedPane para organizar las pestañas
            JTabbedPane tabbedPane = new JTabbedPane();

            // Pestaña de Inventario
            tabbedPane.addTab("Inventario", new InventarioView().getPanel());

            // Pestaña de Ventas
            tabbedPane.addTab("Ventas", new VentaView().getPanel());

            // Pestaña de Ingreso de Mercadería
            tabbedPane.addTab("Ingreso de Mercadería", new IngresoMercaderiaView().getPanel());

            frame.add(tabbedPane);
            frame.setVisible(true);
        });
    }
}