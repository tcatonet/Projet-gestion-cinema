package com.under.demo.security.database.Modele;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Date;


@Embeddable
@Entity
@Table(name = "Resource_model")
@Data
@Accessors(chain = true)
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="value")
    private Float value;

    @Column(name="time_update")
    private Date time_update;


    public Resource(String name, Float value) {

        this.name = name;
        this.value = value;

        long millis=System.currentTimeMillis();
        this.time_update = new Date(millis);

    }

    public Resource() {
    }
}
