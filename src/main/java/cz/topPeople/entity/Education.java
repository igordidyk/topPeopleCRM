package cz.topPeople.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude = "candidate")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String standardEduction;
    private String year;
    private String nameOfSchool;
    private String profesion;


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Candidate candidate;

    public Education(String standardEduction, String year, String nameOfSchool, String profesion) {
        this.standardEduction = standardEduction;
        this.year = year;
        this.nameOfSchool = nameOfSchool;
        this.profesion = profesion;
    }

}
