package com.taller_espringboot.taller_espringboot.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taller_espringboot.taller_espringboot.model.Product;
import com.taller_espringboot.taller_espringboot.repository.ProductRepository;

@Controller
public class HomeController {

    private final ProductRepository repo;

    public HomeController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String index(
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) String category,
        Model model
    ) {
        List<Product> productosFiltrados = repo.findAll().stream()
            .filter(p -> minPrice == null || p.getPrice() >= minPrice)
            .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
            .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
            .collect(Collectors.toList());

        Set<String> categorias = repo.findAll().stream()
            .map(Product::getCategory)
            .collect(Collectors.toSet());

        model.addAttribute("productos", productosFiltrados);
        model.addAttribute("categories", categorias);
        return "index";
    }
}
