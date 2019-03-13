package com.ecommerce.product.controller;

import com.ecommerce.product.model.ApiKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ApiKeyException.class)
    public String apiKey(ApiKeyException exception) {
        return "Sorry, Unauthorized!";
    }
}
