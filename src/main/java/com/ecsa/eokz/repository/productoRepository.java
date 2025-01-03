package com.ecsa.eokz.repository;

import com.ecsa.eokz.model.productoModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface productoRepository extends JpaRepository<productoModel, Integer>{
    void delete(Long id);
}
