package com.example.shop.controller;
import org.springframework.web.multipart.MultipartFile;

import com.example.shop.domain.Member;
import com.example.shop.domain.PageRequestDTO;
import com.example.shop.domain.PageResultDTO;
import com.example.shop.domain.Product;
import com.example.shop.entity.ProductEntity;
import com.example.shop.service.ProductService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Resource
@Controller
@RequestMapping("/product")

public class ProductController {

    ProductService productService;
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

//    @GetMapping(value ={"", "/"} ) // ?page=&perPage=
//    public String listProductPagination(@RequestParam(value="page", required = false, defaultValue = "1") int page,
//                                       @RequestParam(value="per-page", required = false, defaultValue = "8") int perPage,
//                                       @RequestParam(value="per-pagination", required = false, defaultValue ="5") int perPagination,
//                                       @RequestParam(value="type", required = false, defaultValue ="e") String type,
//                                       @RequestParam(value="keyword", required = false, defaultValue ="@") String keyword,
//                                       Model model) {
//        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
//                .page(page)
//                .perPage(perPage)
//                .perPagination(perPagination)
//                .type(type)
//                .keyword(keyword)
//                .build();
//        PageResultDTO<Product, ProductEntity> resultDTO = productService.getList(pageRequestDTO);
//        if (resultDTO != null) {
//            model.addAttribute("result", resultDTO); //page number list
//            return "/product/main"; // view : template engine - thymeleaf .html
//        }
//        else return null;
//    }


    @GetMapping("/register")
    public String registerform(Model model) {
        model.addAttribute("product", Product.builder().build());
        return "/product/register";
    }
    @PostMapping("/reg-product")
    public String create(@ModelAttribute("product") Product product, Model model){
        if(productService.register(product)>0){
            return "/product/main";
        }
        else
            return "product/register";
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> productList = productService.readList();
        model.addAttribute("products", productList);
        return "product/main"; // 실제 템플릿 파일의 이름으로 변경해주세요
    }
//    @GetMapping("{seq}")
//    public String getProduct(@PathVariable("seq") Long seq, Model model) {
//        Product result = new Product(); // 반환
//        Product p = new Product(); // 매개변수로 전달
//        p.setSeq(seq);
//        result = productService.read(p);
//        model.addAttribute("product", result);
//        return "/home/index";
//    }

}
