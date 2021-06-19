package com.under.demo.security.DataBase.Modele;

import java.util.List;

public interface DeveloperService {

    List<Developer> findByAgeAndProjectName(int age, String projectName);

}