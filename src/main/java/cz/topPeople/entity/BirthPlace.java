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

    public BirthPlace(String countryOfBirth, String birthPlace, String street, String cityOrVillage, String postIndex) {
        this.countryOfBirth = countryOfBirth;
        this.birthPlace = birthPlace;
        this.street = street;
        this.cityOrVillage = cityOrVillage;
        this.postIndex = postIndex;
    }
}
