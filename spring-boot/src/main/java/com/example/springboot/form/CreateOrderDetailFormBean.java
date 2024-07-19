package com.example.springboot.form;

import lombok.*;

@Getter
@Setter
@ToString

public class CreateOrderDetailFormBean {

    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer quantityOrdered;
    private Double priceEach;            // decimal(10,2) in db
    private Short orderLineNumber;      // smallint in db

}
