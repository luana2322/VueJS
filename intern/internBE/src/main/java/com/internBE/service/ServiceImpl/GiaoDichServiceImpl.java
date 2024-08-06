package com.internBE.service.ServiceImpl;

import com.internBE.exception.ResourceNotFoundException;
import com.internBE.model.GiaoDich;
import com.internBE.repository.GiaoDichRepository;
import com.internBE.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GiaoDichServiceImpl implements GiaoDichService {
    @Autowired
    private GiaoDichRepository giaoDichRepository;
    @Override
    public List<GiaoDich> findAll() {
        List<GiaoDich> list1=new ArrayList<>();
        list1=giaoDichRepository.findAll();
        return list1;
    }

    @Override
    public GiaoDich findbyId(String productId) {
        Optional<GiaoDich> productfind=giaoDichRepository.findById(productId);
        if (!productfind.isPresent()){
            throw new ResourceNotFoundException("not found giaodich ");
        }
        return productfind.get();
    }

    @Override
    public void deleteById(String id) {
        giaoDichRepository.deleteById(id);
    }

    @Override
    public GiaoDich insert(GiaoDich category) {
        return giaoDichRepository.save(category);
    }

    @Override
    public GiaoDich update(GiaoDich category) {
        return null;
    }
}
