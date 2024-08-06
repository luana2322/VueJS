package com.internBE.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Table(name="giaodich")

public class GiaoDich {
    @Id
    private String maGiaodich;
    private Date ngayGiaodich;
    private double dongia;
    private Long dientich;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "makhachhang",referencedColumnName = "makhachhang")
    @JsonBackReference
    private KhachHang khachhang;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "maLoaigiaodich",referencedColumnName = "maLoaigiaodich")
    @JsonBackReference
    private LoaiGiaoDich loaiGiaoDich;


}
