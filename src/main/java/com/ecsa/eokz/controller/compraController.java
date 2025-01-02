package com.ecsa.eokz.controller;

import com.ecsa.eokz.model.compraModel;
import com.ecsa.eokz.repository.compraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compras")
public class compraController {
    @Autowired
    private compraRepository repoCompra;
    @GetMapping
    public List<compraModel> getCompras(){
        return repoCompra.findAll();
    }
    @PostMapping
    public compraModel crearCompra(@RequestBody compraModel comprar){
        return repoCompra.save(comprar);
    }
}
