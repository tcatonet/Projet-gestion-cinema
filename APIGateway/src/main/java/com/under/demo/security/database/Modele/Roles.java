package com.under.demo.security.database.Modele;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Embeddable
@Entity
@Table(name = "User_roles")
@Data
@Accessors(chain = true)
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_id")
    private long user_id;

    @Column(name="roles")
    private String roles;

    public Roles(long user_user_id, String roles) {

        this.user_id = user_user_id;
        this.roles = roles;

    }

    public Roles() {

    }
}
