package com.under.demo.security.login;

import com.under.demo.security.security.TokenProvider;
import com.under.demo.security.user.AccountService;
import com.under.demo.security.user.InfosUser;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/login")
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManager;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    private final AccountService accountService;

    public AuthenticationController(TokenProvider tokenProvider,
                                    AuthenticationManagerBuilder authenticationManager, AccountService accountService) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.accountService = accountService;
    }



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
}
