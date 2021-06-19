package com.under.demo.security.DataBase.Modele;

import org.springframework.data.annotation.Id;
public class Developer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private Project project;

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Project getProject() {
        return project;
    }
}
