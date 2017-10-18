package cz.topPeople.controller.coordinator;

import cz.topPeople.entity.Address;
import cz.topPeople.entity.BirthPlace;
import cz.topPeople.entity.CZ_ISCO;
import cz.topPeople.entity.Candidate;
import cz.topPeople.service.CandidateService;
import cz.topPeople.service.CompanyService;
import cz.topPeople.service.CoordinatorService;
import cz.topPeople.service.CziscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/coordinator", method = RequestMethod.POST)
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CoordinatorService coordinatorService;
    @Autowired
    private CziscoService cziscoService;

    @GetMapping("/candidates")
    public String candidatePage(Model model) {
        model.addAttribute("cziscoList", cziscoService.findAll());
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


                               @RequestParam("passportNomer") String passportNomer,
                               @RequestParam("passportValidUntil") String passportValidUntil,
                               @RequestParam("issuedByAuthority") String issuedByAuthority,
                               @RequestParam("telephone") String telephone,
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
                               @RequestParam("position") int position,
                               @RequestParam("coordinator") String coordinator) {
        Candidate candidate = new Candidate(name,surname,gender,nationality,dateOfBirth,marriedStatus,currentOccupation,
                                            telephone,email,passportNomer,passportValidUntil,issuedByAuthority,phase,status,
                                            receivedOrder,schengen,workingAgreement,workingAgree,confirmationOfLivingPlace,
                                            beginWorkingContract,endWorkingContract,schengenTrialPeriod,realStartingOfSchengen,multiVisa,
                                            ECBegin,ECEnd,ECTrialPeriod,expectedStartingAtCompany,duration,presentedToCompany,
                                            ministryOfForeignAffairs,interviewAtConsulate,pickingUpTheVISA,registrationAtLocalOffice,
                                            startingToWork,receivingEmploymentCard,comments);

        Address address = new Address(country, region, city, postIndex, adressStreet, numberOfHouse);
        BirthPlace place = new BirthPlace(countryOfBirth, birthPlace, street, cityOrVillage, ZIP);

        candidate.setAddress(address);
        candidate.setBirthPlace(place);
        candidate.setCoordinator(coordinatorService.findByName(coordinator));
        System.out.println(coordinatorService.findByName(coordinator));
        CZ_ISCO isco = cziscoService.findOne(position);
        System.out.println(isco);
        System.out.println(isco.getENG_position());
        System.out.println();
        candidate.setPosition(isco.getENG_position());
        candidateService.save(candidate);
//        String eng_position = isco.getENG_position();

        return "redirect:/coordinator/candidates";
    }

}
