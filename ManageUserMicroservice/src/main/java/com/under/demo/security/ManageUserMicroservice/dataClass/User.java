package com.under.demo.security.ManageUserMicroservice.dataClass;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

    private String id;

    private String username;

    private int capital;



    public User(String userId, String username, int capital) {
        this.id = userId;
        this.username = username;
        this.capital = capital;
    }

    public User(){}
}
