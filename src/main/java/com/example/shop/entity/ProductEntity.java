package com.example.shop.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

@Entity
@Enabled
@Table(name = "product")
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(sequenceName = "product_seq" , name = "product_gen", initialValue = 1 , allocationSize = 1)

public class ProductEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
    private Long seq;
    @Column(length = 20 , nullable = false)
    private String name;
    @Column(length = 100 , nullable = false)
    private String description;
    @Column(length = 20 , nullable = false)
    private String price;
    @Lob
    private byte[] photo;
    @Column(length = 20 , nullable = false)
    private int num;
}
