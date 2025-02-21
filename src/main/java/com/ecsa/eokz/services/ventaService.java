package com.ecsa.eokz.services;

import com.ecsa.eokz.dto.ventaDTO;
import com.ecsa.eokz.models.venta;
import com.ecsa.eokz.repositories.ventaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ventaService {
    @Autowired
    private ventaRepository ventaRepository;

    @Transactional
    public void guardar(ventaDTO ventaDTO){
        venta venta = new venta();
        venta.setFecha(ventaDTO.getFecha());
        venta.setValorTotal(ventaDTO.getValorTotal());
        venta.setIVA(ventaDTO.getIVA());
        venta.setValorRecibido(ventaDTO.getValorRecibido());
        ventaRepository.save(venta);
    }
}
