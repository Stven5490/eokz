package com.ecsa.eokz.service;

import  com.ecsa.eokz.model.ventaModel;
import com.ecsa.eokz.repository.ventaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ventaService extends abstractCrudService<ventaModel, Integer>{
    @Autowired
    private ventaRepository repoVenta;
    @Override
    protected JpaRepository<ventaModel, Integer> getRepository(){
        return repoVenta;
    }
}
