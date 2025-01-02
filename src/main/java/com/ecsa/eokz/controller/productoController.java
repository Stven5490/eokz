package com.ecsa.eokz.controller;

import com.ecsa.eokz.service.productoService;
import com.ecsa.eokz.model.productoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class productoController {
    @Autowired
    private productoService servicioProducto;
    @GetMapping
    public List<productoModel> getAllProducts(){
        return servicioProducto.findAll();
    }
    @PostMapping
    public productoModel crearProducto(@RequestBody productoModel producto){
        return productoService.save(producto);
    }
    @PutMapping("/{id}")
    public productoModel actualizarProducto(@PathVariable Long id, @RequestBody productoModel producto){
        producto.setId(id);
        return productoService.save(producto);
    }
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id){
        productoService.delete(id);
    }
}
