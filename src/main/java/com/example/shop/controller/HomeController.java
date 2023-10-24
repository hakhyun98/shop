package com.example.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class HomeController {
    @GetMapping("/")
    public String getMainPage() {
        return "product/main";
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
