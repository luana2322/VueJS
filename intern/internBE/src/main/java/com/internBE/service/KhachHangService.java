package com.internBE.service;

import com.internBE.model.KhachHang;

import java.util.List;

public interface KhachHangService {
    List<KhachHang> findAll();
    KhachHang findbyId(Long productId);
    void deleteById(Long id);
    KhachHang insert(KhachHang category );

    KhachHang update(KhachHang category);
}
