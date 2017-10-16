package cz.topPeople.controller.coordinator;

import cz.topPeople.entity.Candidate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/coordinator", method = RequestMethod.POST)
public class CandidateController {

    @GetMapping("/candidates")
    public String candidatePage() {

        return "/coordinator/candidatesPage";
    }

    @PostMapping("/candidates/addCandidate")
    public String addCandidate(@RequestParam("name") String name,
                               @RequestParam("surname") String surname,
                               @RequestParam("gender") String gender,
                               @RequestParam("nationality") String nationality,
                               @RequestParam("dateOfBirth") String dateOfBirth,

                               @RequestParam("countryOfBirth") String countryOfBirth,
                               @RequestParam("birthPlace") String birthPlace,
                               @RequestParam("street") String street,
                               @RequestParam("cityOrVillage") String cityOrVillage,
                               @RequestParam("zip") String ZIP,

                               @RequestParam("country") String country,
                               @RequestParam("region") String region,
                               @RequestParam("city") String city,
                               @RequestParam("postIndex") String postIndex,
                               @RequestParam("adressStreet") String adressStreet,
                               @RequestParam("numberOfHouse") String numberOfHouse,

                               @RequestParam("lang") String lang,
                               @RequestParam("level") String level,

                               @RequestParam("standardEduction") String standardEduction,
                               @RequestParam("years") String years,
                               @RequestParam("nameOfSchool") String nameOfSchool,
                               @RequestParam("profesion") String profesion,

                               @RequestParam("passportNomer") String passportNomer,
                               @RequestParam("passportValidUntil") String passportValidUntil,
                               @RequestParam("issuedByAuthority") String issuedByAuthority,
                               @RequestParam("telephone") String telephone,
                               @RequestParam("position") String position,
                               @RequestParam("email") String email,
                               @RequestParam("phase") int phase,
                               @RequestParam("status") int status,

                               @RequestParam("receivedOrder") String receivedOrder,
                               @RequestParam("schengen") String schengen,
                               @RequestParam("workingAgreement") String workingAgreement,
                               @RequestParam("workingAgree") String workingAgree,
                               @RequestParam("confirmationOfLivingPlace") String confirmationOfLivingPlace,
                               @RequestParam("beginWorkingContract") String beginWorkingContract,
                               @RequestParam("endWorkingContract") String endWorkingContract,
                               @RequestParam("schengenTrialPeriod") String schengenTrialPeriod,
                               @RequestParam("realStartingOfSchengen") String realStartingOfSchengen,
                               @RequestParam("multiVisa") String multiVisa,
                               @RequestParam("ECBegin") String ECBegin,
                               @RequestParam("ECEnd") String ECEnd,
                               @RequestParam("ECTrialPeriod") String ECTrialPeriod,
                               @RequestParam("expectedStartingAtCompany") String expectedStartingAtCompany,
                               @RequestParam("duration") String duration,
                               @RequestParam("presentedToCompany") String presentedToCompany,
                               @RequestParam("ministryOfForeignAffairs") String ministryOfForeignAffairs,
                               @RequestParam("interviewAtConsulate") String interviewAtConsulate,
                               @RequestParam("pickingUpTheVISA") String pickingUpTheVISA,
                               @RequestParam("registrationAtLocalOffice") String registrationAtLocalOffice,
                               @RequestParam("startingToWork") String startingToWork,
                               @RequestParam("receivingEmploymentCard") String receivingEmploymentCard,
                               @RequestParam("marriedStatus") String marriedStatus,
                               @RequestParam("currentOccupation") String currentOccupation,
                               @RequestParam("comments") String comments,
                               @RequestParam("coordinator") String coordinator) {
        Candidate candidate = new Candidate(name,surname,gender,nationality,dateOfBirth,marriedStatus,currentOccupation,
                                            telephone,email,position,passportNomer,passportValidUntil,issuedByAuthority,phase,status,
                                            receivedOrder,schengen,workingAgreement,workingAgree,confirmationOfLivingPlace,
                                            beginWorkingContract,endWorkingContract,schengenTrialPeriod,realStartingOfSchengen,multiVisa,
                                            ECBegin,ECEnd,ECTrialPeriod,expectedStartingAtCompany,duration,presentedToCompany,
                                            ministryOfForeignAffairs,interviewAtConsulate,pickingUpTheVISA,registrationAtLocalOffice,
                                            startingToWork,receivingEmploymentCard,comments);



        return "redirect:/candidates";
    }

}
