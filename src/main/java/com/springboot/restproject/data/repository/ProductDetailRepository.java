package com.springboot.restproject.data.repository;

import com.springboot.restproject.data.entity.ProductDetail;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
