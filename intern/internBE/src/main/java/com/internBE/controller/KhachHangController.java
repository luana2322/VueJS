package com.internBE.controller;

import com.internBE.model.KhachHang;
import com.internBE.service.ServiceImpl.KhachHangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/khachhang")
public class KhachHangController {
    @Autowired
    private KhachHangServiceImpl khachHangServiceImpl;

    @GetMapping("/findAllcus")
    public ResponseEntity<List<KhachHang>> findAll(){
        List<KhachHang> categories=khachHangServiceImpl.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/findcusbyId")
    private ResponseEntity<KhachHang> findgiaodichbyId(@RequestParam("makhachhang")Long categoryId){
        return ResponseEntity.ok(khachHangServiceImpl.findbyId(categoryId));
    }
    @PostMapping("/addcus")
    public ResponseEntity<KhachHang> addnewgd(@RequestBody KhachHang category){
        return ResponseEntity.ok(khachHangServiceImpl.insert(category));
    }


    @DeleteMapping("/deletecus")
    public ResponseEntity<Void> deletetask(@RequestParam("makhachhang") Long categoryId) {
        khachHangServiceImpl.deleteById(categoryId);
        return ResponseEntity.ok().build();
    }

}
