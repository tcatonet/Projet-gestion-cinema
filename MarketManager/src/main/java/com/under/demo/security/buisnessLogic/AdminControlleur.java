package com.under.demo.security.buisnessLogic;

import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping()
public class AdminControlleur {

    public AdminControlleur(MarketService dashboardService) {
        this.dashboardService = dashboardService;
    }
    private final MarketService dashboardService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");




}
