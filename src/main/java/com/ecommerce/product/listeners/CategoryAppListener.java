package com.ecommerce.product.listeners;

import com.ecommerce.product.model.Category;
import com.ecommerce.product.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CategoryAppListener {

    private ObjectMapper objectMapper;

    private CategoryService categoryService;

    @Autowired
    public CategoryAppListener(ObjectMapper objectMapper, CategoryService categoryService) {
        this.objectMapper = objectMapper;
        this.categoryService = categoryService;
    }

    @KafkaListener(topics = "categories")
    public void getTopicCategoryList(String body) throws IOException {
        Category category = objectMapper.readValue(body, Category.class);
        categoryService.addCategoryList(category);
    }

//    @KafkaListener(topics = "categoryAction")
//    public getTopicCategoryAction(String body) throws IOException {
//        String action = objectMapper.readValue(body, String.class);
//        if(action.)
//    }

}
