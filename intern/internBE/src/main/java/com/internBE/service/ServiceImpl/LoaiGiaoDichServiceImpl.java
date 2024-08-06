package com.internBE.service.ServiceImpl;

import com.internBE.model.GiaoDich;
import com.internBE.model.LoaiGiaoDich;
import com.internBE.repository.LoaiGiaoDichRepository;
import com.internBE.service.LoaiGiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoaiGiaoDichServiceImpl implements LoaiGiaoDichService {
    @Autowired
    private LoaiGiaoDichRepository loaiGiaoDichRepository;
    @Override
    public List<LoaiGiaoDich> findAll() {
        List<LoaiGiaoDich> list1=new ArrayList<>();
        list1=loaiGiaoDichRepository.findAll();
        return list1;
    }
}
