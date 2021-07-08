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
public class UserDAO {

    PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;
    UserDAO(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    private final Map<String, User> db = new HashMap<>();
    public <Optional> User findBy(String username) {
        return userRepository.findByName(username);
    }


    public String createUser(String username, String password, String email)   {
        List<String> roles = new ArrayList();
        roles.add("USER");
        String encodePassword = passwordEncoder.encode(password);
        User user = new User(username, email, encodePassword);
        userRepository.save(user);

        User userCreate = userRepository.findByName(user.getName());
        long id = userCreate.getId();
        Roles role = new Roles(id, "USER");

        rolesRepository.save(role);

        String msg = "User create";
        return msg;
    }

    public String depositUserCapital(String name, int amount) {
        User userFromDb = userRepository.findByName(name);
        float capital = userFromDb.getCapital();
        float newCapital = capital + amount;
        userFromDb.setCapital(newCapital);
        userRepository.save(userFromDb);

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        String JSONcapital = gson.toJson(newCapital);
        return JSONcapital;
    }

    public String withdrawalUserCapital(String name, int amount) {
        User userFromDb = userRepository.findByName(name);
        float capital = userFromDb.getCapital();
        float newCapital = capital - amount;
        userFromDb.setCapital(newCapital);
        userRepository.save(userFromDb);

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        String JSONcapital = gson.toJson(newCapital);
        return JSONcapital;
    }

    public float getUserCapital(String name) {
        User userFromDb = userRepository.findByName(name);
        float capital = userFromDb.getCapital();
        return capital;
    }


    public String updateUserPassword(String name, String password) {
        User userFromDb = userRepository.findByName(name);
        String encodePassword = passwordEncoder.encode(password);
        userFromDb.setPassword(encodePassword);
        userRepository.save(userFromDb);

        String msg = "Password update";
        return msg;
    }

    public String getUserEmail(String name) {
        User userFromDb = userRepository.findByName(name);
        String email = userFromDb.getEmail();
        return email;
    }

    public String updateUserEmail(String name, String email) {
        User userFromDb = userRepository.findByName(name);
        userFromDb.setEmail(email);
        userRepository.save(userFromDb);

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        String JSONemail= gson.toJson(email);
        return JSONemail;
    }


    public String getUsers() {
        List<User> userList = userRepository.findAll();

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        String JSONuserList = gson.toJson(userList);
        return JSONuserList;
    }


    public String createAdmin(String name, String email, String password) {

        String currentPassword = passwordEncoder.encode(password);
        User user = new User(name, email, currentPassword);
        userRepository.save(user);

        User userCreate = userRepository.findByName(user.getName());
        long id = userCreate.getId();
        LOGGER.info(userCreate.getPassword());
        LOGGER.info(String.valueOf(id));
        Roles role = new Roles(id, "USER");
        rolesRepository.save(role);
        Roles role2 = new Roles(id, "ADMIN");
        rolesRepository.save(role2);

        String msg = "Admin create";
        return msg;
    }




    public boolean checkPassword(String password, User account) {
        return account.getPassword().equals(password);
    }




}
