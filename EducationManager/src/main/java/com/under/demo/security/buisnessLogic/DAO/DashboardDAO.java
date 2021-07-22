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

    public boolean vefifySubscribeFormation()   {
        return true;
    }
    public boolean vefifyQuitFormation()   {
        return true;
    }
    public boolean vefifyFindFromation()   {
        return true;
    }
    public boolean vefifyCloseFromation()   {
        return true;
    }


    public String subscribeFormation()   {
        String msg = "subscribe Formation|";
        return msg;
    }

    public String quitFormation()   {
        String msg = "quit Formation|";
        return msg;
    }

    public String findFromation()   {
        String msg = "find Fromation|";
        return msg;
    }

    public String closeFromation()   {
        String msg = "close Fromation|";
        return msg;
    }

    public List<String> getUserWithSucessExam()   {
        List<String> res = new ArrayList<>();
        return res;
    }

    public String giveCertification(List<String> listUser)   {
        String msg = "give Certification|";
        return msg;
    }

}
