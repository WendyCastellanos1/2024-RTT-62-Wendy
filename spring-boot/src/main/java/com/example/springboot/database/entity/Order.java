package com.example.springboot.database.entity;

import com.example.springboot.database.entity.Customer;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//lombok does the getters and setters
@Setter
@Getter
@ToString
@Entity // indicates a db
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")


public class Order {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hiberate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    // foreign key situation: "many" orders can belong to "one" customer
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "customer_id", nullable = true)
    private Customer customer;

    @Column(name = "customer_id", insertable=false, updatable=false)
    private Integer customerId;

    // foreign key situation: 1 to many order details are mapped to a single order
    @ToString.Exclude
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

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

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(customerId, order.customerId);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, customerId);
    }
}

//  boolean handled by adding      ,columnDefinition = "BIT"
// SQL varchar: in Java can hold 2 GB...String