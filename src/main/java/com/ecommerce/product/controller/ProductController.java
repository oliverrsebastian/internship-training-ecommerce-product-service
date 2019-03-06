package com.ecommerce.product.controller;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping(path = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProductById(@PathVariable("productId") String id) {
        return productService.getById(id);
    }

    @PostMapping(path = "/products/_insert", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @PutMapping(path = "/products/_edit", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product editProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping(path = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product deleteProduct(@PathVariable("productId") String id) {
        return productService.deleteById(id);
    }

}
