package org.example.Band_Craft.entity;

import jakarta.persistence.*;   // Jakarta Persistence Query Language
import lombok.*;
import java.util.Date;
import java.util.List;

//lombok does the getters and setters
@Setter
@Getter
@Entity //tells there's a db
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "members")

public class Member {

    @Id //this identifies the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hibernate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;  // if it matches db field name Hibernate figures this out

    @Column(name = "nickname")
    private String nickname;

    //gender
    //gender_comment

    @Column(name = "generation")
    private String generation;  // TODO make enum

   @Column(name = "phone_cell")
    private String phone_cell;

    @Column(name = "phone_alt")
    private String phone_alt;

    @Column(name = "email")
    private String email;

    @Column(name = "email_alt")
    private String email_alt;

    @Column(name = "is_active")
    private boolean is_active;

    @Column(name = "date_returning")
    private Date date_returning;

    @Column(name = "speaks_spanish")
    private Boolean speaks_Spanish;

    @Column(name = "speaks_portuguese")
    private Boolean speaks_Portuguese;

    @Column( name = "speaks_other_comment")
    private Boolean speaks_other_comment;

    @Column(name = "is_adult_on_create")
    private Boolean is_adult_on_create;

    @Column(name = "is_banned")
    private Boolean is_banned;

    @Column(name = "comments")
    private String comments;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    //date_created TODO or not do
    //date_updated TODO or not do
    //last_updated_id TODO add FK
}
