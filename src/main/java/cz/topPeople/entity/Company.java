package cz.topPeople.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude = {"persons","projects","iscoList"})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nameCompany;
    private String IC;
    private String contactAddress;
    private String telephone;
    private String CZ_NACE;
    private String email;


    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "company")
    private List<ContactPerson> persons = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "company")
    private List<Project> projects = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "company")
    private Set<CZ_ISCO> iscoList = new HashSet<>();


    public Company(String nameCompany, String IC, String contactAddress, String telephone, String CZ_NACE, String email) {
        this.nameCompany = nameCompany;
        this.IC = IC;
        this.contactAddress = contactAddress;
        this.telephone = telephone;
        this.CZ_NACE = CZ_NACE;
        this.email = email;
    }

    public Company(String nameCompany, String IC, String contactAddress, String telephone, String CZ_NACE, String email, List<ContactPerson> persons, List<Project> projects, Set<CZ_ISCO> iscoList) {
        this.nameCompany = nameCompany;
        this.IC = IC;
        this.contactAddress = contactAddress;
        this.telephone = telephone;
        this.CZ_NACE = CZ_NACE;
        this.email = email;
        this.persons = persons;
        this.projects = projects;
        this.iscoList = iscoList;
    }


}
