package com.ecsa.eokz.service;

import com.ecsa.eokz.model.inventarioModel;

import com.ecsa.eokz.repository.inventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class invetarioService {
    @Autowired
    private inventarioRepository repoInventario;
    public List<inventarioModel> findAll(){
        return repoInventario.findAll();
    }

    public inventarioModel save (inventarioModel inventario){
        return repoInventario.save(inventario);
    }
    public void delete(Long id){
        repoInventario.deleteById(id);
    }
}
