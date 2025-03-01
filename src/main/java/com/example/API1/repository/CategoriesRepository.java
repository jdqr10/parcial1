package com.example.API1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.API1.models.Categoria;  // Asegúrate de importar la entidad correcta

@Repository
public interface CategoriesRepository extends JpaRepository<Categoria, Long> {
}
