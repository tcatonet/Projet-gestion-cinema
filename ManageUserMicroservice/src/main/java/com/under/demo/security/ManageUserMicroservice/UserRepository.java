package com.under.demo.security.ManageUserMicroservice;

import com.under.demo.security.ManageUserMicroservice.dataClass.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Repository
public class UserRepository {

    private static final Logger LOGGER = Logger.getLogger("LOG: ");


    UserRepository() {}

    private final Map<String, User> db = new HashMap<>();


    public void updateName() {
    }

    public void updatePassword() {
    }

    public void updateEmail() {
    }

    public void deleteUser() {
    }

    public void getInfosUser() {
    }




}
