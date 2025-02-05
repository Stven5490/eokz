package com.ecsa.eokz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    public void agregarProducto(Producto producto) {
        String sql = "INSERT INTO Productos (codigo, descripcion, material, color, precio, stock) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getCodigo());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setString(3, producto.getMaterial());
            pstmt.setString(4, producto.getColor());
            pstmt.setDouble(5, producto.getPrecio());
            pstmt.setInt(6, producto.getStock());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> obtenerProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Productos";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getString("codigo"),
                        rs.getString("descripcion"),
                        rs.getString("material"),
                        rs.getString("color"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
                producto.setId(rs.getInt("id"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
