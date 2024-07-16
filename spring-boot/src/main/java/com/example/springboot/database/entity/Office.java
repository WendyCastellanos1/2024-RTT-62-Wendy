package com.example.springboot.database.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import  java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "offices")

public class Office {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hibernate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    @Column(name="city")
    private String city;

    @Column(name="phone")
    private String phone;

    @Column(name="address_line1")
    private String addressLine1;

    @Column(name="address_line2")
    private String addressLine2;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @Column(name="postalCode")
    private String postalCode;

    @Column(name="territory")
    private String territory;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return id == office.id && Objects.equals(city, office.city);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id, city);
    }

}
