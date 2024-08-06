package com.internBE.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Table(name="khachhang")
public class KhachHang {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long makhachhang;
    private String hoten;
    private String sdt;
    private String email;

    @OneToMany(mappedBy = "khachhang", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<GiaoDich> giaoDichList;

}
