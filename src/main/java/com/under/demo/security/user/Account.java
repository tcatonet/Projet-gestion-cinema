package com.under.demo.security.user;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Account {

    private String id;

    private String username;

    private String password;

    private List<String> roles;

    public Account(String userId, String username, String password, List<String> roles) {
        this.id = userId;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    Account(){}
}
