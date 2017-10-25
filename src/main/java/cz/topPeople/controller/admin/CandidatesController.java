package cz.topPeople.controller.admin;

import cz.topPeople.entity.Candidate;
import cz.topPeople.entity.Education;
import cz.topPeople.entity.Language;
import cz.topPeople.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin" , method = RequestMethod.POST)
public class CandidatesController {
    @Autowired
    CandidateService candidateService;
    @Autowired
    EducationService educationService;
    @Autowired
    LanguageService languageService;
    @Autowired
    CziscoService cziscoService;
    @Autowired
    CoordinatorService coordinatorService;

    @GetMapping("/allCandidates")
    public String allCandidates(Model model) {
        List<Candidate> candidates = candidateService.findAll();
        System.out.println(candidates);
        model.addAttribute("candidates", candidates);
        return "admin/allCandidates";
    }

    @GetMapping("/allCandidates/candidate-{id}")
    public String candidateDetails(@PathVariable("id") int id, Model model) {
        model.addAttribute("candidate", candidateService.findByLanguages(id));
        return "admin/candidateDetails";
    }

    @GetMapping("/deleteCandidate/{id}")
    public String deleteCandidate(@PathVariable("id") int id) {
        candidateService.delete(id);
        return "redirect:/admin/allCandidates";
    }

    @GetMapping("/editCandidate/{id}")
    public String editCandidate(@PathVariable("id") int id,Model model) {
        Candidate one = candidateService.findOne(id);
        model.addAttribute("candidate", one);
        model.addAttribute("cziscoList",cziscoService.findAll());
        model.addAttribute("coordinators",coordinatorService.findAll());
        return "admin/editCandidatePage";
    }

    @PostMapping("/candidate/save")
    public String saveCandidate(@RequestParam("id") int id,
                                @RequestParam("name") String name,
                                @RequestParam("surname") String surname,
                                @RequestParam("gender") String gender,
                                @RequestParam("nationality") String nationality,
                                @RequestParam("dateOfBirth") String dateOfBirth,

                                @RequestParam("countryOfBirth") String countryOfBirth,
                                @RequestParam("birthPlace") String birthPlace,
                                @RequestParam("street") String street,
                                @RequestParam("cityOrVillage") String cityOrVillage,
//                                @RequestParam("zip") String ZIP,

                                @RequestParam("country") String country,
                                @RequestParam("region") String region,
                                @RequestParam("city") String city,
                                @RequestParam("addrPostIndex") String addrPostIndex,
                                @RequestParam("birthPostIndex") String birthPostIndex,
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
                                @RequestParam("position") int cziscoId) {
        Candidate one = candidateService.findOne(id);
        one.setName(name);
        one.setSurname(surname);
        one.setGender(gender);
        one.setNationality(nationality);
        one.setDateOfBirth(dateOfBirth);
        one.setMarriedStatus(marriedStatus);
        one.setCurrentOccupation(currentOccupation);
        one.setTelephone(telephone);
        one.setEmail(email);
        one.setPosition(cziscoService.findOne(cziscoId).getENG_position());
        one.setPassportNumber(passportNomer);
        one.setPassportValidUntil(passportValidUntil);
        one.setIssuedByAuthority(issuedByAuthority);
        one.setPhase(phase);
        one.setStatus(status);
        one.setReceivedOrder(receivedOrder);
        one.setSchengen(schengen);
        one.setWorkingAgreement(workingAgreement);
        one.setWorkingAgree(workingAgree);
        one.setConfirmationOfLivingPlace(confirmationOfLivingPlace);
        one.setBeginWorkingContract(beginWorkingContract);
        one.setEndWorkingContract(endWorkingContract);
        one.setSchengenTrialPeriod(schengenTrialPeriod);
        one.setRealStartingOfSchengen(realStartingOfSchengen);
        one.setMultiVisa(multiVisa);
        one.setECBegin(ECBegin);
        one.setECEnd(ECEnd);
        one.setECTrialPeriod(ECTrialPeriod);
        one.setExpectedStartingAtCompany(expectedStartingAtCompany);
        one.setDuration(duration);
        one.setPresentedToCompany(presentedToCompany);
        one.setMinistryOfForeignAffairs(ministryOfForeignAffairs);
        one.setInterviewAtConsulate(interviewAtConsulate);
        one.setPickingUpTheVISA(pickingUpTheVISA);
        one.setRegistrationAtLocalOffice(registrationAtLocalOffice);
        one.setStartingToWork(startingToWork);
        one.setReceivingEmploymentCard(receivingEmploymentCard);
        one.setComments(comments);

        one.getAddress().setCountry(country);
        one.getAddress().setRegion(region);
        one.getAddress().setPostIndex(addrPostIndex);
        one.getAddress().setStreet(adressStreet);
        one.getAddress().setNumberOfHouse(numberOfHouse);

        one.getBirthPlace().setCountryOfBirth(countryOfBirth);
        one.getBirthPlace().setBirthPlace(birthPlace);
        one.getBirthPlace().setStreet(street);
        one.getBirthPlace().setCityOrVillage(cityOrVillage);
        one.getBirthPlace().setPostIndex(birthPostIndex);

        candidateService.save(one);
        return "redirect:/admin/editCandidate/"+id;
    }


}
