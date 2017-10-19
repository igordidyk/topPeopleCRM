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
@ToString(exclude ={"address","birthPlace","coordinator","groupWithCandidates","educations","languages"} )
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String gender;
    private String nationality;
    private String dateOfBirth;
    private String marriedStatus;
    private String currentOccupation;
    private String telephone;
    private String email;
    private String position;

    private String passportNumber;
    private String passportValidUntil;
    private String issuedByAuthority;
    private int phase;
    private int status;
    private String receivedOrder;
    private String schengen;
    private String workingAgreement;
    private String workingAgree;
    private String confirmationOfLivingPlace;
    private String beginWorkingContract;
    private String endWorkingContract;
    private String schengenTrialPeriod;
    private String realStartingOfSchengen;
    private String multiVisa;
    private String ECBegin;
    private String ECEnd;
    private String ECTrialPeriod;
    private String expectedStartingAtCompany;
    private String duration;
    private String presentedToCompany;
    private String ministryOfForeignAffairs;
    private String interviewAtConsulate;
    private String pickingUpTheVISA;
    private String registrationAtLocalOffice;
    private String startingToWork;
    private String receivingEmploymentCard;

    private String comments;


    public Candidate(String name, String surname, String gender, String nationality,
                     String dateOfBirth, String marriedStatus, String currentOccupation,
                     String telephone, String email/*, String position*/, String passportNumber,
                     String passportValidUntil, String issuedByAuthority, int phase,
                     int status, String receivedOrder, String schengen,
                     String workingAgreement, String workingAgree, String confirmationOfLivingPlace,
                     String beginWorkingContract, String endWorkingContract, String schengenTrialPeriod,
                     String realStartingOfSchengen, String multiVisa, String ECBegin, String ECEnd,
                     String ECTrialPeriod, String expectedStartingAtCompany, String duration,
                     String presentedToCompany, String ministryOfForeignAffairs, String interviewAtConsulate,
                     String pickingUpTheVISA, String registrationAtLocalOffice, String startingToWork,
                     String receivingEmploymentCard, String comments) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.marriedStatus = marriedStatus;
        this.currentOccupation = currentOccupation;
        this.telephone = telephone;
        this.email = email;
//        this.position = position;
        this.passportNumber = passportNumber;
        this.passportValidUntil = passportValidUntil;
        this.issuedByAuthority = issuedByAuthority;
        this.phase = phase;
        this.status = status;
        this.receivedOrder = receivedOrder;
        this.schengen = schengen;
        this.workingAgreement = workingAgreement;
        this.workingAgree = workingAgree;
        this.confirmationOfLivingPlace = confirmationOfLivingPlace;
        this.beginWorkingContract = beginWorkingContract;
        this.endWorkingContract = endWorkingContract;
        this.schengenTrialPeriod = schengenTrialPeriod;
        this.realStartingOfSchengen = realStartingOfSchengen;
        this.multiVisa = multiVisa;
        this.ECBegin = ECBegin;
        this.ECEnd = ECEnd;
        this.ECTrialPeriod = ECTrialPeriod;
        this.expectedStartingAtCompany = expectedStartingAtCompany;
        this.duration = duration;
        this.presentedToCompany = presentedToCompany;
        this.ministryOfForeignAffairs = ministryOfForeignAffairs;
        this.interviewAtConsulate = interviewAtConsulate;
        this.pickingUpTheVISA = pickingUpTheVISA;
        this.registrationAtLocalOffice = registrationAtLocalOffice;
        this.startingToWork = startingToWork;
        this.receivingEmploymentCard = receivingEmploymentCard;
        this.comments = comments;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private BirthPlace birthPlace;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Coordinator coordinator;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private GroupWithCandidates groupWithCandidates;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "candidate")
    private List<Education> educations = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "candidate")
    private List<Language> languages = new ArrayList<>();




}
