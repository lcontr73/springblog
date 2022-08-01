package com.example.codeup.springblog.repositories;

import com.example.codeup.springblog.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
