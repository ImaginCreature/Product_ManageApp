package com.ssg.productmanagement.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
    private Long pno;
    private String name;
    private Long price;
    private int quantity;
}
