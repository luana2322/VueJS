package com.internBE.controller;

import com.internBE.model.KhachHang;
import com.internBE.model.LoaiGiaoDich;
import com.internBE.service.ServiceImpl.LoaiGiaoDichServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/loaigiaodich")
public class LoaiGiaoDichController {
    @Autowired
    private LoaiGiaoDichServiceImpl loaiGiaoDichServiceImpl;
    @GetMapping("/findAllloaigiaodich")
    public ResponseEntity<List<LoaiGiaoDich>> findfindAllloaigiaodichAll(){
        List<LoaiGiaoDich> categories=loaiGiaoDichServiceImpl.findAll();
        return ResponseEntity.ok(categories);
    }

}
