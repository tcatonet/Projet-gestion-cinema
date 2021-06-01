package com.under.demo.security.apiAdmin;

import com.under.demo.security.apiAdmin.Modele.Admin;
import org.springframework.stereotype.Component;


@Component
public class AdminAdapter {

    public Admin map(Admin account) {
        return new Admin()
                .setId(account.getId())
                .setUsername(account.getUsername())
                .setPassword(account.getPassword())
                .setRoles(account.getRoles());

    }
}