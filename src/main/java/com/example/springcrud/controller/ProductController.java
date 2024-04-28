package com.example.springcrud.controller;

import com.example.springcrud.model.Product;
import com.example.springcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping("/products")
//    public ResponseEntity<List<Product>> getAllProducts(){
//        List<Product> allProducts = productService.getProducts();
//        return new ResponseEntity<>(allProducts, HttpStatus.OK);
//    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<Product> getProduct(@RequestParam(name="productId") long productId){
        Product product = productService.getProduct(productId);
        return  new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

}
