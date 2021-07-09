package com.under.demo.security.user;

import org.jdom.IllegalNameException;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping()
public class AdminControlleur {

    public AdminControlleur(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }
    private final DashboardService dashboardService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");




}
