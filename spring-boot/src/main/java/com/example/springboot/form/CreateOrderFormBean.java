package com.example.springboot.form;

import com.example.springboot.database.entity.Customer;
import com.example.springboot.database.entity.OrderDetail;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString

public class CreateOrderFormBean {

    private Integer id;
    private Customer customer;
    private List<OrderDetail> orderDetails;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;

}
