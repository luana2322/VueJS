package com.internBE.repository;

import com.internBE.model.LoaiGiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiGiaoDichRepository extends JpaRepository<LoaiGiaoDich,Long> {
}
