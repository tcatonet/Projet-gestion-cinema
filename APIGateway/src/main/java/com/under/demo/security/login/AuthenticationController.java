package com.under.demo.security.login;

import com.under.demo.security.security.TokenProvider;
import com.under.demo.security.user.DTO.CreateAccountDTO;
import com.under.demo.security.user.SessionToken;
import com.under.demo.security.user.UserService;
import org.jdom.IllegalNameException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController extends HttpServlet{

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManager;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    private final UserService userService;
    SessionToken sessionToken;
    private final String LOGIN_SYSTEME = "systeme";
    private final String PASSWORD_SYSTEME = "systeme";
    private final String BASE_URL = "http://localhost:4040";

    @Autowired
    RestTemplate restTemplate;

    public AuthenticationController(TokenProvider tokenProvider,
                                    AuthenticationManagerBuilder authenticationManager, UserService userService) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }


}
