package com.ecsa.eokz.controllers;

import com.ecsa.eokz.dto.ventaDTO;
import com.ecsa.eokz.services.ventaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class ventaController {
    @Autowired
    private ventaService ventaService;

    @GetMapping
    public String listarVentas(Model model){
        model.addAttribute("ventas", ventaService.obtenerTodos());
        return "ventas";
    }

    @PostMapping("/guardar")
    public String guardarVenta(@ModelAttribute ventaDTO ventaDTO){
        ventaService.guardar(ventaDTO);
        return "redirect:/ventas";
    }
}
