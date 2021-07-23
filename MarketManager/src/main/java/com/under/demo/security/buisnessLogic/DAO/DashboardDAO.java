package com.under.demo.security.buisnessLogic.DAO;

import com.under.demo.security.database.Modele.*;
import com.under.demo.security.buisnessLogic.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.*;
import java.util.logging.Logger;

@Repository
public class DashboardDAO {

    PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    @Autowired
    private UserRepository userRepository;


    DashboardDAO(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    private final Map<String, User> db = new HashMap<>();
    public <Optional> User findBy(String username) {
        return userRepository.findByName(username);
    }

    public boolean vefifyProject()   {
        return true;
    }
    public boolean vefifyProjectClose()   {
        return true;
    }

    public boolean vefifyProjectDuration()   {
        return true;
    }

    public boolean vefifyBillRate()   {
        return true;
    }

    public boolean vefifyProjectActive()   {
        return true;
    }

    public String addRequiredTrade()   {
        String msg = "add Required Trade|";
        return msg;
    }

    public String addRequiredSkills()   {
        String msg = "add Required Skills|";
        return msg;
    }

    public String releaseTradmen()   {
        String msg = "release Tradmen|";
        return msg;
    }

    public String closeProject()   {
        String msg = "close Project|";
        return msg;
    }


    public String addProjectDuration()   {
        String msg = "add Project Duration|";
        return msg;
    }

    public String updateBillRate()   {
        String msg = "update Bill Rate|";
        return msg;
    }

    public String projectActive()   {
        String msg = "project Active|";
        return msg;
    }

    public boolean vefifyProjectTradsmenMatch()   {
        return true;
    }

    public boolean vefifyProjectMatch()   {
        return true;
    }

    public String analyseProjectNeed()   {
        String msg = "project Active|";
        return msg;
    }

    public String scearchCandidate(String project_needs)   {
        String msg = "list candidate|";
        return msg;
    }

    public String assignBestCandidate(String list_candidate)   {
        String msg = "assign Best Candidate|";
        return msg;
    }




    public String analyseTradsmenSkills()   {
        String msg = "project Active|";
        return msg;
    }

    public String scearchProject(String project_needs)   {
        String msg = "scearch Project |";
        return msg;
    }

    public String assignBestProject(String list_candidate)   {
        String msg = "assign Best Candidate|";
        return msg;
    }
}
