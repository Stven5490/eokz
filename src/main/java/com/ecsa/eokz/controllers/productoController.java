package com.ecsa.eokz.controllers;

import com.ecsa.eokz.dto.productoDTO;
import com.ecsa.eokz.services.productoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class productoController {
    private final productoService productoService;

    @Autowired
    public productoController (productoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    public String listarProductos(Model model){
        model.addAttribute("productos", productoService.obtenerTodos());
        return "productos";
    }

    @PostMapping("/guardar")
    public String guardarProductos(@ModelAttribute productoDTO productoDTO){
        productoService.guardar(productoDTO);
        return "redirect:/productos";
    }
}
