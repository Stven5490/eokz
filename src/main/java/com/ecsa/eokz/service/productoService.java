package com.ecsa.eokz.service;

import com.ecsa.eokz.model.productoModel;
import com.ecsa.eokz.repository.productoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class productoService extends abstractCrudService<productoModel, Integer>{
    @Autowired
    private productoRepository repoProducto;
    @Override
    protected JpaRepository<productoModel, Integer> getRepository(){
        return repoProducto;
    }
}
