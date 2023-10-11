package com.example.shop.service;

import com.example.shop.domain.Member;
import com.example.shop.entity.MemberEntity;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Resource
@Service
public interface MemberService {
    int create (Member m);
    Member read(Member m);
    List<Member> readlist();
    int update(Member m);
    int delete(Member m);
    Member login(Member m);

    default MemberEntity dtoToEntity(Member dto){
        MemberEntity entity = MemberEntity.builder()
                .seq(dto.getSeq())
                .name(dto.getName())
                .email(dto.getEmail())
                .pw(dto.getPw())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .build();
        return entity;
    }

    default Member EntityToDto(MemberEntity entity){
        Member dto = Member.builder()
                .seq(entity.getSeq())
                .name(entity.getName())
                .email(entity.getEmail())
                .pw(entity.getPw())
                .address(entity.getAddress())
                .phone((entity.getPhone()))
                .build();
        return dto;
    }
}
