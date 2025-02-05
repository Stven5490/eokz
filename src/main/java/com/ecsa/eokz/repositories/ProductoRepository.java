package com.ecsa.eokz.repositories;

import com.ecsa.eokz.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
