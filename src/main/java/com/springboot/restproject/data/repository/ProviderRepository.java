package com.springboot.restproject.data.repository;

import com.springboot.restproject.data.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
