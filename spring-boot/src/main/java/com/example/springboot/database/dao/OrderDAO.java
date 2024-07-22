package com.example.springboot.database.dao;

import com.example.springboot.database.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Map;


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

    // each Map is the list represents a row in the result set from the db
    // in this result, the String is the column name and the object is the value in the column
    // for "quasi" ad hoc query
    // TODO pass in an order Id as a parameter
    @Query(value="select o.id as order_id, o.order_date, od.quantity_ordered, od.price_each, " +
            "p.id as product_id, p.product_name, " +
            "(od.quantity_ordered * od.price_each) as line_item_total " +
            "from  orders o, orderdetails od, products p " +
            "where o.id = od.order_id and od.product_id = p.id " +
            " and o.id = :orderId;", nativeQuery = true)
    List<Map<String,Object>> getOrderDetails(Integer orderId);

}
