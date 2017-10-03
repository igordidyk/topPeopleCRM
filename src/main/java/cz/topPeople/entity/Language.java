package cz.topPeople.entity;

import javax.persistence.*;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lang;
    private String level;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Candidate candidate;

    public Language() {
    }


}
