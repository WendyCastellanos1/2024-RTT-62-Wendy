package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

//lombok does the getters and setters for us; I don't have to type or generate them.
@Setter
@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")

public class Employee {
    //look at table to see fields
    @Id //this identifies the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hiberate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    //do (below) for each foreign key
    //s select c.* from customers c, employees e where....
    @ToString.Exclude
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Customer> customers;

    @Column(name = "office_id")
    private Integer officeId;

    @Column(name = "lastname")
    private String lastname;  //if it matches db field name Hibernate figures this out

    @Column(name = "firstname")
    private String firstname;

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
