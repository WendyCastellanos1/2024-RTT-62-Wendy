package org.example.Band_Craft.entity;

// This class represents a junction table between members and talents

import jakarta.persistence.*;   // Jakarta Persistence Query Language
import lombok.*;
import org.example.Band_Craft.Enums;
import java.util.List;

//lombok does the getters and setters
@Setter
@Getter
@Entity //tells there's a db
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member_talents")

public class MemberTalent {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this is indicating to Hibernate that it's doing an auto-increment
    @Column(name = "id")
    private Integer id;

    // TODO: Make FK
    @Column(name = "member_id")                         //  required
    private Integer memberId;

    // TODO: Make FK
    @Column(name = "talent_id")                         // required
    private Integer talentId;

    @Column(name = "preference_ranking")                // required  (start it at 1, or don't, but consider...)
    private Integer preferenceRanking;

    @Column(name = "can_improv")
    private Boolean canImprov;                          // optional

    @Column(name = "reads_chord_charts")
    private Boolean readsChordCharts;                   // optional

    @Column(name = "key1_preferred")
    @Enumerated(EnumType.STRING)
    private Enums.MusicalKeys musicalKey1_Preferred;    // optional

    @Column(name = "key2_preferred")
    @Enumerated(EnumType.STRING)
    private Enums.MusicalKeys musicalKey2_Preferred;    // optional

    @Column(name = "key1_harmony")
    @Enumerated(EnumType.STRING)
    private Enums.MusicalKeys musicalKey1_Harmony;

    @Column(name = "key2_harmony")                      // optional
    @Enumerated(EnumType.STRING)
    private Enums.MusicalKeys musicalKey2_Harmony;

    @Column(name = "key1_avoid")
    @Enumerated(EnumType.STRING)
    private Enums.MusicalKeys musicalKey1_Avoid;         // optional

    @Column(name = "key2_avoid")
    @Enumerated(EnumType.STRING)
    private Enums.MusicalKeys musicalKey2_Avoid;        // optional

    @Column(name = "has_processor")
    private Boolean hasProcessor;                       // optional

    @Column(name = "processor_comments")
    private String processorComments;                   // optional, default is NULL in db

    @Column(name = "needs_loaner_instrument")
    private Boolean needsLoanerInstrument;              // optional
}
