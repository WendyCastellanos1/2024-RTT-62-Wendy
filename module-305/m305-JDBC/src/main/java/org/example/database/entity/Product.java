package org.example.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//lombok does the getters and setters for us; I don't have to type or generate them.
@Setter
@Getter
@Entity //tells there's a db
@Table(name = "products")


public class Product {

    @Id //this identifies the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hiberate that it's doing an auto-incrment
    @Column(name = "id")
    private Integer id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "productline_id")
    private Integer productlineId;

    @Column(name = "product_scale")
    private Integer productScale;

    @Column(name = "product_vendor")
    private String productVendor;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "quantity_in_stock")
    private Short quantityInStock;      // or Integer

    @Column(name = "buy_price", columnDefinition = "DECIMAL")
    private Double buyPrice;

    @Column(name = "msrp")
    private Double msrp;
}