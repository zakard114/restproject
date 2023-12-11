package com.springboot.restproject.data.repository;

import com.springboot.restproject.data.entity.Category;
import com.springboot.restproject.data.entity.Product;
import com.springboot.restproject.data.entity.ProductDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void relationshipTest(){
        // Create Test Data
        Product product = new Product();
        product.setName("pen");
        product.setPrice(2);
        product.setStock(100);

        productRepository.save(product);

        Category category = new Category();
        category.setCode("S1");
        category.setName("Device");
        category.getProducts().add(product);

        categoryRepository.save(category);

        // Test Code
        List<Product> products = categoryRepository.findById(1L).get().getProducts();

        for (Product foundProduct : products) {
            System.out.println(foundProduct);
        }


    }
}