package com.example.springcrud.service;

import com.example.springcrud.model.Product;
import com.example.springcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public Product getProduct(long productId){
        return productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product updateProduct(long productId, Product product) {
        Product existingProduct = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setColor(product.getColor());
        existingProduct.setPrice(product.getPrice());
        productRepo.save(existingProduct);
        return existingProduct;
    }

    public Product deleteproduct(long productId) {
        Product existingProduct = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
        productRepo.deleteById(productId);
        return existingProduct;
    }

}
