package com.internBE.service.ServiceImpl;

import com.internBE.exception.ResourceNotFoundException;
import com.internBE.model.KhachHang;
import com.internBE.repository.KhachHangRepository;
import com.internBE.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> findAll() {
        List<KhachHang> list1 = new ArrayList<>();
        list1 = khachHangRepository.findAll();
        return list1;
    }

    @Override
    public KhachHang findbyId(Long productId) {
        Optional<KhachHang> custfind = khachHangRepository.findById(productId);
        if (!custfind.isPresent()) {
            throw new ResourceNotFoundException("not found customer ");
        }
        return custfind.get();
    }

    @Override
    public void deleteById(Long id) {
        {
            khachHangRepository.deleteById(id);
        }


    }

    @Override
    public KhachHang insert(KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang update(KhachHang category) {
        return null;
    }

}
