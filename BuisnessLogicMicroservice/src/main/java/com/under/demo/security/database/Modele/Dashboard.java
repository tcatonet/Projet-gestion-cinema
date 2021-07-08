package com.under.demo.security.database.Modele;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Dashboard_model")
@Data
@Accessors(chain = true)
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="id_user")
    private long id_user;

    @Column(name="name")
    private String name;

    @Column(name="ressource")
    private String ressource;

    @ElementCollection()
    @JoinTable(name="dashboard_trade", joinColumns=@JoinColumn(name = "dashboard_id"))
    private List<Integer> trades = new ArrayList();

    public Dashboard(String name, String ressource) {
        this.name = name;
        this.ressource = ressource;
    }

    public Dashboard() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.ressource);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Dashboard other = (Dashboard) obj;
        if (this.name != other.name) {
            return false;
        }
        if (!Objects.equals(this.ressource, other.ressource)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", ressource='").append(ressource).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
