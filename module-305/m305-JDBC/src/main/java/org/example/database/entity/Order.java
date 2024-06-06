package org.example.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

//lombok does the getters and setters for us; I don't have to type or generate them.
@Setter
@Getter
@Entity //tells there's a db
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")


public class Order {

    @Id //this identifies the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hiberate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customer_id;
                                    //   optional: add     , nullable = false  so Hibernate does NOT validate that
    @Column(name = "order_date")    // @Column(name = "order_date", nullable = false)
    @Temporal(TemporalType.DATE)  // if a timestamp
    private Date orderDate;

    @Column(name = "required_date")
    @Temporal(TemporalType.DATE)  //i've only needed a date, not a timestamp
    private Date requiredDate;

    @Column(name = "shipped_date")
    @Temporal(TemporalType.DATE)  //i've only needed a date, not a timestamp
    private Date shippedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;
}

//  boolean handled by adding      ,columnDefinition = "BIT"
// SQL varchar: in Java can hold 2 GB...String