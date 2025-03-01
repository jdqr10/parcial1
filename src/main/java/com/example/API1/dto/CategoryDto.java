package com.example.API1.dto;

import com.example.API1.models.Categoria;

public class CategoryDto {
    private Long id;
    private String nombre;

    /**
     * Default constructor required for deserialization.
     */
    public CategoryDto() {
    }

    /**
     * Constructor to convert a Categoria entity into a DTO.
     * 
     * @param categoria The entity containing category data.
     */
    public CategoryDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nombre = categoria.getNombre();
    }

    // Getters and setters

    /**
     * Gets the category ID.
     * 
     * @return The category ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the category ID.
     * 
     * @param id The category ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the category name.
     * 
     * @return The category name.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the category name.
     * 
     * @param nombre The category name to set.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
