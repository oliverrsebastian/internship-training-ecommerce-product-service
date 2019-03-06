package com.ecommerce.product;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.service.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductServiceImplTest {

    private ProductServiceImpl productService;

    @Before
    public void setUp() throws Exception {
        productService = new ProductServiceImpl();
    }

    @Test
    public void getProductByIdSuccess() {
        Product product = productService.getById("PRD1");
        Assert.assertNotNull(product);
        Assert.assertEquals("PRD1", product.getId());
    }

    @Test
    public void getProductByIdNotFoundFailed() {
        Product product = productService.getById("PRD10");
        Assert.assertNull(product);
    }

    @Test
    public void getProductByIdNullFailed() {
        Product product = productService.getById(null);
        Assert.assertNull(product);
    }

    @Test
    public void getProductByIdNotStartedWithPrefixFailed() {
        Product product = productService.getById("10");
        Assert.assertNull(product);
    }

    @Test
    public void getAllProductsSuccess() {
        Assert.assertNotNull(productService.getAll());
        Assert.assertEquals(5, productService.getAll().size());
    }

    @Test
    public void saveProductSuccess() {
        Product productWantedToSave = new Product("PRD1",
                "Product 12", Long.valueOf(10000), 3, "Product");
        Product product = productService.insertProduct(productWantedToSave);
        Assert.assertNotNull(product);
        Assert.assertEquals("PRD1", product.getId());
    }

    @Test
    public void saveProductNullFailed() {
        Product productWantedToSave = null;
        Product product = productService.insertProduct(productWantedToSave);
        Assert.assertNull(product);
    }

    @Test
    public void editProductSuccess() {
        Product product = productService.getById("PRD1");
        Product productEdited = new Product("PRD1", "Product 12", Long.valueOf(10000), 3, "Product");
        Assert.assertNotEquals(product, productEdited);
        product = productService.updateProduct(productEdited);
        Assert.assertEquals(product, productEdited);
    }

    @Test
    public void editProductNotFoundFailed() {
        Product product = productService.getById("PRD10");
        Assert.assertNull(product);
    }

    @Test
    public void editProductNullFailed() {
        Product product = productService.getById("PRD1");
        Product productEdited = null;
        Assert.assertNotEquals(product, productEdited);
        product = productService.updateProduct(productEdited);
        Assert.assertNull(product);
    }

    @Test
    public void deleteProductByIdSuccess() {
        Product product = productService.deleteById("PRD1");
        Assert.assertNotNull(product);
        Assert.assertEquals("PRD1", product.getId());
    }

    @Test
    public void deleteProductByIdNotFoundFailed() {
        Product product = productService.deleteById("PRD10");
        Assert.assertNull(product);
    }

    @Test
    public void deleteProductByIdNullFailed() {
        Product product = productService.deleteById(null);
        Assert.assertNull(product);
    }

    @Test
    public void deleteProductByIdNotStartedWithPrefixFailed() {
        Product product = productService.deleteById("10");
        Assert.assertNull(product);
    }
}
