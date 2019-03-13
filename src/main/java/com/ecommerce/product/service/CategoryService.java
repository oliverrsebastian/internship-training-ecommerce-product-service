package com.ecommerce.product.service;

import com.ecommerce.product.model.Category;

import java.util.List;

public interface CategoryService {
    Category addCategoryList(Category category);

    List<Category> resetCategoryList();
}
