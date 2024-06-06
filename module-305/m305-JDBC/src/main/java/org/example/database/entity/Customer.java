package org.example.database.entity;

import jakarta.persistence.*;   // Jakarta Persistence Query Language
import lombok.*;

//lombok does the getters and setters for us; I don't have to type or generate them.
@Setter
@Getter
@Entity //tells there's a db
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")

public class Customer {

    @Id //this identifies the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hibernate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_name")
    private String customer_name;

    @Column(name = "contact_lastname")
    private String contact_lastName;

    @Column(name = "contact_firstname")
    private String contact_firstName;

    @Column(name = "phone")
    private String phone;

    @Column(name ="address_line1")
    private String address_line1;

    @Column(name ="address_line2")
    private String address_line2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "country")
    private String country;

    @Column(name = "sales_rep_employee_id")
    private Integer sales_rep_employee_id;

    @Column(name = "credit_limit")
    private double credit_limit;
}
