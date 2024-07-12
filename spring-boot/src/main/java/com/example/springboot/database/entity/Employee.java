package com.example.springboot.database.entity;

import com.example.springboot.database.entity.Customer;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

//lombok does the getters and setters
@Setter
@Getter
@Entity // indicates a db
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")

public class Employee {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hibernate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    // foreign key situation: one employee can be assigned to serve many customers
        // select c.* from customers c, employees e where c.sales_rep_id = e.id
    @ToString.Exclude
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Customer> customers;

    @Column(name = "office_id")
    private Integer officeId;

    @Column(name = "lastname")
    private String lastName;  //if it matches db field name Hibernate figures this out

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "extension")
    private String extension;

    @Column(name = "email")
    private String email;

    @Column(name = "reports_to")
    private Integer reportsTo;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "vacation_hours")
    private Integer vacationHours;

    @Column(name = "profile_image_url")
    private String profileImageUrl;
}

