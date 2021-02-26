
package com.example.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.exception.ProductNotFoundException;
import com.example.repo.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductRepository prodRepo;

    //get all products
    @GetMapping
    public List<Product> getAllProducts() {

        log.info("fetching all product list");
        return (List<Product>) this.prodRepo.findAll(Sort.by("productId").ascending());
    }

    //get product by productId
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id")
    BigInteger productId) {

        log.info("fetching the product details of productId: " + productId);
        return this.prodRepo.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("Something went wrong...Unable to fetch the product details"));
    }

    //create product
    @PostMapping
    public Product addProduct(@RequestBody
    Product product) {

        return this.prodRepo.save(product);
    }

    //update product
    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody
    Product product, @PathVariable("id")
    BigInteger productId) {

        Product exist = this.prodRepo.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("The product is not available, please check and try again"));
        exist.setProductName(product.getProductName());
        exist.setProductPrice(product.getProductPrice());
        return this.prodRepo.save(exist);
    }

    //delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id")
    BigInteger productId) {

        Product exist = this.prodRepo.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("The product is not available, please check and try again"));
        this.prodRepo.delete(exist);
        log.info("product " + productId + " deleted successfully");
        return ResponseEntity.ok().build();
    }

}
