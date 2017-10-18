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
@ToString(exclude = "company")
public class CZ_ISCO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String czisco;
    private String kkov;
    private String ENG_position;
    private String CZ_position;
    private String numberOfVacancy;
    private String CZ_text;


    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Company company;

    public CZ_ISCO(String czisco, String kkov, String ENG_position, String CZ_position, String numberOfVacancy, String CZ_text) {
        this.czisco = czisco;
        this.kkov = kkov;
        this.ENG_position = ENG_position;
        this.CZ_position = CZ_position;
        this.numberOfVacancy = numberOfVacancy;
        this.CZ_text = CZ_text;
    }


}
