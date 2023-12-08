package com.springboot.restproject.data.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDto {

    private String name;
    private int price;
    private int stock;
}
