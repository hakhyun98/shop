package com.example.shop.service;


import com.example.shop.domain.Member;
import com.example.shop.domain.PageRequestDTO;
import com.example.shop.domain.PageResultDTO;
import com.example.shop.domain.Product;
import com.example.shop.entity.MemberEntity;
import com.example.shop.entity.ProductEntity;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Resource


@Service
public interface ProductService {

    int register (Product p);
//    Product findBoardById(Product product);
    Product read(Product p);
    List<Product> readList();
//    List<Product> getProductBynum();
    int update(Product p);
    int delete(Product p);



    default ProductEntity dtoToEntity(Product dto){
       ProductEntity entity = ProductEntity.builder()
                .seq(dto.getSeq())
                .name(dto.getName())
                .description(dto.getDescription())
                .photo(dto.getPhoto())
                .num(dto.getNum())
                .price(dto.getPrice())
                .build();
        return entity;
    }

    default Product entityToDto(ProductEntity entity){
        Product dto = Product.builder()
                .seq(entity.getSeq())
                .name(entity.getName())
                .price(entity.getPrice())
                .photo(entity.getPhoto())
                .num(entity.getNum())
                .description(entity.getDescription())
                .build();
        return dto;
    }
}





