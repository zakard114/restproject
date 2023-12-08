package com.springboot.restproject.data.repository;

import com.springboot.restproject.data.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductRepositoryTest2 {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void basicCRUDTest(){
        /* create */
        // given
        Product givenProduct = Product.builder()
                .name("note")
                .price(1000)
                .stock(1000)
                .build();

        // when
        Product savedProduct = productRepository.save(givenProduct);

        // then
        assertThat(savedProduct.getNumber())
                .isEqualTo(givenProduct.getNumber());
        assertThat(savedProduct.getName())
                .isEqualTo(givenProduct.getName());
        assertThat(savedProduct.getPrice())
                .isEqualTo(givenProduct.getPrice());
        assertThat(savedProduct.getStock())
                .isEqualTo(givenProduct.getStock());

        /* read */
        // when
        Product selectedProduct = productRepository.findById(savedProduct.getNumber())
                .orElseThrow(RuntimeException::new);

        // then
        assertThat(selectedProduct.getNumber())
                .isEqualTo(givenProduct.getNumber());
        assertThat(selectedProduct.getName())
                .isEqualTo(givenProduct.getName());
        assertThat(selectedProduct.getPrice())
                .isEqualTo(givenProduct.getPrice());
        assertThat(selectedProduct.getStock())
                .isEqualTo(givenProduct.getStock());

        /* update */
        // when
        Product foundProduct = productRepository.findById(selectedProduct.getNumber())
                .orElseThrow(RuntimeException::new);

        foundProduct.setName("Toy");

        Product updatedProduct = productRepository.save(foundProduct);

        // then
        Assertions.assertEquals(updatedProduct.getName(), "Toy");

        /* delete */
        // when
        productRepository.delete(updatedProduct);

        // then
        Assertions.assertFalse(productRepository.findById(selectedProduct.getNumber()).isPresent());
    }

}
