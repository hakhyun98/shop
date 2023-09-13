package com.example.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/")
    public String gohome(){
        return "redirect:/index";
    }
}
