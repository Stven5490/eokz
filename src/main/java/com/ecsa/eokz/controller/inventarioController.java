package com.ecsa.eokz.controller;

import com.ecsa.eokz.model.inventarioModel;
import com.ecsa.eokz.repository.inventarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
public class inventarioController {
    @Autowired
    private inventarioRepository repoInventario;
    @GetMapping
    public List<inventarioModel> listarInventario(){
        return repoInventario.findAll();
    }
    @PostMapping
    public inventarioModel crearInventario(@RequestBody inventarioModel inventario){
        return repoInventario.save(inventario);
    }
}
