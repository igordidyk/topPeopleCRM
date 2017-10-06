package cz.topPeople.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
//@ToString
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

    public Company() {
    }

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

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", nameCompany='" + nameCompany + '\'' +
                ", IC='" + IC + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", CZ_NACE='" + CZ_NACE + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
