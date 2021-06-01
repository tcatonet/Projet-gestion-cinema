package com.under.demo.security.apiAdmin.Modele;

public class InfosAdmin {
    String username;
    String password;
    String message;


    public InfosAdmin(String username, String password, String message) {
        this.username = username;
        this.password = password;
        this.message = message;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getMessage(){
        return this.message;
    }


}
