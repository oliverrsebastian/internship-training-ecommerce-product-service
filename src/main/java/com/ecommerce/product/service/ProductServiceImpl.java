package com.ecommerce.product.service;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getById(Long id) {
        if (id != null) {
            Optional<Product> optional = productRepository.findById(id);
            return optional.orElse(null);
        }
        return null;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
        //page.getTotalPages() -> dapet total page
        //page.getTotalElements() -> dapet total element
    }

    @Override
    public Product insertProduct(Product product) {
        if (product != null) {
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        if (product != null) {
            Product actual = this.getById(product.getId());
            if (actual != null)
                BeanUtils.copyProperties(product, actual);
            productRepository.save(actual);
            return product;
        }
        return null;
    }

    @Override
    public Product deleteById(Long id) {
        if (id != null) {
            Product product = this.getById(id);
            productRepository.delete(product);
            return product;
        }
        return null;
    }
}
