package org.example.Band_Craft.entity;

import jakarta.persistence.*;   // Jakarta Persistence Query Language
import lombok.*;
import org.example.Band_Craft.Enums;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

//lombok does the getters and setters
@Setter
@Getter
@Entity //tells there's a db
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")

public class Users {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hibernate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    // TODO encryption
    @Column(name = "password")
    private String password;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_updated")
    private Date dateUpdated;

    // TODO FK to user_id or member_id
    @Column(name = "date_updated_id")
    private Integer dateUpdatedId;

}

