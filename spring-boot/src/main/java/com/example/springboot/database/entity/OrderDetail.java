package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.springboot.database.entity.Order;
import com.example.springboot.database.entity.Product;

import java.util.Objects;

//lombok does the getters and setters
@Setter
@Getter
@ToString
@Entity // indicates a db
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails")

public class OrderDetail {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hibernate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "order_id", insertable = false, updatable = false)
    private int orderId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_id", insertable=false, updatable=false)
    private Integer productId;

    @Column(name = "quantity_ordered") //could put default to 0
    private Integer quantityOrdered = 0;

    @Column(name = "price_each", columnDefinition = "DECIMAL(10,2)")
    private Double priceEach;

    @Column(name = "order_line_number")
    private Short orderLineNumber;

    @Transient
    private String productName;

    @Transient
    public String productName() {
        return productName;
    }


//    @Override
//    public boolean equals(Object o) {
//        if(this == o) return true;
//        if(o == null || getClass() != o.getClass()) return false;
//        OrderDetail orderDetail = (OrderDetail) o;
//        return id == orderDetail.id && Objects.equals(productId, orderDetail.productId);
//    }
//    @Override
//    public int hashCode(){
//        return Objects.hash(id, productId);
//    }

}
