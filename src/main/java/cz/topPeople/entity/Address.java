package cz.topPeople.entity;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String country;
    private String region;
    private String city;
    private String postIndex;
    private String street;
    private String numberOfHouse;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "address")
    private Candidate candidate;

    public Address() {
    }


}
