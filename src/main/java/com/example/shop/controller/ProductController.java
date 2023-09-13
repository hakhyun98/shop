package com.example.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

//    @GetMapping("/home")
    public String listProducts(Model model) {
        // 여기에 제품 목록을 가져오는 코드를 추가할 수 있습니다.
//        return "product/index"; // Thymeleaf 템플릿의 이름
        return null;
    }
}
