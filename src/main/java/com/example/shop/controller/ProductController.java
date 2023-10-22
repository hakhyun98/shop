package com.example.shop.controller;

import com.example.shop.domain.Member;
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
    @GetMapping("/register")
    public String registerform(Model model) {
        model.addAttribute("product", Product.builder().build());
        return "/product/register";
    }
    @PostMapping("/reg-product")
    public String create(@ModelAttribute("product") Product product, Model model){
        if(productService.register(product)>0){
            return "/home/index";
        }
        else
            return "product/register";
    }
    @GetMapping("/{seq}")
    public String getProduct(@PathVariable("seq") Long seq, Model model) {
        Product result = new Product(); // 반환
        Product p = new Product(); // 매개변수로 전달
        p.setSeq(seq);
        result = productService.read(p);
        model.addAttribute("product", result);
        return "/home/index";
    }

}
