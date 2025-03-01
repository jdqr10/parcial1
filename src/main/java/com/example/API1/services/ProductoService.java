package com.example.API1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.API1.models.Producto; 
import com.example.API1.dto.ProductDto;


import com.example.API1.repository.ProductsRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductsRepository productsRepository;

    public List<ProductDto> findAll(){
        List<ProductDto> productToReturn = new ArrayList<>();
        List<Producto> productos = productsRepository.findAll();
        for(Producto producto : productos){
            ProductDto productDtoGetPostPut = new ProductDto(producto);
           // productDtoGetPostPut.convertToProductDTO(producto);
            productToReturn.add(productDtoGetPostPut);
        }
        return productToReturn;
    }

    //Post ---> Insert

    // Delete ---> Eliminiar
}
