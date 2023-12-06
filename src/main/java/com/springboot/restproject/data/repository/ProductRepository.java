package com.springboot.restproject.data.repository;

import com.springboot.restproject.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
