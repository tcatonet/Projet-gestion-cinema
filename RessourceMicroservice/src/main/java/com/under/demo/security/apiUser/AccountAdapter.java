package com.under.demo.security.apiUser;

import com.under.demo.security.apiUser.dataClass.Account;
import org.springframework.stereotype.Component;



@Component
public class AccountAdapter {

    public Account map(Account account) {
        return new Account()
                .setId(account.getId())
                .setUsername(account.getUsername())
                .setPassword(account.getPassword())
                .setRoles(account.getRoles());

    }
}