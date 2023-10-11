package com.example.shop.controller;

import com.example.shop.domain.Product;
import com.example.shop.service.ProductService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Resource
@Controller
@RequestMapping("/product")

public class ProductController {

    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/home")
    public String gohome(){
        return "/home/index";
    }


    @GetMapping("/acc")
    public String getAccPage() {
        return "product/acc";
    }

    @GetMapping("/shoes")
    public String getShoesPage() {
        return "product/shoes";
    }

    @GetMapping("/bottom")
    public String getBottomPage() {
        return "product/bottom";
    }

    @GetMapping("/top")
    public String getTopPage() {
        return "product/top";
    }
}
