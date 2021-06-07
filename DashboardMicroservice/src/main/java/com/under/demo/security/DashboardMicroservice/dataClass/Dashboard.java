package com.under.demo.security.DashboardMicroservice.dataClass;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Dashboard {

    private String id;

    private String username;

    private String resource;

    private int stopLoss;


    public Dashboard(String userId, String username, String resource, int stopLoss) {
        this.id = userId;
        this.username = username;
        this.resource = resource;
        this.stopLoss = stopLoss;

    }

    public Dashboard(){}
}
