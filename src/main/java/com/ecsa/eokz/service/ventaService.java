package com.ecsa.eokz.service;

import com.ecsa.eokz.model.ventaModel;
import com.ecsa.eokz.repository.ventaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ventaService {
    @Autowired
    private ventaRepository repoVenta;
    public List<ventaModel> findAll(){
        return repoVenta.findAll();
    }
    public ventaModel findById(Long id){
        return repoVenta.findById(id).orElse(null);
    }
    public ventaModel save (ventaModel venta){
        return repoVenta.save(venta);
    }
    public void delete (Long id){
        repoVenta.delete(id);
    }
}
