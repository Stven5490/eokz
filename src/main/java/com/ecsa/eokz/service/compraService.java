package com.ecsa.eokz.service;

import com.ecsa.eokz.model.compraModel;
import com.ecsa.eokz.repository.compraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class compraService {
    @Autowired
    private compraRepository repoCompra;
    public List<compraModel> finAll(){
        return repoCompra.findAll();
    }
    public compraModel save(compraModel comprar){
        return repoCompra.save(comprar);
    }
    public void delete(Long id){
        repoCompra.deleteById(id);
    }
}
