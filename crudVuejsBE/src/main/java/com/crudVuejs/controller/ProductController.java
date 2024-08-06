package com.crudVuejs.controller;

import com.crudVuejs.dto.ProductDto;
import com.crudVuejs.exception.ResourceNotFoundException;
import com.crudVuejs.model.Category;
import com.crudVuejs.model.Product;
import com.crudVuejs.repository.ProductRepository;
import com.crudVuejs.service.serviceImpl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/findAllproduct")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> categories=productServiceImpl.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@RequestParam("keyword")String key){
        List<Product> categories=productRepository.searchproduct(key);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/findproductbyId")
    private ResponseEntity<Product> findproductbyId(@RequestParam("productId")Long categoryId){
        return ResponseEntity.ok(productServiceImpl.findbyId(categoryId));
    }

//    @PostMapping("/addproduct")
//    public ResponseEntity<Product> addnewpro(@RequestBody ProductDto category){
//        return ResponseEntity.ok(productServiceImpl.insert(category));
//    }

    @PostMapping("/addproduct")
    public ResponseEntity<Product> addnewpro(
            @RequestPart("product") String productJson,
            @RequestPart("image") MultipartFile image){
        try {
            // Chuyển đổi JSON thành đối tượng ProductDTO
            ObjectMapper objectMapper = new ObjectMapper();
            ProductDto product = objectMapper.readValue(productJson, ProductDto.class);

            // Xử lý logic để lưu trữ thông tin và tệp
            // Ví dụ: lưu tệp, lưu thông tin vào cơ sở dữ liệu, v.v.



            product.setImage(image);
            return ResponseEntity.ok(productServiceImpl.insert(product));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error add new product ");
        }

    //    return ResponseEntity.ok(productServiceImpl.insert(category));
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
