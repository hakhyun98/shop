package com.example.shop.service;

import com.example.shop.domain.Product;
import com.example.shop.entity.MemberEntity;
import com.example.shop.entity.ProductEntity;
import com.example.shop.repository.ProductRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@Resource
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public int register (Product p){
        ProductEntity entity = ProductEntity.builder()
                .seq(p.getSeq())
                .name(p.getName())
                .description(p.getDescription())
                .price(p.getPrice())
                .photo(p.getPhoto())
                .num(p.getNum())
                .build();
        if(productRepository.save(entity) != null)
            return 1;
        else
            return 0;
    }
//    @Override
//    public Product findBoardById(Product product) {
//        Object[] entities = (Object[]) productRepository.getBynum(product.getNum());
//        return EntityToDto((ProductEntity) entities[0], (MemberEntity) entities[1], (Long) entities[2]);
//    }

    @Override
    public Product read(Product p){
        ProductEntity e = productRepository.getById(p.getSeq()); // JpaRepository 구현체의 메소드
        Product result = new Product(); // DTO (Data Transfer Object) : Controller - Service or Controller - View
        result.setSeq(e.getSeq());
        result.setName(e.getName());
        result.setPrice(e.getPrice());
        result.setPhoto(e.getPhoto());
        result.setDescription(e.getDescription());
        return result;
    };
    @Override
    public List<Product> readlist(){
        List<ProductEntity> entities = new ArrayList<>();
        List<Product> products = null;
        if((entities = productRepository.findAll()) != null) {
            products = new ArrayList<>();
            for(ProductEntity e : entities) {
                Product p = Product.builder()
                        .seq(e.getSeq())
                        .name(e.getName())
                        .price(e.getPrice())
                        .photo(e.getPhoto())
                        .description(e.getDescription())
                        .build();
                products.add(p);
            }
        }
        return products;
    };
    @Override
    public int update(Product m){return 0;};
    @Override
    public int delete(Product m){return 0;};
}
