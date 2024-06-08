package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

//lombok does the getters and setters for us; I don't have to type or generate them.
@Setter
@Getter
@Entity //tells there's a db
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orderdetails")



 public class OrderDetail {

   @Id //this identifies the PK
   @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hiberate that it's doing an auto-incrment
   @Column(name = "id")
   private Integer id;

   @Column(name = "order_id")
   private int orderId;

     @ToString.Exclude
     @ManyToOne(fetch = FetchType.LAZY, optional = false)
     @JoinColumn(name = "order_id", nullable = false)
     private Order order;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

   @Column(name = "product_id")
   private Integer productId;

   @Column(name = "quantity_ordered") //could put default to 0
   private Integer quantityOrdered = 0;

   @Column(name = "price_each", columnDefinition = "DECIMAL(10,2)")
   private Double priceEach;

   @Column(name = "order_line_number")
   private Integer orderLineNumber;

}
