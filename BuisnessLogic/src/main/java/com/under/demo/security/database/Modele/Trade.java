package com.under.demo.security.database.Modele;


import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "User_trades")
@Data
@Accessors(chain = true)
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="user_id_trades")
    private long dashboard_id;

    @Column(name="open_date")
    private Date date_open;

    @Column(name="close_date")
    private Date date_close;

    @Column(name="gain")
    private float gain;



    public Trade(long dashboard_id) {
        Date sqlDate = new Date(System.currentTimeMillis());
        this.dashboard_id = dashboard_id;
        this.date_open =  sqlDate;
    }

    public Trade() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.dashboard_id);
        hash = 79 * hash + Objects.hashCode(this.date_open);
        hash = 79 * hash + Objects.hashCode(this.date_close);
        hash = 79 * hash + Objects.hashCode(this.gain);
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



        final Trade other = (Trade) obj;
        if (this.dashboard_id != other.dashboard_id) {
            return false;
        }
        if (!Objects.equals(this.date_open, other.date_open)) {
            return false;
        }

        if (!Objects.equals(this.date_close, other.date_close)) {
            return false;
        }

        if (!Objects.equals(this.gain, other.gain)) {
            return false;
        }

        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("id=").append(id);
        sb.append(", dashboard_id='").append(dashboard_id).append('\'');
        sb.append(", date_open='").append(date_open).append('\'');
        sb.append(", date_close='").append(date_close).append('\'');
        sb.append(", gain='").append(gain).append('\'');
        sb.append('}');
        return sb.toString();
    }



}
