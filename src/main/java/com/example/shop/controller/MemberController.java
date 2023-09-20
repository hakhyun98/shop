package com.example.shop.controller;

import com.example.shop.domain.Member;
import com.example.shop.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
public class MemberController {
    MemberService memberService;
    @GetMapping("/sign-up")
    public String signupform(Model model) {
        model.addAttribute("member", Member.builder().build());
        return "/member/sign-up-form";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("member") Member member, Model model){
        if(memberService.create(member)>0){
            System.out.println('1');
            return "/home/index";}
        else
            System.out.println('0');
            return "member/sign-up-form";
    }
}
