package com.under.demo.security;

import com.under.demo.security.user.DAO.UserDAO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class BootstrapAccounts {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    BootstrapAccounts(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }


}
