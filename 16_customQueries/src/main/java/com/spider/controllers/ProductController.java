package com.spider.controllers;

import com.spider.CustomExceptions.NoProductException;
import com.spider.entities.Product;
import com.spider.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/fetchById")
    public Product fetchById(@RequestParam Integer id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = optional.orElseThrow(() -> new RuntimeException("Product not found..."));
        return product;
    }

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        Product prod = productRepository.save(product);
        return prod;
    }

//    *************************************************************************************
    //    Need of @Query() -> There are no any methods to use queries with custom data
//    using @Query()
    @GetMapping("/fetchByCategory")
    public List<Product> fetchByCategory(@RequestParam String category) {
        List<Product> byCategory = productRepository.findByCat(category);
        return byCategory;
    }

    @GetMapping("/fetchByPrice")
    public Product fetchByPrice(@RequestParam Integer price) {
        Product prod = productRepository.findByPri(price);
        return prod;
    }
    @GetMapping
    public String home() {
        return "This is home page";
    }



//    ***********************************************************************************************
    //    We can write our custom queries without @Query() also by following some sandards
    @GetMapping("/findByPid")
    public Product findByBrand(Integer id) {
        Product byBrand = productRepository.findById(id).orElseThrow(() -> new NoProductException("Product not found..."));
        return byBrand;
    }
    @GetMapping("/findByBrand")
    public List<Product> findByBrand(String brand) {
        List<Product> byBrand = productRepository.findByBrand(brand);
        return byBrand;
    }

    @GetMapping("/findByBrandIgnoreCase")
    public List<Product> findByBrandIgnoreCase(String brand) {
        List<Product> byBrand = productRepository.findByBrandIgnoreCase(brand);
        return byBrand;
    }

    @GetMapping("/findByBrandAndCategory")
    public List<Product> findByBrandAndCategory(String brand, String category){
        List<Product> products =  productRepository.findByBrandAndCategory(brand, category);
        return products;
    }

    @GetMapping("/findByPriceGreaterThan")
    public List<Product> findByPriceGreaterThan(Integer price) {
        List<Product> products =  productRepository.findByPriceGreaterThan(price);
        return products;
    }

    @GetMapping("/findByBrandStartingWith")
    public List<Product> findByBrandStartingWith(String prefix)  {
        List<Product> products =  productRepository.findByBrandStartingWith(prefix);
        return products;
    }


}
