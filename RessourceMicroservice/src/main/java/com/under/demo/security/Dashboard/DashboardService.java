package com.under.demo.security.Dashboard;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DashboardService {
    private final DashboardRepository dashboard;


    public void createDashboard() {
        dashboard.createDashboard();
    }

    public void deleteDashboard() {
        dashboard.deleteDashboard();
    }

    public void createStopLoss() {
        dashboard.createStopLoss();
    }

    public void deleteStopLoss() {dashboard.deleteStopLoss();}

    public void updateStopLoss() {
        dashboard.updateStopLoss();
    }

    public void openTrade() {
        dashboard.openTrade();
    }

    public void closeTrade() {
        dashboard.closeTrade();
    }

}
