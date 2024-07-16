package com.example.springboot.form;

import lombok.*;

@Getter
@Setter
@ToString

public class CreateEmployeeFormBean {

    // private Integer id;      will auto-increment, can't get it from the web page yet
    private String email;
    private String lastName;
    private String firstName;
    private String extension;
    private String jobTitle;
    private Integer vacationHours;
    private String  profileImageUrl;
    private Integer officeId;
    private Integer reportsTo;

}


