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
    private Employee employee;

    public Language() {
    }

    public Language(String lang, String level) {
        this.lang = lang;
        this.level = level;
    }

    public Language(String lang, String level, Employee employee) {
        this.lang = lang;
        this.level = level;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", lang='" + lang + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
