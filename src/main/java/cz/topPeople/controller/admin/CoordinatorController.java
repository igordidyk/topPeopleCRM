package cz.topPeople.controller.admin;

import cz.topPeople.entity.Coordinator;
import cz.topPeople.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping(value = "/admin", method = RequestMethod.POST)
public class CoordinatorController {

    @Autowired
    private CoordinatorService coordinatorService;

    @GetMapping("/coordinators")
    public String coordinators(Model model, Principal principal) {
//        model.addAttribute("key", principal.getName());
        model.addAttribute("coordinators", coordinatorService.findAll());
        return "/admin/coordinatorPage";
    }

    @PostMapping("/coordinators/createCoordinator")
    public String save(@RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName,
                       @RequestParam("email") String email,
                       @RequestParam("telephone") String telephone,
                       @RequestParam("username") String username,
                       @RequestParam("password") String password) {

        Coordinator coordinator = new Coordinator(firstName, lastName, username, password, email, telephone);
        coordinatorService.save(coordinator);
        return "redirect:/admin/coordinators";
    }

    @GetMapping("/coordinators/remove-{id}")
    public String removeCoordinator(@PathVariable("id") int id) {
        coordinatorService.delete(id);
        return "redirect:/admin/coordinators";

    }


}
