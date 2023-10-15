package com.example.shop.domain;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
@EqualsAndHashCode
public class Product {
    private Long seq;
    private String name;
    private String description;
    private String price;
    private byte[] photo;
}
