package com.ecsa.eokz.repository;

import com.ecsa.eokz.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ventaRepository extends JpaRepository<ventaModel, Long>{
    void delete(Long id);
}
