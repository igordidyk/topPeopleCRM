package cz.topPeople.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/admin")
    public String adminPage(ModelMap model, Principal principal) {
        model.addAttribute("principal", principal);

        return "admin";
    }


    @GetMapping("/login")
    public String loginPage(ModelMap model) {
        model.addAttribute("title", "login");
        return "login";
    }

    @GetMapping("/coordinator")
    public String coordinator(Model model, Principal principal) {
        model.addAttribute("coordinatorName", principal.getName());

        return "coordinator";
    }

}
