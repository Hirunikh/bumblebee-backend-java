package com.hiruni.bumblebee.accessLevel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/V1/AccessLevel")
public class AccessLevelController {

    private  final AccessLevelService accessLevelService;

    @Autowired
    public AccessLevelController(AccessLevelService accessLevelService) {
        this.accessLevelService = accessLevelService;
    }

    @GetMapping
    public List<AccessLevel> getCategory() {
        return accessLevelService.getAccessLevel();
    }

    @PostMapping
    public void CreateNewAccessLevel(@RequestBody AccessLevel accessLevel) {
        accessLevelService.addNewAccessLevel(accessLevel);
    }
}
