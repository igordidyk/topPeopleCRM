package cz.topPeople.controller.admin;

import cz.topPeople.entity.CZ_ISCO;
import cz.topPeople.entity.Company;
import cz.topPeople.entity.ContactPerson;
import cz.topPeople.service.CompanyService;
import cz.topPeople.service.ContactPersonService;
import cz.topPeople.service.CziscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/admin", method = RequestMethod.POST)
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private ContactPersonService personService;
    @Autowired
    private CziscoService cziscoService;

    @GetMapping("/company")
    public String company(Model model) {
        model.addAttribute("companies", companyService.findAll());
        return "/admin/companyPage";
    }

    @PostMapping("/addCompany")
    public String addCompany(@RequestParam("nameCompany") String nameCompany,
                             @RequestParam("IC") String IC,
                             @RequestParam("contactAddress") String contactAddress,
                             @RequestParam("telephone") String telephone,
                             @RequestParam("CZ_NACE") String CZ_NACE,
                             @RequestParam("email") String email) {

        Company company = new Company(nameCompany, IC, contactAddress, telephone, CZ_NACE, email);
        companyService.save(company);
        return "redirect:/admin/company";
    }

    //    contactPersonWithCompany.jsp
    @GetMapping("/company/edit-{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("company", companyService.findOne(id));
        return "/admin/editCompany";
    }

    @PostMapping("/company/save")
    public String updateCompany(@RequestParam("nameCompany") String nameCompany,
                                @RequestParam("IC") String IC,
                                @RequestParam("contactAddress") String contactAddress,
                                @RequestParam("telephone") String telephone,
                                @RequestParam("email") String email,
                                @RequestParam("CZ_NACE") String CZ_NACE,
                                @RequestParam("company") int idCompany) {
        Company company = companyService.findOne(idCompany);
        System.out.println(company);
        company.setNameCompany(nameCompany);
        company.setIC(IC);
        company.setContactAddress(contactAddress);
        company.setTelephone(telephone);
        company.setEmail(email);
        company.setCZ_NACE(CZ_NACE);
        System.out.println(company);
        companyService.save(company);
        return "redirect:/admin/company";
    }


    @GetMapping("/company/contactPersonWithCompany-{id}")
    public String addContactPersonToCompany(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("company", companyService.findOne(id));
        return "/admin/contactPersonWithCompany";
    }

    @PostMapping("/company/addContactPerson")
    public String addContactPerson(Model model,
                                   @RequestParam("idCompany") int idCompany,
                                   @RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("position") String position,
                                   @RequestParam("email") String email,
                                   @RequestParam("telephone") String telephone) {

        Company company = companyService.findOne(idCompany);
        ContactPerson contactPerson = new ContactPerson(firstName, lastName, position, email, telephone);
//        personService.save(contactPerson);
        contactPerson.setCompany(company);
        personService.save(contactPerson);
//        System.out.println(contactPerson);

        List<ContactPerson> persons = personService.findAll();
        for (ContactPerson person : persons) {
            if (person.getFirstName().equals(contactPerson.getFirstName()) && person.getLastName().equals(contactPerson.getLastName()) && person.getEmail().equals(contactPerson.getEmail())) {
                model.addAttribute("key", "This  contact person is already exists");
            } else {
                contactPerson.setCompany(company);
                personService.save(contactPerson);
            }
        }
        return "redirect:/admin/company/contactPersonWithCompany-" + idCompany;
    }

    @GetMapping("/company/delete-{id}")
    public String deletePerson(@PathVariable("id") Integer id) {
        personService.delete(id);

        return "redirect:/admin/company";
    }


    @GetMapping("/company/czisco-{id}")
    public String createProject(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("company", companyService.findOne(id));
        model.addAttribute("ISCOList", cziscoService.findAll());
        return "/admin/cziscoWithCompany";
    }


    @PostMapping("/company/createISCO")
    public String createISCO(@RequestParam("czisco") String czisco, @RequestParam("kkov") String kkov,
                             @RequestParam("ENG_position") String ENG_position, @RequestParam("CZ_position") String CZ_position,
                             @RequestParam("numberOfVacancy") String numberOfVacancy, @RequestParam("CZ_text") String CZ_text,
                             @RequestParam("idCompany") int idCompany) {
        CZ_ISCO isco = new CZ_ISCO(czisco, kkov, ENG_position, CZ_position, numberOfVacancy, CZ_text);
        isco.setCompany(companyService.findOne(idCompany));
        cziscoService.save(isco);

        return "redirect:/admin/company/czisco-" + idCompany;
    }


    @GetMapping("/company/editPerson-{id}")
    public String editPerson(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("person", personService.findOne(id));

        return "/admin/editContactPerson";
    }

    @PostMapping("/company/editChanges")
    public String updateCompany( /*@RequestParam("idCompany") int idCompany,*/
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("position") String position,
                                 @RequestParam("email") String email,
                                 @RequestParam("telephone") String telephone,
                                 @RequestParam("idPerson") int idPerson) {
        ContactPerson person = personService.findOne(idPerson);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPosition(position);
        person.setEmail(email);
        person.setTelephone(telephone);
        personService.save(person);
        return "redirect:/admin/company/contactPersonWithCompany-" +idPerson;
    }
}


