package cz.topPeople.controller.coordinator;

import cz.topPeople.entity.Coordinator;
import cz.topPeople.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping(value = "/coordinator", method = RequestMethod.POST)
public class AccountCoordinatorController {
    @Autowired
    private CoordinatorService coordinatorService;

    @GetMapping("/myAccount")
    public String Account(Model model, Principal principal) {
        model.addAttribute("coordinator", coordinatorService.findByName(principal.getName()));
        System.out.println(principal.getName());
        System.out.println(coordinatorService.findByName(principal.getName()));
        System.out.println(coordinatorService.findByName(principal.getName()).getId());

        return "/coordinator/accountDetails";
    }

    @PostMapping("/myAccount/editProfile")
    public String coordinatorAccount(@RequestParam("firstName") String firstName,
                                     @RequestParam("lastName") String lastName,
                                     @RequestParam("email") String email,
                                     @RequestParam("telephone") String telephone,
                                     @RequestParam("id") int id) {

        Coordinator coordinator = coordinatorService.findOne(id);
        coordinator.setFirstName(firstName);
        coordinator.setLastName(lastName);
        coordinator.setEmail(email);
        coordinator.setTelephone(telephone);
        coordinatorService.update(coordinator);
        return "redirect:/coordinator/myAccount";
    }
}
