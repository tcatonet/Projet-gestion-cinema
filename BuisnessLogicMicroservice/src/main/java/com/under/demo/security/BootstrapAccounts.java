package com.under.demo.security;

import com.under.demo.security.user.DAO.DashboardDAO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class BootstrapAccounts {

    private final DashboardDAO dashboardDAO;
    private final PasswordEncoder passwordEncoder;

    BootstrapAccounts(DashboardDAO dashboardDAO, PasswordEncoder passwordEncoder) {
        this.dashboardDAO = dashboardDAO;
        this.passwordEncoder = passwordEncoder;
    }


}
