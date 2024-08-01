package com.crudVuejs.service.serviceImpl;

import com.crudVuejs.dto.ProductDto;
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
    public Product insert(ProductDto category) {
        Product product1=convert(category);


        return productRepository.save(product1);
    }

    @Override
    public Product update(ProductDto product) {
        Product product1=convert(product);


        return productRepository.save(product1);
    }

    public Product convert (ProductDto prodto){
        Product pro=new Product();
        pro.setProductId(prodto.getProductId());
        pro.setProductName(prodto.getProductName());
        pro.setPrice(prodto.getPrice());
        pro.setDescription(prodto.getDescription());
        pro.setImage(prodto.getImage());
        pro.setManufactureDate(prodto.getManufactureDate());
        Category category1=categoryRepository.findById(prodto.getCategoryId()).get();

        pro.setCategory(category1);
        return pro;
    }
}
