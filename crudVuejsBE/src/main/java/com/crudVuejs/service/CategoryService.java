package com.crudVuejs.service;

import com.crudVuejs.model.Category;
import com.crudVuejs.model.Product;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findbyId(Long productId);
    void deleteById(Long id);
    Category insert(Category category);
    Category update(Category category);
}
