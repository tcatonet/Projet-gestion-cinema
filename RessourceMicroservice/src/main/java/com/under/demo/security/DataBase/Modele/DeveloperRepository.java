package com.under.demo.security.DataBase.Modele;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeveloperRepository extends MongoRepository<Developer, String> {
    List<Developer> findByProjectName(@Param("projectName") String projectName);
    List<Developer> findByAge(@Param("age") int age);
}