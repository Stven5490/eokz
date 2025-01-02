package com.ecsa.eokz.repository;

import com.ecsa.eokz.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface productoRepository extends JpaRepository<productoModel, Long>{
    void delete(Long id);
}
