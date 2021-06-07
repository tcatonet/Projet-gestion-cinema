package com.under.demo.security.DashboardMicroservice;

import com.under.demo.security.DashboardMicroservice.DTO.*;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@RestController
public class DashboardController {

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }


    private final DashboardService dashboardService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/dashboard/create")
    public void createDashboard(@RequestBody CreateDashboardDTO createDashboardDTO) {
        dashboardService.createDashboard();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/dashboard/delete")
    public void deleteDashboard(@RequestBody DeleteDashboardDTO deleteDashboardDTO) {
        dashboardService.deleteDashboard();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/dashboard/stopLoss/create")
    public void createStopLoss(@RequestBody CreateStopLossDTO createStopLossDTO) {
        dashboardService.createStopLoss();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/dashboard/stopLoss/delete")
    public void deleteStopLoss(@RequestBody DeleteStopLossDTO deleteStopLossDTO) {
        dashboardService.deleteStopLoss();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/dashboard/stopLoss/upadte")
    public void updateStopLoss(@RequestBody UpdateStopLossDTO updateStopLossDTO) {
        dashboardService.updateStopLoss();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/dashboard/trade/open")
    public void openTrade(@RequestBody OpenTradeDTO openTradeDTO) {
        dashboardService.openTrade();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/dashboard/trade/close")
    public void closeTrade(@RequestBody CloseTradeDTO closeTradeDTO) {
        dashboardService.closeTrade();
    }




}
