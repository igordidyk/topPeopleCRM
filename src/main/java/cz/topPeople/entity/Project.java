package cz.topPeople.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeOfEmployment;
    private String position;
    private String SchengenContractStarting;
    private String ECStarting;
    private String dateForMedicalDocs;
    private String statusOfReceived;
    private String processingTimePartner;
    private String gettingSignedDocuments;
    private String submissionDocumetns;
    private String processingTimeUP;
    private String pickingUpDocumentUA;
    private String applicationProcess;
    private String readyToGoToCZ;
    private String deviationToWorkingContract;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "project")
    private List<GroupWithCandidates> groups = new ArrayList<>();

    public Project() {
    }


}
