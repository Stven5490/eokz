package com.ecsa.eokz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:tienda_ropa.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection()) {
            // Crear tabla Productos
            String sqlProductos = "CREATE TABLE IF NOT EXISTS Productos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "codigo TEXT NOT NULL UNIQUE, " +
                    "descripcion TEXT NOT NULL, " +
                    "material TEXT NOT NULL, " +
                    "color TEXT NOT NULL, " +
                    "precio REAL NOT NULL, " +
                    "stock INTEGER NOT NULL)";
            conn.createStatement().execute(sqlProductos);

            // Crear tabla Ventas
            String sqlVentas = "CREATE TABLE IF NOT EXISTS Ventas (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "fecha TEXT NOT NULL, " +
                    "valor_total REAL NOT NULL, " +
                    "iva REAL NOT NULL, " +
                    "valor_recibido REAL NOT NULL)";
            conn.createStatement().execute(sqlVentas);

            // Crear tabla DetalleVenta
            String sqlDetalleVenta = "CREATE TABLE IF NOT EXISTS DetalleVenta (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "venta_id INTEGER NOT NULL, " +
                    "producto_id INTEGER NOT NULL, " +
                    "cantidad INTEGER NOT NULL, " +
                    "precio_unitario REAL NOT NULL, " +
                    "FOREIGN KEY (venta_id) REFERENCES Ventas(id), " +
                    "FOREIGN KEY (producto_id) REFERENCES Productos(id))";
            conn.createStatement().execute(sqlDetalleVenta);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
