package com.internBE.repository;

import com.internBE.dto.GiaoDichDto;
import com.internBE.model.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich,String> {
    @Query(value="select g.maGiaodich,g.loaiDichvu,g.ngayGiaodich," +
            "g.dongia,g.dientich,k.makhachhang,k.hoten,k.sdt,k.email" +
            " from giaodich g\n" +
            "join khachhang k\n" +
            "on g.makhachhang=k.makhachhang",nativeQuery = true)
    List<GiaoDichDto> findCategoriesByProductId();

    @Query(value="select g.* " +
            " from giaodich g\n" +
            "join khachhang k\n" +
            "on g.makhachhang=k.makhachhang\n" +
            "join loaigiaodich l\n" +
            "on l.maLoaigiaodich=g.maLoaigiaodich\n" +
            "where l.tenLoaigiaodich=?1;\n",nativeQuery = true)
    List<GiaoDich> findbyLoaigiaodich(String keyword);

}
