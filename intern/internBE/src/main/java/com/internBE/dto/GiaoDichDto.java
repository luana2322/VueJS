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
public class GiaoDichDto {
    private String maGiaodich;
    private Date ngayGiaodich;
    private double dongia;
    private Long dientich;
    private Long makhachhang;
    private Long maLoaigiaodich;
}
