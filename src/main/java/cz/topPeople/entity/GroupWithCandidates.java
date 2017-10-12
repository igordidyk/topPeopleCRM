package cz.topPeople.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude = {"project","candidateList"})
public class GroupWithCandidates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameGroup;
    private int numberOfCanditates;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "groupWithCandidates")
    private List<Candidate> candidateList = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Project project;

    public GroupWithCandidates(String nameGroup, int numberOfCanditates) {
        this.nameGroup = nameGroup;
        this.numberOfCanditates = numberOfCanditates;
    }
}
