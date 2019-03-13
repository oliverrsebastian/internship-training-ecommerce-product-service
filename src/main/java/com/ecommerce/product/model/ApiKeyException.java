package com.ecommerce.product.model;

public class ApiKeyException extends RuntimeException {
    public ApiKeyException() {
        super("Api-Key is missing");
    }
}
