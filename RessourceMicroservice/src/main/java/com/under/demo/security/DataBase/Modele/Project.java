package com.under.demo.security.DataBase.Modele;


public class Project {
    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    private String name;
    private String creationDate;
}