package com.ecommerce.product;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import com.ecommerce.product.service.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    private ProductServiceImpl productService;

    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        productRepository = mock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    public void getProductByIdSuccess() {
        mockRepositoryGetByIdFound(1L, true);
        Product product = productService.getById(1L);
        Assert.assertNotNull(product);
        Assert.assertNotNull(product.getId());
        Assert.assertEquals(1l, (long) product.getId());
    }

    private Product mockRepositoryGetByIdFound(Long id, boolean found) {
        Product product = new Product();
        product.setId(id);
        when(productRepository.findById(id))
                .thenReturn(found ? Optional.of(product) : Optional.empty());
        return product;
    }

    @Test
    public void getProductByIdNotFoundFailed() {
        mockRepositoryGetByIdFound(10L, false);
        Assert.assertNull(productService.getById(10L));
    }

    @Test
    public void getProductByIdNullFailed() {
        Product product = productService.getById(null);
        Assert.assertNull(product);
    }

    @Test
    public void getAllProductsSuccess() {
        Assert.assertNotNull(productService.getAll());
        Assert.assertEquals(0, productService.getAll().size());
    }

    @Test
    public void saveProductSuccess() {
        Product productWantedToSave = new Product();
        productWantedToSave.setName("Product 1");
        productWantedToSave.setPrice(10000L);
        productWantedToSave.setQty(2);
        productWantedToSave.setCategoryName("Category 1");
        Product product = productService.insertProduct(productWantedToSave);
        Assert.assertNotNull(product);
        Assert.assertNotNull(product.getId());
    }

    @Test
    public void saveProductNullFailed() {
        Product productWantedToSave = null;
        Product product = productService.insertProduct(productWantedToSave);
        Assert.assertNull(product);
    }

    @Test
    public void editProductSuccess() {
        Product product = productService.getById(1L);
        Product productEdited = new Product();
        productEdited.setId(1L);
        productEdited.setName("Product 1");
        productEdited.setPrice(10000L);
        productEdited.setQty(2);
        productEdited.setCategoryName("Category 1");
        Assert.assertNotEquals(product, productEdited);
        product = productService.updateProduct(productEdited);
        Assert.assertEquals(product, productEdited);
    }

    @Test
    public void editProductNotFoundFailed() {
        Product product = productService.getById(5L);
        Assert.assertNull(product);
    }

    @Test
    public void editProductNullFailed() {
        Product product = productService.getById(1L);
        Product productEdited = null;
        Assert.assertNotEquals(product, productEdited);
        product = productService.updateProduct(productEdited);
        Assert.assertNull(product);
    }

    @Test
    public void deleteProductByIdSuccess() {
        Product product = productService.deleteById(1L);
        Assert.assertNotNull(product);
        Assert.assertNotNull(product.getId());
    }

    @Test
    public void deleteProductByIdNotFoundFailed() {
        Product product = productService.deleteById(10L);
        Assert.assertNull(product);
    }

    @Test
    public void deleteProductByIdNullFailed() {
        Product product = productService.deleteById(null);
        Assert.assertNull(product);
    }
}
