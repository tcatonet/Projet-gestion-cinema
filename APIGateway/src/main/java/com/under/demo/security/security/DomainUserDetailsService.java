package com.under.demo.security.security;

import com.under.demo.security.database.Modele.User;
import com.under.demo.security.user.DAO.UserDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DomainUserDetailsService implements UserDetailsService {

    private final UserDAO userDAO;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    public DomainUserDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User appUser = userDAO.findBy(username);
        LOGGER.info(username);
        return org.springframework.security.core.userdetails.User.builder()
                .username(username)
                .password(appUser.getPassword())
                .roles(appUser.getRoles().toArray(new String[0]))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
