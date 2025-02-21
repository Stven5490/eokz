package com.ecsa.eokz.utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class databaseInitializer {
    @Value("classpath:sql/createTableProductos.sql")
    private Resource createTableProductosScript;

    @Value("classpath:sql/createTableVentas.sql")
    private Resource createTableVentasScript;

    private final JdbcTemplate jdbcTemplate;
    private final ResourceLoader resourceLoader;

    public databaseInitializer(JdbcTemplate jdbcTemplate, ResourceLoader resourceLoader){
        this.jdbcTemplate = jdbcTemplate;
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void init(){
        try{
            String sqlProductos = loadSql(createTableProductosScript);
            jdbcTemplate.execute(sqlProductos);
            System.out.println("Tabla de productos creada correctamente");

            String sqlVentas = loadSql(createTableVentasScript);
            jdbcTemplate.execute(sqlVentas);
            System.out.println("Tabla de ventas creada correctamente");
        } catch (IOException io){
            System.err.println("Error al cargar los script SQL: " + io.getMessage());
        }
    }

    private String loadSql(Resource resource) throws IOException{
        return new String (Files.readAllBytes(Paths.get(resource.getURI())), StandardCharsets.UTF_8);
    }
}
