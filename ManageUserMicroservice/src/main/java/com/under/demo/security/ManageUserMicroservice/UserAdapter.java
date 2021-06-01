package com.under.demo.security.ManageUserMicroservice;

import com.under.demo.security.ManageUserMicroservice.dataClass.User;
import org.springframework.stereotype.Component;


@Component
public class UserAdapter {

    public User map(User user) {
        return new User()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setCapital(user.getCapital());

    }
}