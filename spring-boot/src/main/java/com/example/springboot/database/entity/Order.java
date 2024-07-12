package com.example.springboot.database.entity;

import com.example.springboot.database.entity.Customer;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

//lombok does the getters and setters
@Setter
@Getter
@ToString
@Entity //tells there's a db
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")


public class Order {

    @Id //this identifies the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hiberate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    // foreign key situation: "many" orders can belong to "one" customer
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;

    // foreign key situation: 1 to many order details are mapped to a single order
    @ToString.Exclude
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @Column(name = "customer_id", insertable=false, updatable=false)
    private Integer customer_id;
    //   optional: add     , nullable = false  so Hibernate does NOT validate that
    @Column(name = "order_date")    // @Column(name = "order_date", nullable = false)
    @Temporal(TemporalType.DATE)  // if a timestamp
    private Date orderDate;

    @Column(name = "required_date")
    @Temporal(TemporalType.DATE)  // TODO only need a date for now, not a timestamp
    private Date requiredDate;

    @Column(name = "shipped_date")
    @Temporal(TemporalType.DATE)  // TODO only need a date for now, not a timestamp
    private Date shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;
}

//  boolean handled by adding      ,columnDefinition = "BIT"
// SQL varchar: in Java can hold 2 GB...String