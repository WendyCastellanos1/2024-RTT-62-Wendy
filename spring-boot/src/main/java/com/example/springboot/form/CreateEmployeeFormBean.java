package com.example.springboot.form;

import lombok.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString

public class CreateEmployeeFormBean {

    // JSR-303 specification (what these annotations are called...for validation process..created by Hibernate people orignally to be done on entity, but entity was too late of a check, better before controller!

    // this field is ONLY set when user calls the /employee/edit URL and gives a valid employee id
    // it's our flag: if null, then *create*, if not null, then *edit*
    // fyi, for troubleshooting, Eric called this employeeId
     private Integer id;      // the employee's id will auto-increment, can't get it from the web page yet

    @Length(max=100, message = "Email must be less than 100 characters")
    @NotEmpty(message="Email is required.")
    @Email(message="This must be a valid email")
    private String email;

    @Length(max = 50, message = "Last Name must be less than 50 characters")
    @NotEmpty(message = "Last Name is required.")
    private String lastName;

    //@Pattern(regexp="[a-zA-Z]+", message = "First Name must have characters only.")
    @Length(max = 50, message = "First Name must be less than 50 characters")
    @NotEmpty(message = "First Name is required.")
    private String firstName;

    private String extension;
    private String jobTitle;
    private Integer vacationHours;
    private String  profileImageUrl;
    private Integer officeId;
    private Integer reportsTo;

}


