package com.ecsa.eokz.service;

import com.ecsa.eokz.model.productoModel;
import com.ecsa.eokz.repository.productoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productoService {
    @Autowired
    private static productoRepository repoProducto;
    public List<productoModel> findAll(){
        return repoProducto.findAll();
    }
    public productoModel findById(Long id){
        return repoProducto.findById(id).orElse(null);
    }
    public static productoModel save(productoModel producto){
        return repoProducto.save(producto);
    }
    public static void delete(Long id){
        repoProducto.delete(id);
    }
}
