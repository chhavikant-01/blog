package com.nova.blog.services;

import java.util.List;

import com.nova.blog.domain.entities.Category;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
}
