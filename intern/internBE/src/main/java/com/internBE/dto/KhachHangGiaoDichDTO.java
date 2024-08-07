package com.internBE.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangGiaoDichDTO {
    private Long makhachhang;
    private String hoten;
    private String sdt;
    private String email;
    private String maGiaodich;
    private Date ngayGiaodich;
    private double dongia;
    private Long dientich;
    private String tenLoaigiaodich;
    private Long maLoaigiaodich;
}
