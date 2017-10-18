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

    public Address(String country, String region, String city, String postIndex, String street, String numberOfHouse) {
        this.country = country;
        this.region = region;
        this.city = city;
        this.postIndex = postIndex;
        this.street = street;
        this.numberOfHouse = numberOfHouse;
    }
}
