package com.ecsa.eokz.controllers;

import com.ecsa.eokz.models.Producto;
import com.ecsa.eokz.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @GetMapping
    public String listarProductos(Model model){
        model.addAttribute("productos", productoService.obtenerTodos());
        return "productos";
    }
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("producto", new Producto());
        return "formulario";
    }
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto){
        productoService.guardar(producto);
        return "redirect:/productos";
    }
}
