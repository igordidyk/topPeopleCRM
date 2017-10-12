package cz.topPeople.controller.admin;
import cz.topPeople.entity.Company;
import cz.topPeople.entity.GroupWithCandidates;
import cz.topPeople.entity.Project;
import cz.topPeople.service.CompanyService;
import cz.topPeople.service.GroupWithCandidatesService;
import cz.topPeople.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin", method = RequestMethod.POST)
public class ProjectController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private GroupWithCandidatesService groupService;

    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("companies", companyService.findAll());
//        model.addAttribute("projects", projectService.findAllProjectsOfCompany(id));
        return "/admin/projectsPage";
    }


    @GetMapping("/projects/createProject")
    public String createProject(@RequestParam("typeOfEmployment") String typeOfEmployment, @RequestParam("position") String position,
                                @RequestParam("schengenContractStarting") String schengenContractStarting, @RequestParam("ECStarting") String ECStarting,
                                @RequestParam("dateForMedicalDocs") String dateForMedicalDocs, @RequestParam("statusOfReceived") String statusOfReceived,
                                @RequestParam("processingTimePartner") String processingTimePartner, @RequestParam("gettingSignedDocuments") String gettingSignedDocuments,
                                @RequestParam("submissionDocumetns") String submissionDocumetns, @RequestParam("processingTimeUP") String processingTimeUP,
                                @RequestParam("pickingUpDocumentUA") String pickingUpDocumentUA, @RequestParam("applicationProcess") String applicationProcess,
                                @RequestParam("readyToGoToCZ") String readyToGoToCZ, @RequestParam("deviationToWorkingContract") String deviationToWorkingContract,
                                @RequestParam("company") int idCompany, @RequestParam("numberOfCandidatesForProject") String numberOfCandidatesForProject) {

        Project project = new Project(typeOfEmployment, position, schengenContractStarting, ECStarting, dateForMedicalDocs, statusOfReceived, processingTimePartner, gettingSignedDocuments, submissionDocumetns, processingTimeUP, pickingUpDocumentUA, applicationProcess, readyToGoToCZ, deviationToWorkingContract);
        project.setNumberOfCandidatesForProject(numberOfCandidatesForProject);
        Company company = companyService.findOne(idCompany);
        project.setCompany(company);
        projectService.save(project);
        return "redirect:/admin/projects";
    }

    @GetMapping("/projects/groups")
    public String groupForProject(Model model) {
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("candidates","");

        return "/admin/groupPage";
    }

    @PostMapping("/projects/groups/createGroup")
    public String createGroup(@RequestParam("nameGroup") String nameGroup,@RequestParam("numberOfCanditates") int numberOfCanditates,@RequestParam("project") int idProject) {

        Project project = projectService.findOne(idProject);
        GroupWithCandidates groupWithCandidates = new GroupWithCandidates(nameGroup,numberOfCanditates);
        groupWithCandidates.setProject(project);
        groupService.save(groupWithCandidates);

        return "redirect:/admin/projects/groups";
    }

}
