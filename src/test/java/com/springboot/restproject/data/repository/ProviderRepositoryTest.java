package com.springboot.restproject.data.repository;

import com.springboot.restproject.data.entity.Product;
import com.springboot.restproject.data.entity.ProductDetail;
import com.springboot.restproject.data.entity.Provider;
import jakarta.transaction.Transactional;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProviderRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProviderRepository providerRepository;


    @Test
    void relationshipTest1(){
        // Create Test Data
        Provider provider = new Provider();
        provider.setName("ITMarket");

        providerRepository.save(provider);

        Product product = new Product();
        product.setName("Java");
        product.setPrice(100);
        product.setStock(1000);
        product.setProvider(provider);

        productRepository.save(product);

        // Test
        System.out.println("product : "+productRepository.findById(1L)
                .orElseThrow(RuntimeException::new));

        System.out.println("provider : "+productRepository.findById(1L)
                .orElseThrow(RuntimeException::new).getProvider());

        // ProductDetail Addition Test
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setDescription("language");

        productDetailRepository.save(productDetail);

        product.setProductDetail(productDetail);

        System.out.println("product : "+productDetailRepository.findById(productDetail.getId()).get().getProduct());
        System.out.println("productDetail : "+productDetailRepository.findById(productDetail.getId()).get());
    }

    @Test
    void relationshipTest(){

        // Create Test Data
        Provider provider = new Provider();
        provider.setName("ITStore");

        providerRepository.save(provider);

        Product product1 = new Product();
        product1.setName("C#");
        product1.setPrice(150);
        product1.setStock(1500);
        product1.setProvider(provider);

        Product product2 = new Product();
        product2.setName("React");
        product2.setPrice(130);
        product2.setStock(1300);
        product2.setProvider(provider);

        Product product3 = new Product();
        product3.setName("React");
        product3.setPrice(135);
        product3.setStock(1350);
        product3.setProvider(provider);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        List<Product> products = providerRepository.findById(provider.getId()).get()
                .getProductList();

        for(Product product: products){
            System.out.println(product);
        }
    }

    @Test
    void cascadeTest(){
        Provider provider = savedProvider("New Provider");

        Product product1 = savedProduct("product1", 1000, 1000);
        Product product2 = savedProduct("product2", 1000, 1000);
        Product product3 = savedProduct("product3", 750,500);

        // Relationship Setting
        product1.setProvider(provider);
        product2.setProvider(provider);
        product3.setProvider(provider);

        provider.getProductList().addAll(Lists.newArrayList(product1, product2, product3));

        providerRepository.save(provider);
    }

    private Product savedProduct(String name, Integer price, Integer stock) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);

        return product;
    }

    private Provider savedProvider(String name) {
        Provider provider = new Provider();
        provider.setName(name);
        return provider;
    }

    @Test
    @Transactional
    void orphanRemovalTest(){
        Provider provider = savedProvider("New Provider");

        Product product1 = savedProduct("product1", 1000, 1000);
        Product product2 = savedProduct("product2", 500, 1500);
        Product product3 = savedProduct("product3", 750, 500);

        product1.setProvider(provider);
        product2.setProvider(provider);
        product3.setProvider(provider);

        provider.getProductList().addAll(Lists.newArrayList(product1, product2, product3));

        providerRepository.saveAndFlush(provider);

        providerRepository.findAll().forEach(System.out::println);
        productRepository.findAll().forEach(System.out::println);

        Provider foundProvider = providerRepository.findById(1L).get();
        foundProvider.getProductList().remove(0);

        providerRepository.findAll().forEach(System.out::println);
        productRepository.findAll().forEach(System.out::println);


    }


}
