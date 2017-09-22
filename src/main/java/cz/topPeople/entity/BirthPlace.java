package cz.topPeople.entity;

import javax.persistence.*;

@Entity
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
    private Employee employee;

    public BirthPlace() {
    }

    public BirthPlace(String countryOfBirth, String birthPlace, String street, String cityOrVillage, String postIndex) {
        this.countryOfBirth = countryOfBirth;
        this.birthPlace = birthPlace;
        this.street = street;
        this.cityOrVillage = cityOrVillage;
        this.postIndex = postIndex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCityOrVillage() {
        return cityOrVillage;
    }

    public void setCityOrVillage(String cityOrVillage) {
        this.cityOrVillage = cityOrVillage;
    }

    public String getPostIndex() {
        return postIndex;
    }

    public void setPostIndex(String postIndex) {
        this.postIndex = postIndex;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "BirthPlace{" +
                "id=" + id +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", street='" + street + '\'' +
                ", cityOrVillage='" + cityOrVillage + '\'' +
                ", postIndex='" + postIndex + '\'' +
                '}';
    }
}
