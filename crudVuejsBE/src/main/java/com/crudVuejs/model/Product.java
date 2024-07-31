package com.crudVuejs.model;

import com.crudVuejs.service.serviceImpl.CategoryServiceImpl;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String image;
    private Double price;
    private String description;
    private Date manufactureDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId")
    @JsonBackReference
    private Category category;
}
