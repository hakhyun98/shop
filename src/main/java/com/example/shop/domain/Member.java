package com.example.shop.domain;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@ToString
@EqualsAndHashCode
public class Member {
    private Long seq;
    private String name;
    private String email;
    private String pw;
    private String address;
    private String phone;

}
