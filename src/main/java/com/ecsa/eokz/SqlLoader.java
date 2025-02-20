package com.ecsa.eokz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.*;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class SqlLoader {

    @Value("${sql.crear_tablas}")
    private String crearTablasPath;

    @Value("${sql.insertar_producto}")
    private String insertarProductoPath;

    @Value("${sql.actualizar_producto}")
    private String actualizarProductoPath;

    private String crearTablasSql;
    private String insertarProductoSql;
    private String actualizarProductoSql;

    private final ResourceLoader resourceLoader;

    public SqlLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void init() {
        this.crearTablasSql = loadSql(crearTablasPath);
        this.insertarProductoSql = loadSql(insertarProductoPath);
        this.actualizarProductoSql = loadSql(actualizarProductoPath);
    }

    private String loadSql(String path) {
        try {
            Resource resource = resourceLoader.getResource(path);
            return new String(Files.readAllBytes(Paths.get(resource.getURI())), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo SQL: " + path, e);
        }
    }

    public String getCrearTablasSql() {
        return crearTablasSql;
    }

    public String getInsertarProductoSql() {
        return insertarProductoSql;
    }

    public String getActualizarProductoSql() {
        return actualizarProductoSql;
    }
}