package com.crudVuejs.service.serviceImpl;

import com.crudVuejs.exception.ResourceNotFoundException;
import com.crudVuejs.model.Category;
import com.crudVuejs.model.Product;
import com.crudVuejs.repository.CategoryRepository;
import com.crudVuejs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl  implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        List<Category> list1=new ArrayList<>();
        list1=categoryRepository.findAll();
        return list1;
    }

    @Override
    public Category findbyId(Long productId) {
        Optional<Category> productfind=categoryRepository.findById(productId);
        if (!productfind.isPresent()){
            throw new ResourceNotFoundException("not found category ");
        }
        return productfind.get();
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category insert(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category category1=categoryRepository.findById(category.getCategoryId()).get();
        if (category.getCategoryName() != null) {
            category1.setCategoryName(category.getCategoryName());
        }
        return categoryRepository.save(category1);
    }
}
