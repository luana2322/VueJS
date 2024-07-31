package com.crudVuejs.service.serviceImpl;

import com.crudVuejs.exception.ResourceNotFoundException;
import com.crudVuejs.model.Category;
import com.crudVuejs.model.Product;
import com.crudVuejs.repository.CategoryRepository;
import com.crudVuejs.repository.ProductRepository;
import com.crudVuejs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Product> findAll() {
        List<Product> list1=new ArrayList<>();
list1=productRepository.findAll();
        return list1;
    }

    @Override
    public Product findbyId(Long productId) {
        Optional<Product> productfind=productRepository.findById(productId);
        if (!productfind.isPresent()){
            throw new ResourceNotFoundException("not found product ");
        }
        return productfind.get();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product insert(Product category,Long categoryId) {
        Category cate=categoryRepository.findById(categoryId).get();
        category.setCategory(cate);
        return productRepository.save(category);
    }
}
