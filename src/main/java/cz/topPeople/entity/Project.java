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
@ToString(exclude = {"company","groups"})
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeOfEmployment;
    private String position;
    private String schengenContractStarting;
    private String ECStarting;
    private String dateForMedicalDocs;
    private String statusOfReceived;
    private String processingTimePartner;
    private String gettingSignedDocuments;
    private String submissionDocuments;
    private String processingTimeUP;
    private String pickingUpDocumentUA;
    private String applicationProcess;
    private String readyToGoToCZ;
    private String deviationToWorkingContract;
    private int numberOfCandidatesForProject;
    private int numberOfFreeVacancy=numberOfCandidatesForProject;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Company company;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "project")
    private List<GroupWithCandidates> groups = new ArrayList<>();

    public Project(String typeOfEmployment, String position, String schengenContractStarting, String ECStarting,
                   String dateForMedicalDocs, String statusOfReceived, String processingTimePartner,
                   String gettingSignedDocuments, String submissionDocuments, String processingTimeUP,
                   String pickingUpDocumentUA, String applicationProcess, String readyToGoToCZ,
                   String deviationToWorkingContract, int numberOfCandidatesForProject) {
        this.typeOfEmployment = typeOfEmployment;
        this.position = position;
        this.schengenContractStarting = schengenContractStarting;
        this.ECStarting = ECStarting;
        this.dateForMedicalDocs = dateForMedicalDocs;
        this.statusOfReceived = statusOfReceived;
        this.processingTimePartner = processingTimePartner;
        this.gettingSignedDocuments = gettingSignedDocuments;
        this.submissionDocuments = submissionDocuments;
        this.processingTimeUP = processingTimeUP;
        this.pickingUpDocumentUA = pickingUpDocumentUA;
        this.applicationProcess = applicationProcess;
        this.readyToGoToCZ = readyToGoToCZ;
        this.deviationToWorkingContract = deviationToWorkingContract;
        this.numberOfCandidatesForProject = numberOfCandidatesForProject;
        this.numberOfFreeVacancy=this.numberOfCandidatesForProject;
    }
}
