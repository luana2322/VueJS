package com.internBE.service;

import com.internBE.dto.GiaoDichDto;
import com.internBE.model.GiaoDich;

import java.util.List;

public interface GiaoDichService {
    List<GiaoDich> findAll();
    GiaoDich findbyId(String productId);
    void deleteById(String id);
    GiaoDich insert(GiaoDichDto category );

    GiaoDich update(GiaoDich category);
}
