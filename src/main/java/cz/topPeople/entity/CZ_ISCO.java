package cz.topPeople.entity;

import javax.persistence.*;

@Entity
public class CZ_ISCO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int czisco;
    private String kkov;
    private String ENG_position;
    private String CZ_position;
    private String numberOfVacancy;
    private String CZ_text;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "cz_isco")
    private Employee employee;


    public CZ_ISCO() {
    }

    public CZ_ISCO(int czisco, String kkov, String ENG_position, String CZ_position, String numberOfVacancy, String CZ_text) {
        this.czisco = czisco;
        this.kkov = kkov;
        this.ENG_position = ENG_position;
        this.CZ_position = CZ_position;
        this.numberOfVacancy = numberOfVacancy;
        this.CZ_text = CZ_text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCzisco() {
        return czisco;
    }

    public void setCzisco(int czisco) {
        this.czisco = czisco;
    }

    public String getKkov() {
        return kkov;
    }

    public void setKkov(String kkov) {
        this.kkov = kkov;
    }

    public String getENG_position() {
        return ENG_position;
    }

    public void setENG_position(String ENG_position) {
        this.ENG_position = ENG_position;
    }

    public String getCZ_position() {
        return CZ_position;
    }

    public void setCZ_position(String CZ_position) {
        this.CZ_position = CZ_position;
    }

    public String getNumberOfVacancy() {
        return numberOfVacancy;
    }

    public void setNumberOfVacancy(String numberOfVacancy) {
        this.numberOfVacancy = numberOfVacancy;
    }

    public String getCZ_text() {
        return CZ_text;
    }

    public void setCZ_text(String CZ_text) {
        this.CZ_text = CZ_text;
    }

    @Override
    public String toString() {
        return "CZ_ISCO{" +
                "id=" + id +
                ", czisco=" + czisco +
                ", kkov='" + kkov + '\'' +
                ", ENG_position='" + ENG_position + '\'' +
                ", CZ_position='" + CZ_position + '\'' +
                ", numberOfVacancy='" + numberOfVacancy + '\'' +
                ", CZ_text='" + CZ_text + '\'' +
                '}';
    }
}
