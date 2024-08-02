package com.crudVuejs.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
     Long productId;
    @NotNull
     String productName;
    @NotNull
     Double price;
     String description;
     Date manufactureDate;
    Long categoryId;
    MultipartFile image;

}
