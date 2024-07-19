package com.example.springboot.database.entity;

import jakarta.persistence.*;   // Jakarta Persistence Query Language
import lombok.*;
import java.util.List;
import java.util.Objects;

//lombok does the getters and setters
@Setter
@Getter
@Entity // indicates a db
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")

public class Customer {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hibernate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "contact_lastname")
    private String contactLastName;

    @Column(name = "contact_firstname")
    private String contactFirstName;

    @Column(name = "phone")
    private String phone;

    @Column(name ="address_line1")
    private String addressLine1;

    @Column(name ="address_line2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "sales_rep_employee_id", insertable=false, updatable=false)  // makes it read-only   can only use a primitive if column is nullable
    private Integer salesRepEmployeeId;  // can return nulls, primitive int would have exploded with NULL

    // foreign key situation: any customers are mapped to a single employee
    // allow Hibernate to make the sql query: select e.* from customers c, employee e where c.sales_rep_employee_id = e.id
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "sales_rep_employee_id", nullable = true)
    private Employee employee;


    // foreign key situation: one customer has 0 to many orders. an order is for one and only one customer.
    // allow Hibernate to make the sql query: select o.* from orders o , customers c where o.customer_id = c.id
    @ToString.Exclude
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;


    @Column(name = "credit_limit", columnDefinition = "DECIMAL" )
    private Double creditLimit;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(customerName, customer.customerName);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, customerName);
    }

}
