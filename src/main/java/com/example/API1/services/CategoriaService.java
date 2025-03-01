package com.example.API1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API1.dto.CategoryDto;
import com.example.API1.models.Categoria;
import com.example.API1.repository.CategoriesRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    /**
     * Retrieves all categories from the database and converts them into DTOs.
     * 
     * @return List of CategoryDto objects.
     */
    public List<CategoryDto> findAll() {
        List<CategoryDto> categoryToReturn = new ArrayList<>();
        List<Categoria> categorias = categoriesRepository.findAll();

        // Convert each Categoria entity to a CategoryDto
        for (Categoria categoria : categorias) {
            CategoryDto categoryDtoGetPostPut = new CategoryDto(categoria);
            categoryToReturn.add(categoryDtoGetPostPut);
        }

        return categoryToReturn;
    }

    /**
     * Saves a new category to the database.
     * 
     * @param request The DTO containing the category data.
     * @return The saved category as a DTO.
     */
    public CategoryDto saveCategory(CategoryDto request) {
        /*
         * Example of the expected JSON request in Postman:
         * {
         * "nombre": "Aseo"
         * }
         */

        // Convert DTO to entity
        Categoria categoria = new Categoria();
        categoria.setNombre(request.getNombre()); // Set category name from DTO

        // Save entity to the database
        Categoria savedCategoria = categoriesRepository.save(categoria);

        // Convert saved entity back to DTO and return it
        return new CategoryDto(savedCategoria);
    }

    /**
     * Deletes a category by its ID.
     * 
     * @param id The ID of the category to be deleted.
     * @return A message indicating success or failure.
     */
    public String deleteCategory(Long id) {
        if (categoriesRepository.existsById(id)) {
            categoriesRepository.deleteById(id);
            return "Category successfully deleted.";
        } else {
            return "Category not found.";
        }
    }
}
