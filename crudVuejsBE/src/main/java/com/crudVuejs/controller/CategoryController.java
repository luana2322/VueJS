package com.crudVuejs.controller;

import com.crudVuejs.model.Category;
import com.crudVuejs.service.serviceImpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/findAllcate")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<List<Category>> findAllcate(){
        List<Category> categories=categoryServiceImpl.findAll();

//        return new ResponseEntity<>(categories, HttpStatus.OK);
        return ResponseEntity.ok(categories);

    }

    @GetMapping("/findcategorybyId")
    private ResponseEntity<Category> findcategorybyId(@RequestParam("categoryId")Long categoryId){
        return ResponseEntity.ok(categoryServiceImpl.findbyId(categoryId));
    }

    @PostMapping("/addcategory")
    public ResponseEntity<Category> addnewcate(@RequestBody Category category){
        return ResponseEntity.ok(categoryServiceImpl.insert(category));
    }

    @PostMapping("/updatecategory")
    public ResponseEntity<Category> updatecategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryServiceImpl.update(category));
    }

    @DeleteMapping("/deletecate")
    public ResponseEntity<Void> deletecate(@RequestParam("categoryId") Long categoryId) {
        categoryServiceImpl.deleteById(categoryId);
        return ResponseEntity.ok().build();
    }
}
