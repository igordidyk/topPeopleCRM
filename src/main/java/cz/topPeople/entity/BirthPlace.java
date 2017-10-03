package cz.topPeople.entity;

import javax.persistence.*;

@Entity
public class BirthPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String countryOfBirth;
    private String birthPlace;
    private String street;
    private String cityOrVillage;
    private String postIndex;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "birthPlace")
    private Candidate candidate;

    public BirthPlace() {
    }



}
