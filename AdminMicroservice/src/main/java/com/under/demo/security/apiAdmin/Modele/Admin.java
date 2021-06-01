package com.under.demo.security.apiAdmin.Modele;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Admin {

    private String id;

    private String username;

    private String password;

    private List<String> roles;

    public Admin(String userId, String username, String password, List<String> roles) {
        this.id = userId;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Admin(){}
}
