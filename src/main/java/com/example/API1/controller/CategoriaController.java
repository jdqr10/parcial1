package com.example.API1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API1.dto.CategoryDto;
import com.example.API1.services.CategoriaService;

@RestController
@RequestMapping("/api/categories")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    /**
     * Simple test endpoint to verify the API is working.
     * 
     * @return A greeting message.
     */
    @GetMapping
    public String hola_categoria() {
        return "Hola categoria";
    }

    /**
     * Retrieves all categories.
     * 
     * @return A list of CategoryDto objects.
     */
    @GetMapping("/getCategories")
    public List<CategoryDto> getAllCategories() {
        return categoriaService.findAll();
    }

    /**
     * Saves a new category.
     * 
     * @param request The CategoryDto containing the category data.
     * @return The saved category as a DTO.
     */
    @PostMapping("/saveCategory")
    public CategoryDto saveCategoryDto(@RequestBody CategoryDto request) {
        return categoriaService.saveCategory(request);
    }

    /**
     * Deletes a category by its ID.
     * 
     * @param id The ID of the category to be deleted.
     * @return A message indicating whether the deletion was successful.
     */
    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id) {
        return categoriaService.deleteCategory(id);
    }
}
