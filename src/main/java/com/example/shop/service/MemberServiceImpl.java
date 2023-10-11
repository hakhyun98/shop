package com.example.shop.service;

import com.example.shop.domain.Member;
import com.example.shop.entity.MemberEntity;
import com.example.shop.repository.MemberRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Resource
@Service
public class MemberServiceImpl implements MemberService{
    MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public int create (Member m){
        MemberEntity entity = MemberEntity.builder()
                .seq(m.getSeq())
                .name(m.getName())
                .address(m.getAddress())
                .phone(m.getPhone())
                .email(m.getEmail())
                .pw(m.getPw())
                .build();
        if(memberRepository.save(entity) != null)
            return 1;
        else
            return 0;
    }
    @Override
    public Member read(Member m){
        MemberEntity e = memberRepository.getById(m.getSeq()); // JpaRepository 구현체의 메소드
        Member result = new Member(); // DTO (Data Transfer Object) : Controller - Service or Controller - View
        System.out.println(e);
        result.setSeq(e.getSeq());
        result.setName(e.getName());
        result.setAddress(e.getAddress());
        result.setPhone(e.getPhone());
        result.setEmail(e.getEmail());
        return result;
    }
    @Override
    public List<Member> readlist(){return null;}
    @Override
    public int update(Member m){
        MemberEntity entity = MemberEntity.builder()
                .seq(m.getSeq())
                .name(m.getName())
                .address(m.getAddress())
                .phone(m.getPhone())
                .email(m.getEmail())
                .build();
        if(memberRepository.save(entity) != null) // 저장 성공
            return 1;
        else
            return 0;
    }
    @Override
    public int delete(Member m){return 0;}
    @Override
    public Member login(Member m){
        MemberEntity e = memberRepository.getByEmailPw(m.getEmail(), m.getPw()); // JpaRepository 구현체의 메소드
        System.out.println("login : " + e);
        Member result = null; // DTO (Data Transfer Object) : Controller - Service or Controller - View
        if(e != null) {
            result = new Member();
            result.setSeq(e.getSeq());
            result.setEmail(e.getEmail());
            result.setName(e.getName());
        }
        return result;
    }
}
