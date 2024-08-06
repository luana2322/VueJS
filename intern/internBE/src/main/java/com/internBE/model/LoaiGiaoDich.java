package com.internBE.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Table(name="loaigiaodich")
public class LoaiGiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maLoaigiaodich;
    private String tenLoaigiaodich;


    @OneToMany(mappedBy = "loaiGiaoDich", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<GiaoDich> giaoDichList;
}
