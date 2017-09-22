package cz.topPeople.entity;


import javax.persistence.*;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String standardEduction;
    private String year;
    private String nameOfSchool;
    private String profesion;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Employee employee;

    public Education() {
    }

    public Education(String standardEduction, String year, String nameOfSchool, String profesion) {
        this.standardEduction = standardEduction;
        this.year = year;
        this.nameOfSchool = nameOfSchool;
        this.profesion = profesion;
    }

    public Education(String standardEduction, String year, String nameOfSchool, String profesion, Employee employee) {
        this.standardEduction = standardEduction;
        this.year = year;
        this.nameOfSchool = nameOfSchool;
        this.profesion = profesion;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStandardEduction() {
        return standardEduction;
    }

    public void setStandardEduction(String standardEduction) {
        this.standardEduction = standardEduction;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNameOfSchool() {
        return nameOfSchool;
    }

    public void setNameOfSchool(String nameOfSchool) {
        this.nameOfSchool = nameOfSchool;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", standardEduction='" + standardEduction + '\'' +
                ", year='" + year + '\'' +
                ", nameOfSchool='" + nameOfSchool + '\'' +
                ", profesion='" + profesion + '\'' +
                '}';
    }

}
