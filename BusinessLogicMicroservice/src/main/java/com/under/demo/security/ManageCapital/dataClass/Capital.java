package com.under.demo.security.ManageCapital.dataClass;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Capital {

    private String id;

    private String username;

    private int capital;



    public Capital(String userId, String username, int capital) {
        this.id = userId;
        this.username = username;
        this.capital = capital;
    }

    public Capital(){}
}
