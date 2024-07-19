package com.example.springboot.form;

import lombok.*;

@Getter
@Setter
@ToString

public class CreateOfficeFormBean {

    private Integer id;
    private String phone;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String territory;
    private String addressLine1;
    private String addressLine2;

}
