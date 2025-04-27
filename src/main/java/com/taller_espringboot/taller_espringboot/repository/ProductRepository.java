package com.taller_espringboot.taller_espringboot.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.taller_espringboot.taller_espringboot.model.Product;

import jakarta.annotation.PostConstruct;
@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @PostConstruct  // aca con este método corre justo al iniciar la app
    public void init() {
        products.add(new Product(1L, "equipo", "Periféricos", 200.000, 20));
        products.add(new Product(2L, "cama", "Periféricos", 50.000, 15));
        products.add(new Product(3L, "sofa", "Periféricos", 100.000, 30));
        products.add(new Product(4L, "televisor", "Electrodomesticos", 500.000, 10));
        products.add(new Product(5L, "nevera", "Electrodomesticos", 300.000, 5));
        products.add(new Product(6L, "lavadora", "Electrodomesticos", 400.000, 8));
        products.add(new Product(7L, "microondas", "Electrodomesticos", 150.000, 12));
        products.add(new Product(8L, "horno", "Electrodomesticos", 250.000, 7));        
        products.add(new Product(9L, "ventilador", "Electrodomesticos", 80.000, 20));
        products.add(new Product(10L, "calefactor", "Electrodomesticos", 120.000, 15));         
        products.add(new Product(11L, "aire acondicionado", "Electrodomesticos", 600.000, 3));      
        products.add(new Product(12L, "aspiradora", "Electrodomesticos", 200.000, 10));
        products.add(new Product(13L, "licuadora", "Electrodomesticos", 100.000, 25));
        products.add(new Product(14L, "batidora", "Electrodomesticos", 80.000, 30));
        products.add(new Product(15L, "tostadora", "Electrodomesticos", 50.000, 40));
        products.add(new Product(16L, "cafetera", "Electrodomesticos", 70.000, 35));
        products.add(new Product(17L, "plancha", "Electrodomesticos", 40.000, 50));     
        products.add(new Product(18L, "secador de pelo", "Electrodomesticos", 30.000, 60));


        
    }
    

    // aqi nos devuelve todos los productos que tenemos
    public List<Product> findAll() {
        return products;
    }


}
