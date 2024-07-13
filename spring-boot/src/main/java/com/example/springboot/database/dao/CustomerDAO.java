package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, Long> {

    // get ONE customer...by id  (this is a magic query in that .... Spring Data JPA is able to use the method name to generate the query)
    Customer findById(Integer id);

    // get LIST of customers.... by name (this is a JPA query just like we did in the Hibernate module)
    @Query("select c from Customer c " +
            "where c.customerName like concat('%', :name, '%')")
    List<Customer> findByCustomerName(String name);

}