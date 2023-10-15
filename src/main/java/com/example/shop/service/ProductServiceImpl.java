package com.example.shop.service;

import com.example.shop.domain.Product;
import com.example.shop.entity.ProductEntity;
import com.example.shop.repository.ProductRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Resource
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public int register (Product m){
        ProductEntity entity = ProductEntity.builder()
                .seq(m.getSeq())
                .name(m.getName())
                .description(m.getDescription())
                .price(m.getPrice())
                .photo(m.getPhoto())
                .build();
        if(productRepository.save(entity) != null)
            return 1;
        else
            return 0;
    }
    @Override
    public Product read(Product m){return null;};
    @Override
    public List<Product> readlist(){return null;};
    @Override
    public int update(Product m){return 0;};
    @Override
    public int delete(Product m){return 0;};
}
