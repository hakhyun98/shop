package com.example.shop.controller;

import com.example.shop.domain.Member;
import com.example.shop.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
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
    HttpSession session = null;
    @GetMapping("/sign-up")
    public String signupform(Model model) {
        model.addAttribute("member", Member.builder().build());
        return "/member/sign-up-form";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("member") Member member, Model model){
        if(memberService.create(member)>0){
            return "/product/main";}
        else
            return "member/sign-up-form";
    }

    @GetMapping("/sign-in")
    public String signinform(Model model){
        model.addAttribute("member",Member.builder().build());
        return "member/login-form";
    }
    @PostMapping("/login")
    public String loginMember(@ModelAttribute("member") Member member, HttpServletRequest request) { // 로그인 처리 -> service -> repository -> service -> controller
        Member result = null;
        if ((result = memberService.login(member)) != null) { // 정상적으로 레코드의 변화가 발생하는 경우 영향받는 레코드 수를 반환
            session = request.getSession();
            session.setAttribute("mb", result);
            return "redirect:/";
        } else
            return "product/main";
    }

    @GetMapping("/logout")
    public String logoutmember(){
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/{seq}")
    public String getMember(@PathVariable("seq") Long seq, Model model) {
        Member result = new Member();
        Member m = new Member();
        m.setSeq(seq);
        result = memberService.read(m);
        model.addAttribute("member", result);
        return "/member/detail";
    }
//    @GetMapping("/update/{seq}")
//    public String upMember(@PathVariable("seq") Long seq, Model model) {
//        Member result = new Member();
//        Member m = new Member();
//        m.setSeq(seq);
//        result = memberService.read(m);
//        model.addAttribute("member", result);
//        return "/member/update";
//    }
    @PutMapping("/update/{seq}")
    public String updateMember(@ModelAttribute("member") Member member, Model model) {
        if(memberService.update(member) > 0 ) {
            session.setAttribute("mb", member);
            return "redirect:/";
        }
        else
            return "/member/detail";
    }
}
