package com.example.shop.controller;

import com.example.shop.domain.Member;
import com.example.shop.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Resource
@Controller
@RequestMapping("/member")
public class MemberController {
    MemberService memberService;
    public MemberController(MemberService memberService) { // Spring Framework이 주입(하도록 요청함)
        this.memberService = memberService;
    }
    HttpSession sesion = null;
    @GetMapping("/sign-up")
    public String signupform(Model model) {
        model.addAttribute("member", Member.builder().build());
        return "/member/sign-up-form";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("member") Member member, Model model){
        if(memberService.create(member)>0){
            return "/home/index";}
        else
            return "member/sign-up-form";
    }
}
