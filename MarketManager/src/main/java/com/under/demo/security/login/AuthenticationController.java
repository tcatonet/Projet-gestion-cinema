package com.under.demo.security.login;

import com.under.demo.security.security.TokenProvider;
import com.under.demo.security.buisnessLogic.DashboardService;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServlet;
import java.util.logging.Logger;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthenticationController extends HttpServlet{

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManager;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    private final DashboardService dashboardService;




    public AuthenticationController(TokenProvider tokenProvider,
                                    AuthenticationManagerBuilder authenticationManager, DashboardService dashboardService) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.dashboardService = dashboardService;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getName(), loginDTO.getPassword());

        Authentication authentication = authenticationManager.getObject().authenticate(authenticationToken);
        String token = tokenProvider.createToken(authentication);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION, "Bearer " + token);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        map.add("token", token);

        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);

        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



}
