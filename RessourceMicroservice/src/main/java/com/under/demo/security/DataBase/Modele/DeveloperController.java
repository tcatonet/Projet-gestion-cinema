package com.under.demo.security.DataBase.Modele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeveloperController {
    @Autowired
    private DeveloperService developerService;
    @RequestMapping(path = "/findByAgeAndProjectName", method = RequestMethod.GET)
    public List<Developer> findByAgeAndProjectName(
            @RequestParam("age") int age,
            @RequestParam("projectName") String projectName) {

        return developerService.findByAgeAndProjectName(age, projectName);

    }
}