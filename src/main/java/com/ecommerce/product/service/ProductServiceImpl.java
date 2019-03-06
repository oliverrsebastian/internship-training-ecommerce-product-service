package com.ecommerce.product.service;

import com.ecommerce.product.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    List<Product> products;

    public ProductServiceImpl() {
        products = setData();
    }

    private ArrayList setData() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("PRD1", "Product 1", Long.valueOf(100000), 3, "Product"));
        products.add(new Product("PRD2", "Product 2", Long.valueOf(120000), 6, "Product"));
        products.add(new Product("PRD3", "Product 3", Long.valueOf(140000), 9, "Product"));
        products.add(new Product("PRD4", "Product 4", Long.valueOf(160000), 12, "Product"));
        products.add(new Product("PRD5", "Product 5", Long.valueOf(180000), 15, "Product"));
        return products;
    }

    @Override
    public Product getById(String id) {
        if (id != null && id.startsWith("PRD"))
            for (Product product : products)
                if (product.getId().equals(id))
                    return product;
        return null;
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product insertProduct(Product product) {
        if (product != null) {
            products.add(product);
            return product;
        }
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        if (product != null) {
            Product actual = this.getById(product.getId());
            if (actual != null)
                BeanUtils.copyProperties(product, actual);
            products.add(actual);
            return product;
        }
        return null;
    }

    @Override
    public Product deleteById(String id) {
        if (id != null && id.startsWith("PRD"))
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    products.remove(product);
                    return product;
                }
            }
        return null;
    }
}
