package com.example.shop.service;

import com.example.shop.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends ProductService {

    @Override
    public String getAccPage() {
        return "acc"; // acc.html 페이지를 반환
    }

    @Override
    public String getShoesPage() {
        return "shoes"; // shoes.html 페이지를 반환
    }

    @Override
    public String getBottomPage() {
        return "bottom"; // bottom.html 페이지를 반환
    }

    @Override
    public String getTopPage() {
        return "top"; // top.html 페이지를 반환
    }
}
