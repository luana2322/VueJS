package com.internBE.repository;

import com.internBE.dto.KhachHangGiaoDichDTO;
import com.internBE.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,Long> {
    @Query("SELECT new com.internBE.dto.KhachHangGiaoDichDTO(k.makhachhang, k.hoten, k.sdt, k.email, g.maGiaodich, g.ngayGiaodich, g.dongia, g.dientich, l.tenLoaigiaodich, l.maLoaigiaodich) " +
            "FROM KhachHang k " +
            "JOIN k.giaoDichList g " +
            "JOIN g.loaiGiaoDich l")
    List<KhachHangGiaoDichDTO> findAllKhachHangGiaoDich();

    @Query("SELECT new com.internBE.dto.KhachHangGiaoDichDTO(k.makhachhang, k.hoten, k.sdt, k.email, g.maGiaodich, g.ngayGiaodich, g.dongia, g.dientich, l.tenLoaigiaodich, l.maLoaigiaodich) " +
            "FROM KhachHang k " +
            "JOIN k.giaoDichList g " +
            "JOIN g.loaiGiaoDich l" +
            " where l.maLoaigiaodich=?1")
    List<KhachHangGiaoDichDTO> findAllKhachHangByLoaiGiaoDich(Long maLoaiGiaoDich);
}
