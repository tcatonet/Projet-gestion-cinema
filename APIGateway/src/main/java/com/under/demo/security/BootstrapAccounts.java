package com.under.demo.security;

import com.under.demo.security.database.Modele.Roles;
import com.under.demo.security.database.Modele.User;
import com.under.demo.security.user.DAO.UserDAO;
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

    BootstrapAccounts(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

}