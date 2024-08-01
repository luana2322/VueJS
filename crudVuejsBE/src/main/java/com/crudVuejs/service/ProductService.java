package com.crudVuejs.service;

import com.crudVuejs.dto.ProductDto;
import com.crudVuejs.model.Category;
import com.crudVuejs.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findbyId(Long productId);
    void deleteById(Long id);
    Product insert(ProductDto category );

    Product update(ProductDto category);
}
