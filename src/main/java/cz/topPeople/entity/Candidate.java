package cz.topPeople.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String gender;
    private String nationality;
    private String dateOfBirth;
    private String marriedStatus;
    private String currentOccupation;
    private String telephone;
    private String email;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BirthPlace birthPlace;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Coordinator coordinator;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private GroupWithCandidates groupWithCandidates;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidate")
    private List<Education> educations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidate")
    private List<Language> languages = new ArrayList<>();




}
