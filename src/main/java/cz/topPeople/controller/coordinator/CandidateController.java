package cz.topPeople.controller.coordinator;

import cz.topPeople.entity.*;
import cz.topPeople.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping(value = "/coordinator", method = RequestMethod.POST)
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CoordinatorService coordinatorService;
    @Autowired
    private CziscoService cziscoService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private EducationService educationService;

    @GetMapping("/candidates")
    public String candidatePage(Model model, Principal principal) {
        model.addAttribute("key", principal.getName());

        model.addAttribute("cziscoList", cziscoService.findAll());
        model.addAttribute("candidates", candidateService.findAll());
        return "/coordinator/candidatesPage";
    }

    @PostMapping("/candidates/addCandidate")
    public String addCandidate(@RequestParam("name") String name,
                               @RequestParam("surname") String surname,
                               @RequestParam("gender") String gender,
                               @RequestParam("nationality") String nationality,
                               @RequestParam("dateOfBirth") String dateOfBirth,
                               @RequestParam("marriedStatus") String marriedStatus,
                               @RequestParam("currentOccupation") String currentOccupation,
                               @RequestParam("telephone") String telephone,
                               @RequestParam("email") String email,
                               @RequestParam("position") int position,

                               @RequestParam("passportNomer") String passportNomer,
                               @RequestParam("passportValidUntil") String passportValidUntil,
                               @RequestParam("issuedByAuthority") String issuedByAuthority,
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

                               @RequestParam("comments") String comments,

                               @RequestParam("country") String country,
                               @RequestParam("region") String region,
                               @RequestParam("city") String city,
                               @RequestParam("postIndex") String postIndex,
                               @RequestParam("adressStreet") String adressStreet,
                               @RequestParam("numberOfHouse") String numberOfHouse,

                               @RequestParam("countryOfBirth") String countryOfBirth,
                               @RequestParam("birthPlace") String birthPlace,
                               @RequestParam("street") String street,
                               @RequestParam("cityOrVillage") String cityOrVillage,
                               @RequestParam("zip") String ZIP,

                               @RequestParam("coordinator") String coordinator) {
        Candidate candidate = new Candidate(name, surname, gender, nationality, dateOfBirth, marriedStatus, currentOccupation,
                telephone, email, passportNomer, passportValidUntil, issuedByAuthority, phase, status,
                receivedOrder, schengen, workingAgreement, workingAgree, confirmationOfLivingPlace,
                beginWorkingContract, endWorkingContract, schengenTrialPeriod, realStartingOfSchengen, multiVisa,
                ECBegin, ECEnd, ECTrialPeriod, expectedStartingAtCompany, duration, presentedToCompany,
                ministryOfForeignAffairs, interviewAtConsulate, pickingUpTheVISA, registrationAtLocalOffice,
                startingToWork, receivingEmploymentCard, comments);

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

    @GetMapping("/candidates/candidate-{id}")
    public String candidateDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("candidate", candidateService.findOne(id));
        return "/coordinator/candidateDetails";
    }

    @PostMapping("/candidates/addLanguage")
    public String addLanguage(@RequestParam("lang") String lang, @RequestParam("level") String level,
                              @RequestParam("candidate") int idCandidate) {
        Language language = new Language(lang, level);
        language.setCandidate(candidateService.findOne(idCandidate));
        languageService.save(language);
        return "redirect:/coordinator/candidates/candidate-" + idCandidate;
    }

    @PostMapping("/candidates/addEducation")
    public String addEducation(@RequestParam("standardEduction") String standardEduction, @RequestParam("year") String year,
                               @RequestParam("nameOfSchool") String nameOfSchool, @RequestParam("profesion") String profesion,
                               @RequestParam("candidate") int idCandidate) {

        Education education = new Education(standardEduction, year, nameOfSchool, profesion);

        education.setCandidate(candidateService.findOne(idCandidate));
        educationService.save(education);
        return "redirect:/coordinator/candidates/candidate-" + idCandidate;
    }


}
