package com.example.API1.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.API1.dto.ProductDto;
import com.example.API1.services.ProductoService;


@RestController
@RequestMapping("/api/products")
public class ProductoController {
    @GetMapping
    public String hola_mundo(){
        return "Hola mundo";
    }

    @GetMapping("/holamundo/{name}")
    public String hola_mundo_2(@PathVariable String name){
        return "Hola mundo desde otro path " + name;
    }

    @GetMapping("/holamundo/{name}/{lastname}/{age}")
    public String hola_mundo_2(@PathVariable String name, @PathVariable String lastname, @PathVariable int age){
        return "Hola mundo desde otro path " + name + lastname + age;
    }

    @GetMapping("/holamundo")
    public String hola_mumndo_3(@RequestParam String name){
        return "Hola mundo " + name + "";
    }

    @Autowired
    private ProductoService productoService; // ✅ Inyección de dependencia

    @GetMapping("/getProducts")
    public List<ProductDto> getAllProductos() {
        return productoService.findAll(); // ✅ Llamar al método correctamente
    }
}
