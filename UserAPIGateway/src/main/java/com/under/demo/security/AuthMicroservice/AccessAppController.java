package com.under.demo.security.AuthMicroservice;

import com.under.demo.security.AuthMicroservice.DTO.LoginDTO;
import com.under.demo.security.AuthMicroservice.security.TokenProvider;
import com.under.demo.security.apiUser.AccountService;
import com.under.demo.security.apiUser.InfosUser;
import com.under.demo.security.apiUser.DTO.CreateAccountDTO;
import org.jdom.IllegalNameException;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccessAppController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManager;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    private final AccountService accountService;

    public AccessAppController(TokenProvider tokenProvider,
                               AuthenticationManagerBuilder authenticationManager, AccountService accountService) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.accountService = accountService;
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/login")
    @PostMapping
    public ResponseEntity login(@RequestBody LoginDTO loginDTO) {

        LOGGER.info("msg d'information " + loginDTO.getUsername());
        LOGGER.info("msg d'information " + loginDTO.getPassword());

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        Authentication authentication = authenticationManager.getObject().authenticate(authenticationToken);

        String token = tokenProvider.createToken(authentication);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(AUTHORIZATION, "Bearer " + token);


        HttpHeaders request = new HttpHeaders();
        request.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        InfosUser infosUser = accountService.findPasswordByUsername(loginDTO.getUsername());

        map.add("token", token);
        map.add("username", infosUser.getUsername());
        map.add("password", infosUser.getPassword());

        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request);

        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateAccountDTO request) throws IOException {
        if ("".equalsIgnoreCase(request.getNewUsername())) {
            throw new IllegalNameException("Illegal name for none");
        }
        if ("".equalsIgnoreCase(request.getNewPassword())) {
            throw new IllegalNameException("Illegal name for none");
        }

        InfosUser infosUser = accountService.addUser(request.getNewUsername(), request.getNewPassword());

        HttpHeaders httpRequest = new HttpHeaders();
        httpRequest.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        map.add("message", infosUser.getMessage());
        map.add("username", infosUser.getUsername());
        map.add("password", infosUser.getPassword());

        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,httpRequest);
        //emailService.sendEmail("Welcome");

        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

}
