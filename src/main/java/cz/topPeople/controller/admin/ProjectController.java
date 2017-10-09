package cz.topPeople.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin", method = RequestMethod.POST)
public class ProjectController {
    @GetMapping("/projects")
    public String projects() {

        return "projectsPage";
    }

}
