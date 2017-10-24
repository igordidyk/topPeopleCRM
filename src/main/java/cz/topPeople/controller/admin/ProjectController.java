package cz.topPeople.controller.admin;

import cz.topPeople.entity.Candidate;
import cz.topPeople.entity.Company;
import cz.topPeople.entity.GroupWithCandidates;
import cz.topPeople.entity.Project;
import cz.topPeople.service.CandidateService;
import cz.topPeople.service.CompanyService;
import cz.topPeople.service.GroupWithCandidatesService;
import cz.topPeople.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/admin", method = RequestMethod.POST)
public class ProjectController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private GroupWithCandidatesService groupService;
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/projects")
    public String projects(Model model, @RequestParam(value = "idCompany", required = false, defaultValue = "0") int idCompany) {
        if (idCompany != 0) {
            model.addAttribute("projects", projectService.findAllProjectsOfCompany(idCompany));
        }
        model.addAttribute("companies", companyService.findAll());
        return "/admin/projectsPage";
    }


    @GetMapping("/projects/createProject")
    public String createProject(@RequestParam("typeOfEmployment") String typeOfEmployment, @RequestParam("position") String position,
                                @RequestParam("schengenContractStarting") String schengenContractStarting, @RequestParam("ECStarting") String ECStarting,
                                @RequestParam("dateForMedicalDocs") String dateForMedicalDocs, @RequestParam("statusOfReceived") String statusOfReceived,
                                @RequestParam("processingTimePartner") String processingTimePartner, @RequestParam("gettingSignedDocuments") String gettingSignedDocuments,
                                @RequestParam("submissionDocuments") String submissionDocuments, @RequestParam("processingTimeUP") String processingTimeUP,
                                @RequestParam("pickingUpDocumentUA") String pickingUpDocumentUA, @RequestParam("applicationProcess") String applicationProcess,
                                @RequestParam("readyToGoToCZ") String readyToGoToCZ, @RequestParam("deviationToWorkingContract") String deviationToWorkingContract,
                                @RequestParam("company") int idCompany, @RequestParam("numberOfCandidatesForProject") int numberOfCandidatesForProject) {

        Project project = new Project(typeOfEmployment, position, schengenContractStarting, ECStarting,
                dateForMedicalDocs, statusOfReceived, processingTimePartner, gettingSignedDocuments,
                submissionDocuments, processingTimeUP, pickingUpDocumentUA, applicationProcess,
                readyToGoToCZ, deviationToWorkingContract, numberOfCandidatesForProject);
        System.out.println("test");
        project.setNumberOfCandidatesForProject(numberOfCandidatesForProject);
        Company company = companyService.findOne(idCompany);
        project.setCompany(company);
        projectService.save(project);
        return "redirect:/admin/projects";
    }

    @GetMapping("/projects/groups")
    public String groupForProject(Model model,
                                  @RequestParam(value = "projectId",
                                          required = false,
                                          defaultValue = "0") int projectId) {
        List<Candidate> candidates = new ArrayList<>();
        if (projectId != 0) {
            Project project = projectService.findOne(projectId);
            String position = project.getPosition();
            candidates = candidateService.findAllByPositionEquals(position);
            model.addAttribute("selectedProject", project);
        }
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("candidates", candidates);

        return "/admin/groupPage";
    }

    @PostMapping("/projects/groups/createGroup")
    public String createGroup(Model model, @RequestParam("nameGroup") String nameGroup,
                              @RequestParam("numberOfCandidates") int numberOfCandidates,
                              @RequestParam("project") int idProject,
                              @RequestParam(value = "candidates", required = false, defaultValue = "null") List<Integer> listId) {

        Project project = projectService.findProjectWithGroupsById(idProject);
        if (numberOfCandidates <= project.getNumberOfCandidatesForProject()
                &&  numberOfCandidates <= project.getNumberOfFreeVacancy()) {
            List<Candidate> candidateList = new ArrayList<>();
            GroupWithCandidates group = new GroupWithCandidates(nameGroup, numberOfCandidates, project);
            project.getGroups().add(group);
            groupService.save(group);
            groupService.findGroupWithCandidatesByNameGroupEquals(nameGroup);

            if (listId != null) {
                candidateList = candidateService.findAll(listId);
                for (Candidate candidate : candidateList) {
                    candidate.setGroupWithCandidates(group);
                }
                group.getCandidateList().addAll(candidateList);
                project.setNumberOfFreeVacancy(project.getNumberOfFreeVacancy() - listId.size());
//                candidateService.save(candidateList);
            }
            groupService.save(group);
            projectService.save(project);
        } else {
            model.addAttribute("key", "error");
        }

        return "redirect:/admin/projects/groups";
    }


}
