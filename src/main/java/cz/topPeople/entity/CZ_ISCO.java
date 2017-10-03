package cz.topPeople.entity;

import javax.persistence.*;

@Entity
public class CZ_ISCO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int czisco;
    private String kkov;
    private String ENG_position;
    private String CZ_position;
    private String numberOfVacancy;
    private String CZ_text;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Company company;






}
