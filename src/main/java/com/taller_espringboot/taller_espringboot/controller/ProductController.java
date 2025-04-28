package com.taller_espringboot.taller_espringboot.controller;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taller_espringboot.taller_espringboot.model.Product;
import com.taller_espringboot.taller_espringboot.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // 1) Listar productos con filtros y paginación
    @GetMapping("/products")
    public List<Product> getProducts(
        @RequestParam(required = false) Double minPrice,
        @RequestParam(required = false) Double maxPrice,
        @RequestParam(required = false) String category,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return repo.findAll().stream()
            .filter(p -> minPrice == null || p.getPrice() >= minPrice)
            .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
            .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
            .skip((long) page * size)
            .limit(size)
            .collect(Collectors.toList());
    }

    // 2) Estadísticas de precios
    @GetMapping("/products/stats")
    public Map<String, Double> getStats(
        @RequestParam(required = false) String category
    ) {
        DoubleSummaryStatistics stats = repo.findAll().stream()
            .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
            .mapToDouble(Product::getPrice)
            .summaryStatistics();

        return Map.of(
            "count", (double) stats.getCount(),
            "avgPrice", stats.getAverage(),
            "minPrice", stats.getMin(),
            "maxPrice", stats.getMax(),
            "totalValue", stats.getSum()
        );
    }
}