package com.example.springboot.form;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateAccountFormBean {

    private Integer id;

    @Length(max=150, message = "Email must be less than 150 characters")
    @NotEmpty
    private String email;

    @Length(max=100, message = "Email must be less than 150 characters")
    @NotEmpty
    private String password;

}
