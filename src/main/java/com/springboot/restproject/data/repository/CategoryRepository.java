package com.springboot.restproject.data.repository;

import com.springboot.restproject.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
