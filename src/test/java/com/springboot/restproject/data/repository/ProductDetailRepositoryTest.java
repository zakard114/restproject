package com.springboot.restproject.data.repository;

import com.springboot.restproject.data.entity.Product;
import com.springboot.restproject.data.entity.ProductDetail;
import com.springboot.restproject.data.entity.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProductDetailRepositoryTest {

    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveAndReadTest1(){
        Product product = new Product();
        product.setName("Spring Boot JPA");
        product.setPrice(5000);
        product.setStock(500);
        productRepository.save(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setDescription("Java Persistence API");

        productDetailRepository.save(productDetail);

        // Inquiry on generated data
        System.out.println("savedProduct : "+productDetailRepository.findById(productDetail.getId())
                .get().getProduct());

        System.out.println("savedProductDetail : "+productDetailRepository.findById(productDetail.getId())
                .get());
    }
}