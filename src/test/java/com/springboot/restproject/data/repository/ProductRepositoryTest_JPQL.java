package com.springboot.restproject.data.repository;

import com.springboot.restproject.data.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest_JPQL {

    @Autowired
    ProductRepository productRepository;

    @Test
    void sortingAndPagingTest() {
        Product product1 = new Product();
        product1.setName("pen");
        product1.setPrice(1000);
        product1.setStock(1000);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("pen");
        product2.setPrice(5000);
        product2.setStock(300);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("pen");
        product3.setPrice(500);
        product3.setStock(50);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);
        Product savedProduct3 = productRepository.save(product3);

//        productRepository.findByName("pen", Sort.by(Sort.Order.asc("price")));
//        productRepository.findByName("pen", Sort.by(Sort.Order.asc("price"),
//                Sort.Order.desc("stock")));

//        productRepository.findByName("pen", getSort());

//        Page<Product> productPage = productRepository.findByName("pen", PageRequest.of(1,2));
//        System.out.println(productPage.getContent());

//        productRepository.findByNameParam("heeju");
        productRepository.findByNameParam2("heeju");
    }


    private Sort getSort(){
        return Sort.by(Sort.Order.asc("price"), Sort.Order.desc("stock"));
    }

}