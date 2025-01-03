package com.ecsa.eokz.service;

import com.ecsa.eokz.model.compraModel;
import com.ecsa.eokz.repository.compraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class compraService extends abstractCrudService<compraModel, Integer> {
    @Autowired
    private compraRepository repoCompra;
    @Override
    protected JpaRepository<compraModel, Integer> getRepository(){
        return repoCompra;
    }
}
