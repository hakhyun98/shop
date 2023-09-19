package com.example.shop.service;

import com.example.shop.domain.Member;
import com.example.shop.entity.MemberEntity;
import com.example.shop.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .email(m.getEmail())
                .pw(m.getPw())
                .address(m.getAddress())
                .phone(m.getPhone())
                .build();
        if(memberRepository.save(entity) != null)
            return 1;
        else
            return 0;
    }
    @Override
    public Member read(Member m){return null;}
    @Override
    public List<Member> readlist(){return null;}
    @Override
    public int update(Member m){return 0;}
    @Override
    public int delete(Member m){return 0;}
    @Override
    public Member login(Member m){return null;}
}
