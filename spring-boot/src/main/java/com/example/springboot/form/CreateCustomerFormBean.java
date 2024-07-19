package com.example.springboot.form;

import lombok.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString

public class CreateCustomerFormBean{

    //this field is for when *edit*
    private Integer id;

    @Pattern(regexp="[a-zA-Z]+", message = "Customer Name must have characters only.")
    @Length(max = 50, message = "Customer Name must be less than 50 characters")
    @NotEmpty(message = "Customer Name is required.")
    private String customerName;

    @Pattern(regexp="[a-zA-Z]+", message = "Contact Last Name must have characters only.")
    @Length(max = 50, message = "Contact Last Name must be less than 50 characters")
    @NotEmpty(message = "Contact Last Name is required.")
    private String contactLastName;

    @Pattern(regexp="[a-zA-Z]+", message = "First Name must have characters only.")
    @Length(max = 50, message = "First Name must be less than 50 characters")
    @NotEmpty(message = "First Name is required.")
    private String contactFirstName;

    @Length(max = 50, message = "Phone must be less than 50 characters")
    @NotEmpty(message = "Phone is required.")
    private String phone;

    @Length(max = 50, message = "Address Line 1 must be less than 50 characters")
    @NotEmpty(message = "Address Line 1 is required.")
    private String addressLine1;

    @Length(max = 50, message = "Address Line 2 must be less than 50 characters")
    private String addressLine2;

    @Pattern(regexp="[a-zA-Z]+", message = "City must have characters only.")
    @Length(max = 50, message = "City must be less than 50 characters")
    private String city;

   // @Pattern(regexp="[a-zA-Z]+", message = "State must have characters only.")
    //@Length(max = 50, message = "State must be less than 50 characters")
    private String state;

    @Length(max = 15, message = "Postal code must be less than 15 characters")
    private String postalCode;

    @Pattern(regexp="[a-zA-Z]+", message = "Country must have characters only.")
    @Length(max = 50, message = "Country must be less than 50 characters")
    @NotEmpty(message = "Country is required.")
    private String country;

    private Integer salesRepEmployeeId;

    private Double creditLimit;

}
