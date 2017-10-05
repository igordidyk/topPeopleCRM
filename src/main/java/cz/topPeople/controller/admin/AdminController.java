package cz.topPeople.controller.admin;

import cz.topPeople.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin", method = RequestMethod.POST)
public class AdminController {

    @Autowired
    private CoordinatorService coordinatorService;

    @GetMapping("/coordinators")
    public String coordinators(Model model) {
        model.addAttribute("coordinators", coordinatorService.findAll());
        return "/coordinator/coordinatorPage";
    }


}
