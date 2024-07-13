package com.example.springboot.database.dao;

import com.example.springboot.database.entity.OrderDetail;
import com.example.springboot.database.entity.Order;
import com.example.springboot.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {

    // get ONE order detail ROW... by order detail id  (this is a magic query in that .... Spring Data JPA is able to use the method name to generate the query)
    OrderDetail findById(Integer id);

    // get LIST of order details.... by order_id (this is a JPA query just like we did in the Hibernate module)
    @Query("select od from OrderDetail od " +
            " where od.order= :id")         // TODO  uhhh, can't be right,but got rid of red, not using this class yet
    List<OrderDetail> findByOrderId(Integer id);

}