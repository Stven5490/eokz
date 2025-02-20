package com.ecsa.eokz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SqlLoader sqlLoader;

    public void crearTablas() {
        jdbcTemplate.execute(sqlLoader.getCrearTablasSql());
    }

    public void insertarProducto(String codigo, String descripcion, String material, String color, double precio, int stock) {
        String sql = sqlLoader.getInsertarProductoSql();
        jdbcTemplate.update(sql, codigo, descripcion, material, color, precio, stock);
    }

    public void actualizarProducto(String codigo, String descripcion, String material, String color, double precio, int stock) {
        String sql = sqlLoader.getActualizarProductoSql();
        jdbcTemplate.update(sql, descripcion, material, color, precio, stock, codigo);
    }
}