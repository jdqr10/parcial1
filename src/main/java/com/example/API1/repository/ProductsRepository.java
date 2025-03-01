package com.example.API1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.API1.models.Producto;  // Asegúrate de importar la entidad correcta

@Repository
public interface ProductsRepository extends JpaRepository<Producto, Long> {
}
