package com.ecommerce.product.service;

import com.ecommerce.product.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private List<Category> categories;

    public CategoryServiceImpl() {
        categories = new ArrayList<>();
    }

    @Override
    public Category addCategoryList(Category category) {
        categories.add(category);
        return category;
    }

    @Override
    public List<Category> resetCategoryList() {
        categories = new ArrayList<>();
        return categories;
    }
}
