package com.ssg.productmanagement.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long pno;
    @NotEmpty
    private String name;
    private Long price;
    private int quantity;
}
