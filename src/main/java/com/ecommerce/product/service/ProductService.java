package com.ecommerce.product.service;

import com.ecommerce.product.model.Product;

import java.util.List;

public interface ProductService {
    Product getById(String id);

    List<Product> getAll();

    Product insertProduct(Product product);

    Product updateProduct(Product product);

    Product deleteById(String id);
}