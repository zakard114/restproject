package com.springboot.restproject.data.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;
}
