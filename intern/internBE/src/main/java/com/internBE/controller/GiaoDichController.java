package com.internBE.controller;

import com.internBE.dto.GiaoDichDto;
import com.internBE.model.GiaoDich;
import com.internBE.repository.GiaoDichRepository;
import com.internBE.service.ServiceImpl.GiaoDichServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/giaodich")
public class GiaoDichController {
    @Autowired
    private GiaoDichServiceImpl giaoDichServiceImpl;
    @Autowired
    private GiaoDichRepository giaoDichRepository;

    @GetMapping("/findAllgiaoDich")
    public ResponseEntity<List<GiaoDich>> findAll(){
        List<GiaoDich> categories=giaoDichServiceImpl.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GiaoDichDto>> findAlldto(){
        List<GiaoDichDto> categories= (List<GiaoDichDto>) giaoDichRepository.findCategoriesByProductId();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/findgiaodichbyId")
    private ResponseEntity<GiaoDich> findgiaodichbyId(@RequestParam("maGiaodich")String categoryId){
        return ResponseEntity.ok(giaoDichServiceImpl.findbyId(categoryId));
    }
    @PostMapping("/addgiaodich")
    public ResponseEntity<GiaoDich> addnewgd(@RequestBody GiaoDichDto category){
        return ResponseEntity.ok(giaoDichServiceImpl.insert(category));
    }


    @DeleteMapping("/deletegiaodich")
    public ResponseEntity<Void> deletetask(@RequestParam("maGiaodich") String categoryId) {
        giaoDichServiceImpl.deleteById(categoryId);
        return ResponseEntity.ok().build();
    }

}
