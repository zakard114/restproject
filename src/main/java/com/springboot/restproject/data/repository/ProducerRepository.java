package com.springboot.restproject.data.repository;

import com.springboot.restproject.data.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
}
