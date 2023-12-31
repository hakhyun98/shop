package com.example.shop.repository;

import com.example.shop.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,Long> ,
        QuerydslPredicateExecutor<MemberEntity> {
    @Query("select m from MemberEntity m where m.email = :email and m.pw = :pw ")
    MemberEntity getByEmailPw(@Param("email")String email, @Param("pw")String pw);

//    `List<MemberEntity> getMemberEntitiesByEmail(@Param("email") String email);`
}