package cz.topPeople.controller.admin;

import cz.topPeople.entity.Company;
import cz.topPeople.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin",method = RequestMethod.POST)
public class CompanyController {

    @Autowired
    private CompanyService companyService;

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


}
