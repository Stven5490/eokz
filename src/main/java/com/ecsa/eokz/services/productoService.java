package com.ecsa.eokz.services;

import com.ecsa.eokz.dto.productoDTO;
import com.ecsa.eokz.models.producto;
import com.ecsa.eokz.repositories.productoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class productoService {
    @Autowired
    private productoRepository productoRepository;

    @Transactional
    public void guardar(productoDTO productoDTO){
        producto producto = new producto();
        producto.setCodigo(productoDTO.getCodigo());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setMaterial(productoDTO.getMaterial());
        producto.setColor(productoDTO.getColor());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        productoRepository.save(producto);
    }

    public List<producto> obtenerTodos(){
        return productoRepository.findAll();
    }
}
