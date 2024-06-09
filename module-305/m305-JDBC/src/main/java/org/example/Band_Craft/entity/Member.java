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
@Table(name = "members")

public class Member {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hibernate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    // FK
    @ToString.Exclude
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MemberTalent> memberTalents;

    @Column(name = "first_name")        // required
    private String firstName;

    @Column(name = "last_name")         // required
    private String lastName;            // if it matches db field name Hibernate figures this out

    @Column(name = "nickname")          // optional
    private String nickname;

    @Column(name = "gender")             // required (because some events are only for women, for example)
    private String gender;

    @Column(name = "gender_comment")     // optional, field available to any gender choice
    private String genderComment;

    // TODO Correct? I incorporated the enum type directly.
    @Column(name="generation")
    @Enumerated(EnumType.STRING)
    private Enums.Generation generation;   // some answer required, though decline is an answer; exists bc some events benefit from generation-specific knowledge
        //to replace this:
        //    @Column(name = "generation")
        //    private String generation;

   @Column(name = "phone_cell")         // required for texting, allow bogus numbers in case someone doesn't have a cell
    private String phone_cell;

    @Column(name = "phone_alt")             // optional
    private String phone_alt;

    @Column(name = "email")                 // required because band emails go out with links to songs, etc.
    private String email;

    @Column(name = "email_alt")             // optional, but encouraged!
    private String email_alt;               //optional

    @Column(name = "registration_status")
    @Enumerated(EnumType.STRING)
    private Enums.RegistrationStatus registrationStatus;

    @Column(name = "is_active")             // leader sets this internally when approved
   // some answer required, though decline is an answer; exists bc some events benefit from generation-specific knowledg
    private Boolean is_active;              // defaults to false (0)

    @Column(name = "date_returning")        //indicates return date for person going on hiatus
    private Date date_returning;            // db defaults to Null

    @Column(name = "speaks_spanish")        //  TODO: note that *enum Language* exists for whatever use
    private Boolean speaks_Spanish;         // db defaults to false (0)

    @Column(name = "speaks_portuguese")     // TODO: note that *enum Language* exists
    private Boolean speaks_Portuguese;      // db defaults to false (0)

    @Column(name = "speaks_other")          // TODO: note that *enum Language* exists
    private Boolean speaks_Other;

    @Column( name = "speaks_other_comment")  // free form entry by member regarding other languages
    private Boolean speaks_other_comment;   // db defaults to false (0)

    @Column(name = "is_adult_on_create")    // db defaults to false (0)
    private Boolean is_adult_on_create;

    @Column(name = "is_banned")              // only a leader can overturn the ban
    private Boolean is_banned;               // db defaults to -1

    @Column(name = "bio")              // optional, member makes their own bio here when they join
    private String bio;                // db defaults to null

    @Column(name = "profile_image_url")     // TODO: evaluate if we should store a photo; how to upload, etc.
    private String profileImageUrl;         // TODO: put a *default URL* for a generic image in the db

    // TODO: format to get datetime
    //date_created
    @Column(name = "date_created")  // required
    private Date dateCreated;

    // TODO: format to get datetime
    @Column(name = "date_updated")   // defaults to NULL in db if not sent, e.g. not an update
    private Date dateUpdated;

    // TODO
    // last_updated_id
    // FK on last_updated_id TODO: Does this self-join work?
    // select m.id from members m, members mm where m.id = mm.last_updated_id;  // defaults to -1
//    @ManyToOne(cascade={CascadeType.ALL})
//    @JoinColumn(name="last_updated_id")
//    private Member leader;
//
//    @OneToMany(mappedBy="leader")
//    private Set<Member> subordinates = new HashSet<Member>();
}
