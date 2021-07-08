package com.under.demo.security.user;

import com.under.demo.security.user.DTO.CreateAccountDTO;
import org.jdom.IllegalNameException;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/admin")
public class AdminControlleur {

    public AdminControlleur(UserService userService) {
        this.userService = userService;
    }
    private final UserService userService;

}
