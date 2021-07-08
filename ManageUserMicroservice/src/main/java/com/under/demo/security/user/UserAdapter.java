package com.under.demo.security.user;

import com.under.demo.security.database.Modele.User;
import org.springframework.stereotype.Component;



@Component
public class UserAdapter {

    public User map(User user) {
        return new User()
                .setId(user.getId())
                .setName(user.getName())
                .setPassword(user.getPassword())
                .setRoles(user.getRoles());

    }
}