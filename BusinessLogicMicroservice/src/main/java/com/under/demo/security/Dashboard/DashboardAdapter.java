package com.under.demo.security.Dashboard;

import com.under.demo.security.Dashboard.dataClass.Dashboard;
import org.springframework.stereotype.Component;


@Component
public class DashboardAdapter {

    public Dashboard map(Dashboard dashboard) {
        return new Dashboard()
                .setId(dashboard.getId())
                .setUsername(dashboard.getUsername())
                .setResource(dashboard.getResource())
                .setStopLoss(dashboard.getStopLoss());

    }
}