package com.spider.__Crud.controllers;

import com.spider.__Crud.entities.Product;
import com.spider.__Crud.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductRepo productRepo;

    //    Getting a product usign product id
    @GetMapping("/fetchById")
    public Product fetch(@RequestParam int id) {
        //Optinal is a class introduced in java 8 used to avoid null pointe check logic
        Optional<Product> byId = productRepo.findById(id);
        Product product = byId.get();
        return product;
    }

    @GetMapping("/fetchall")
    public List<Product> fetchall() {
        List<Product> products = productRepo.findAll();
        return products;
    }

//    Saving a product into the database
    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        Product savedProduct = productRepo.save(product);
        return savedProduct;
    }

//    updating a product
    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable(name = "id") int productId, @RequestBody Product product) {
        Optional<Product> opt = productRepo.findById(productId);
        Product prod = opt.get();
        prod.setBrand(product.getBrand());
        prod.setDescription(product.getDescription());
        prod.setPrice(product.getPrice());
        prod.setQuantity(product.getQuantity());
        prod.setCategory(product.getCategory());
        productRepo.save(prod);
        return prod;
    }

//    Deleting a product
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int productId) {
        Optional<Product> opt = productRepo.findById(productId);
        Product product = opt.get();
        productRepo.delete(product);
        return "product deleted";
    }
}