package cz.topPeople.entity;


import javax.persistence.*;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String standardEduction;
    private String year;
    private String nameOfSchool;
    private String profesion;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Candidate candidate;

    public Education() {
    }

    public Education(String standardEduction, String year, String nameOfSchool, String profesion) {
        this.standardEduction = standardEduction;
        this.year = year;
        this.nameOfSchool = nameOfSchool;
        this.profesion = profesion;
    }



}
