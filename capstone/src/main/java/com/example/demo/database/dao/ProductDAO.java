package com.example.demo.database.dao;

import com.example.demo.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDAO extends JpaRepository<Product, Long> {

    Product findById(Integer id);


}