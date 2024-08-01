package com.crudVuejs.controller;

import com.crudVuejs.dto.ProductDto;
import com.crudVuejs.model.Category;
import com.crudVuejs.model.Product;
import com.crudVuejs.service.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/findAllproduct")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> categories=productServiceImpl.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/findproductbyId")
    private ResponseEntity<Product> findproductbyId(@RequestParam("productId")Long categoryId){
        return ResponseEntity.ok(productServiceImpl.findbyId(categoryId));
    }

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addnewpro(@RequestBody ProductDto category){
        return ResponseEntity.ok(productServiceImpl.insert(category));
    }

    @DeleteMapping("/deleteproduct")
    public ResponseEntity<Void> deletetask(@RequestParam("productId") Long categoryId) {
        productServiceImpl.deleteById(categoryId);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/updateproduct")
    public ResponseEntity<Product> updateproduct(@RequestBody ProductDto product){
        System.out.println(product.getProductId()+"IDWDW");
        return ResponseEntity.ok(productServiceImpl.update(product));
    }
}
