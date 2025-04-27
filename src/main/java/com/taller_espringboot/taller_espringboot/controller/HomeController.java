package com.taller_espringboot.taller_espringboot.controller;

import com.taller_espringboot.taller_espringboot.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ProductRepository productRepository;

    // Constructor para inyectar ProductRepository
    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Este método maneja la URL principal "/"
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("productos", productRepository.findAll()); 
        return "index"; // Carga el archivo index.html desde templates
    }
}



