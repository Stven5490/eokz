package com.ecsa.eokz.controller;


import com.ecsa.eokz.model.ventaModel;
import com.ecsa.eokz.repository.ventaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class ventaController {
    @Autowired
    private ventaRepository repoVenta;
    @GetMapping
    public List<ventaModel> listarVentas(){
        return repoVenta.findAll();
    }
    @PostMapping
    public ventaModel crearVenta(@RequestBody ventaModel venta){
        return repoVenta.save(venta);
    }
}
