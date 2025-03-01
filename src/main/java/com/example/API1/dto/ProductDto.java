package com.example.API1.dto; // 📌 Ubicación en el paquete correcto

import com.example.API1.models.Producto;

public class ProductDto {
    private Long id;
    private String nombre;
    private Long categoriaId; // Solo el ID de la categoría

    public ProductDto(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.categoriaId = (producto.getCategoria() != null) ? producto.getCategoria().getId() : null;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
