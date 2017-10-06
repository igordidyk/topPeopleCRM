package cz.topPeople.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class ContactPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String telephone;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Company company;


    public ContactPerson() {
    }

    public ContactPerson(String firstName, String lastName, String position, String email, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
    }

    public ContactPerson(String firstName, String lastName, String position, String email, String telephone, Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.company = company;
    }


    @Override
    public String toString() {
        return "ContactPerson{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
