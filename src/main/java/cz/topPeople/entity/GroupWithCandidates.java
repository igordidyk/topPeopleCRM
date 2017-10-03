package cz.topPeople.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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

    public GroupWithCandidates() {
    }

    public GroupWithCandidates(String nameGroup, int numberOfCanditates) {
        this.nameGroup = nameGroup;
        this.numberOfCanditates = numberOfCanditates;
    }



    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public int getNumberOfCanditates() {
        return numberOfCanditates;
    }

    public void setNumberOfCanditates(int numberOfCanditates) {
        this.numberOfCanditates = numberOfCanditates;
    }


    @Override
    public String toString() {
        return "GroupWithCandidates{" +
                "id=" + id +
                ", nameGroup='" + nameGroup + '\'' +
                ", numberOfCanditates=" + numberOfCanditates +
                '}';
    }
}
