package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface OrderDAO extends JpaRepository<Order, Long> {

    // get ONE order... by order id  (this is a magic query in that .... Spring Data JPA is able to use the method name to generate the query)
    Order findById(Integer id);

    // get LIST of orders.... by customer_id (this is a JPA query just like we did in the Hibernate module)
    @Query("select o from Order o, Customer c " +
            " where o.customerId = :id")
    List<Order> findByCustomerId(Integer id);

    // get LIST of orders... by customer name, or like customer name
    @Query("select o from Order o, Customer c " +
            " where o.customerId = c.id and c.customerName like concat('%', :name, '%') " )
    List<Order> findByCustomerName(String name);



}
