package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface ProductDAO extends JpaRepository<Product, Long> {

    // get ONE product...by id  (this is a magic query in that .... Spring Data JPA is able to use the method name to generate the query)
    Product findById(Integer id);

    // get LIST of products...by name   (this is a JPA query just like we did in the Hibernate module)
    @Query("select p from Product p where p.productName like concat('%', :name, '%') " +
            "or p.productCode like concat('%', :name, '%')")
    List<Product> findByNameOrCode(String name);

}
