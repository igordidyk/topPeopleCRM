package cz.topPeople.controller.admin;

import cz.topPeople.entity.Coordinator;
import cz.topPeople.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin",method = RequestMethod.POST)
public class CoordinatorRESTController {
    @Autowired
    private CoordinatorService coordinatorService;


    @PostMapping(value = "/coordinators/createCoordinator")
    public Coordinator registrationCoordinator(@RequestBody Coordinator coordinator){
        System.out.println(coordinator);
        coordinatorService.save(coordinator);
        return coordinator;
    }



}
