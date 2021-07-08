package com.under.demo.security.user.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.under.demo.security.database.Modele.Roles;
import com.under.demo.security.user.Repository.RolesRepository;
import com.under.demo.security.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.under.demo.security.database.Modele.User;

import java.util.*;
import java.util.logging.Logger;

@Repository
public class DashboardDAO {

    PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;
    DashboardDAO(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    private final Map<String, User> db = new HashMap<>();
    public <Optional> User findBy(String username) {
        return userRepository.findByName(username);
    }


    public String getTrade(int id)   {
        LOGGER.info(String.valueOf(id));
        String msg = "getTrade ";
        return msg;
    }

    public String getDashboard(String username)   {
        LOGGER.info(String.valueOf(username));
        String msg = "getDashboard";
        return msg;
    }


    public String openTrade(int dashboardID)   {
        LOGGER.info(String.valueOf(dashboardID));
        String msg = "Trade open";
        return msg;
    }

    public String closeTrade(int id) {
        LOGGER.info(String.valueOf(id));
        String msg = "Trade close";
        return msg;
    }


    public String createRessource(String name) {
        String msg = "Ressource create";
        return msg;
    }


    public String dashboardCreate(String userNanme, String dashboardName, String ressource) {
        LOGGER.info(String.valueOf(userNanme));
        LOGGER.info(String.valueOf(dashboardName));
        LOGGER.info(String.valueOf(ressource));

        String msg = "Dashboard create";
        return msg;
    }

    public String getRessource() {
        LOGGER.info(String.valueOf("Get ressource"));
        return "getRessource";
    }


}
