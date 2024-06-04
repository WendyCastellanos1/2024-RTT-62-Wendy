package org.example.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//lombok does the getters and setters for us; I don't have to type or generate them.
@Setter
@Getter
@Entity //tells there's a db
@Table(name = "orders")

public class Orders {

    @Id //this identifies the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hiberate that it's doing an auto-incrment
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customer_id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "required_date")
    private Date requiredDate;

    @Column(name = "shipped_date")
    private Date shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;
}
