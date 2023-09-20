package com.example.shop.entity;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;
@Entity
@Enabled
@Table(name = "member")
@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(sequenceName = "member_seq" , name = "member_gen", initialValue = 1 , allocationSize = 1)

public class MemberEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
    private Long seq;
    @Column(length = 20 , nullable = false)
    private String name;
    @Column(length = 20 , nullable = false)
    private String email;
    @Column(length = 20 , nullable = false)
    private String pw;
    @Column(length = 20 , nullable = false)
    private String phone;
    @Column(length = 20 , nullable = false)
    private String address;
}
