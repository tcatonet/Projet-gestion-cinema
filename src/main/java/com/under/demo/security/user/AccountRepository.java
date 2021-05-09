package com.under.demo.security.user;

import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.logging.Logger;

@Repository
public class AccountRepository {

    PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");


    AccountRepository(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private final Map<String, Account> db = new HashMap<>();

    public Optional<Account> findBy(String username) {
        return Optional.ofNullable(db.get(username));
    }

    public void save(Account account) {
        db.put(account.getUsername(), account);
    }



    public InfosUser storeUser(String username, String password) {
        InfosUser infosUser;

        if(doesNotExist(username)) {

            String userId = UUID.randomUUID().toString();
            String currentPassword = passwordEncoder.encode(password);
            db.put(username, new Account(username, username,currentPassword , List.of("USER")));
            LOGGER.info("msg d'information " + db);

            infosUser = new InfosUser(username, currentPassword, "New User created");

        }else{
            LOGGER.info("msg d'information " + db);
            infosUser = new InfosUser("", "", "This User already exist");
        }

        return infosUser;
    }



    public InfosUser storeAdmin(String username, String password) {
        LOGGER.info("msg d'password " + password);

        InfosUser infosUser;

        if(doesNotExist(username)) {

            String userId = UUID.randomUUID().toString();
            String currentPassword = passwordEncoder.encode(password);
            db.put(username, new Account(username, username, currentPassword, List.of("USER", "ADMIN")));
            LOGGER.info("msg d'information " + db);
            infosUser = new InfosUser(username, currentPassword, "New Admin created");

        }else{
            LOGGER.info("msg d'information " + db);
            infosUser = new InfosUser("", "", "This Admin already exist");
        }
        return infosUser;

    }


    public InfosUser updateOne(String id,String lastUsername, String newUsername, String password, String newPassword) {

        InfosUser infosUser;
        Account userAccount = db.get(lastUsername);
        LOGGER.info("msg d'information " + lastUsername);

        if (checkPassword(password,userAccount)){

            String currentPassword = passwordEncoder.encode(password);
            userAccount.setUsername(newUsername).setPassword(currentPassword).setId(id);
            db.remove(lastUsername);
            db.put(newUsername,userAccount);
            infosUser = new InfosUser(newUsername, currentPassword, "Update ok");

        }else {
            infosUser = new InfosUser(""," ", "Wrong identity");
        }
        return infosUser;
    }


    public String getUsers() {
       return db.toString();
    }

    public String getUser(String username, String password) {

        Account userAccount = db.get(username);

        if (checkPassword(password,userAccount)){
            return userAccount.toString();
        }else {
            return "Wrong identity";
        }

    }




    public boolean doesNotExist(String username) {
        Account account = db.get(username);
        return Objects.isNull(account);
    }

    public boolean checkPassword(String password, Account account) {
        return account.getPassword().equals(password);
    }

    public InfosUser findPasswordByUsername(String username) {

        Account account = db.get(username);


        InfosUser infosUser = new InfosUser(username, account.getPassword(), "User created");
        return  infosUser;
    }



}
