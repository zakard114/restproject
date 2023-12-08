package com.springboot.restproject.service.impl;

import com.springboot.restproject.data.dto.ProductDto;
import com.springboot.restproject.data.dto.ProductResponseDto;
import com.springboot.restproject.data.entity.Product;
import com.springboot.restproject.data.repository.ProductRepository;
import com.springboot.restproject.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@ExtendWith(SpringExtension.class) // 1. To directly inject from Spring
@Import({ProductServiceImpl.class}) // 2. To directly inject to ProductService

class ProductServiceImplTest {

    @MockBean
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

//    private ProductRepository productRepository = Mockito.mock(ProductRepository.class);
//    private ProductServiceImpl productService;


    @BeforeEach
    public void setUpTest(){
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    void getProduct() {
        Product givenProduct = new Product();
        givenProduct.setNumber(123L);
        givenProduct.setName("pen");
        givenProduct.setPrice(1);
        givenProduct.setStock(1234);

        Mockito.when(productRepository.findById(123L))
                .thenReturn(Optional.of(givenProduct));

        ProductResponseDto productResponseDto = productService.getProduct(123L);

        Assertions.assertEquals(productResponseDto.getNumber(), givenProduct.getNumber());
        Assertions.assertEquals(productResponseDto.getName(), givenProduct.getName());
        Assertions.assertEquals(productResponseDto.getPrice(), givenProduct.getPrice());
        Assertions.assertEquals(productResponseDto.getStock(), givenProduct.getStock());

        verify(productRepository).findById(123L);
    }



    @Test
    void saveProduct() {
       Mockito.when(productRepository.save(any(Product.class))) //any(arg): Any object of arg can be received.
               .then(returnsFirstArg()); //returnsFirstArg(): Returns the first parameter of the returned
                            // object. Since there is only one returned object, product, product is returned.

        ProductResponseDto productResponseDto = productService.saveProduct(
                new ProductDto("pen", 1000, 1234));

        Assertions.assertEquals(productResponseDto.getName(), "pen");
        Assertions.assertEquals(productResponseDto.getPrice(), 1000);
        Assertions.assertEquals(productResponseDto.getStock(), 1234);

        verify(productRepository).save(any());

    }

}