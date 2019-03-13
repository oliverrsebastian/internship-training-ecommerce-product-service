package com.ecommerce.product;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(ProductRepositoryTest.class);

    @Autowired
    private ProductRepository productRepository;

    private Long id;

    @Before
    public void setUp() throws Exception {
        Product product = new Product();
        product.setName("Product 1");
        product.setPrice(10000L);
        product.setQty(2);
        product.setCategoryName("Category 1");
        product = productRepository.save(product);
        id = product.getId();

    }

    @Test
    public void testRepositoryInsertSuccess() {
        Product product = new Product();
        product.setName("Product 1");
        product.setPrice(10000L);
        product.setQty(2);
        product.setCategoryName("Category 1");
        product = productRepository.save(product);
        Assert.assertNotNull(product);
        Assert.assertNotNull(product.getId());
    }

    @Test
    public void testRepositoryGetByIdSuccess() {
        Optional<Product> product = productRepository.findById(id);
        Assert.assertTrue(product.isPresent());
        Assert.assertNotNull(product.get());
    }

    @Test
    public void testRepositoryGetAllSuccess() {
        List<Product> products = productRepository.findAll();
        Assert.assertEquals(1, products.size());
    }

    @Test
    public void testRepositoryEditSuccess() {
        Product product = new Product();
        product.setName("Product 30");
        product.setPrice(10000L);
        product.setQty(2);
        product.setCategoryName("Category 1");
        product.setId(id);

        Optional<Product> foundById = productRepository.findById(id);
        Assert.assertTrue(foundById.isPresent());
        Assert.assertNotEquals(product, foundById.get());
        product = productRepository.save(product);
        foundById = productRepository.findById(id);
        Assert.assertTrue(foundById.isPresent());
        Assert.assertEquals(product, foundById.get());
    }

    @Test
    public void testRepositoryDeleteByIdSuccess() {
        productRepository.deleteById(id);
        Optional<Product> optional = productRepository.findById(id);
        Assert.assertFalse(optional.isPresent());
    }

    @After
    public void tearDown() throws Exception {
        productRepository.deleteAll();
    }
}
