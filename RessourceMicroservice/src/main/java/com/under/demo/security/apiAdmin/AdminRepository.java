package com.under.demo.security.apiAdmin;

import com.under.demo.security.apiAdmin.Modele.Admin;
import com.under.demo.security.apiAdmin.Modele.InfosAdmin;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.logging.Logger;

@Repository
public class AdminRepository {

    PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");


    AdminRepository() {
        this.passwordEncoder = passwordEncoder;
    }

    private final Map<String, Admin> db = new HashMap<>();

    public Optional<Admin> findBy(String username) {
        return Optional.ofNullable(db.get(username));
    }

    public void save(Admin account) {
        db.put(account.getUsername(), account);
    }



    public InfosAdmin storeUser(String username, String password) {
        InfosAdmin infosUser;

        if(doesNotExist(username)) {

            String userId = UUID.randomUUID().toString();
            String currentPassword = passwordEncoder.encode(password);
            db.put(username, new Admin(username, username,currentPassword , List.of("USER")));
            LOGGER.info("msg d'information " + db);

            infosUser = new InfosAdmin(username, currentPassword, "New User created");

        }else{
            LOGGER.info("msg d'information " + db);
            infosUser = new InfosAdmin("", "", "This User already exist");
        }

        return infosUser;
    }



    public InfosAdmin storeAdmin(String username, String password) {
        LOGGER.info("msg d'password " + password);

        InfosAdmin infosUser;

        if(doesNotExist(username)) {

            String userId = UUID.randomUUID().toString();
            String currentPassword = passwordEncoder.encode(password);
            db.put(username, new Admin(username, username, currentPassword, List.of("USER", "ADMIN")));
            LOGGER.info("msg d'information " + db);
            infosUser = new InfosAdmin(username, currentPassword, "New Admin created");

        }else{
            LOGGER.info("msg d'information " + db);
            infosUser = new InfosAdmin("", "", "This Admin already exist");
        }
        return infosUser;

    }




    public String getUsers() {
       return db.toString();
    }

    public String getUser(String username, String password) {

        Admin userAccount = db.get(username);

        if (checkPassword(password,userAccount)){
            return userAccount.toString();
        }else {
            return "Wrong identity";
        }

    }



    public boolean doesNotExist(String username) {
        Admin account = db.get(username);
        return Objects.isNull(account);
    }

    public boolean checkPassword(String password, Admin account) {
        return account.getPassword().equals(password);
    }



}
