package com.example.shop.service;


import com.example.shop.domain.Member;
import com.example.shop.entity.MemberEntity;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Resource


@Service
public class ProductService {

    public String getAccPage() {
        return "acc"; // acc.html 페이지를 반환
    }

    public String getShoesPage() {
        return "shoes"; // shoes.html 페이지를 반환
    }

    public String getBottomPage() {
        return "bottom"; // bottom.html 페이지를 반환
    }

    public String getTopPage() {
        return "top.html"; // top.html 페이지를 반환
    }
}



