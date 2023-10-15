package com.example.shop.repository;

import com.example.shop.entity.MemberEntity;
import com.example.shop.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> ,
        QuerydslPredicateExecutor<ProductEntity> {
    @Query("select p from ProductEntity p where p.num = :num")
    ProductEntity getBynum(@Param("num")String num);

//    List<MemberEntity> getMemberEntitiesByEmail(@Param("email") String email);
}
