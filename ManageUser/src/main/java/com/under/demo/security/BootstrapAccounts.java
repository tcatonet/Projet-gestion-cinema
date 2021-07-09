package com.under.demo.security;

import com.under.demo.security.database.Modele.Roles;
import com.under.demo.security.database.Modele.User;
import com.under.demo.security.user.DAO.UserDAO;
import com.under.demo.security.user.Repository.RolesRepository;
import com.under.demo.security.user.Repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class BootstrapAccounts {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RolesRepository rolesRepository;

    BootstrapAccounts(UserDAO userDAO, PasswordEncoder passwordEncoder, UserRepository userRepository, RolesRepository rolesRepository) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
    }

    @EventListener
    void inStartuo(ApplicationReadyEvent event){


        List<User> listAdmin = userRepository.findAllByName("admin");
        if(listAdmin.size()==0) {
            String encodePassword = passwordEncoder.encode("admin");
            User user = new User("admin", "admin@myapp.fr", encodePassword);
            userRepository.save(user);
            User userCreate = userRepository.findByName(user.getName());
            long id = userCreate.getId();
            Roles role1 = new Roles(id, "ADMIN");
            Roles role2 = new Roles(id, "USER");

            rolesRepository.save(role1);
            rolesRepository.save(role2);

        }

        List<User> listUser = userRepository.findAllByName("systeme");
        if(listUser.size()==0) {
            String encodePassword = passwordEncoder.encode("systeme");
            User user = new User("systeme", "contact@myapp.fr", encodePassword);
            userRepository.save(user);
            User userCreate = userRepository.findByName(user.getName());
            long id = userCreate.getId();
            Roles role = new Roles(id, "SYSTEME");
            rolesRepository.save(role);
        }
    }
}
