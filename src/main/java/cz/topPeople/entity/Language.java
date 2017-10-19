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
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lang;
    private String level;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Candidate candidate;

    public Language(String lang, String level) {
        this.lang = lang;
        this.level = level;
    }
}
