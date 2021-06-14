package com.under.demo.security.apiUser;

import com.under.demo.security.apiUser.DTO.CreateAccountDTO;
import org.jdom.IllegalNameException;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

@RestController("/user")
public class UserController {

    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }


    private final AccountService accountService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");





    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody CreateAccountDTO request) {
        if ("none".equalsIgnoreCase(request.getNewUsername())) {
            throw new IllegalNameException("Illegal name for none");
        }

        InfosUser infosUser = accountService.updateOne(request.getId(),request.getCurrentUsername(), request.getNewUsername(), request.getCurrentPassword(),request.getNewPassword());

        HttpHeaders httpRequest = new HttpHeaders();
        httpRequest.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        map.add("message", infosUser.getMessage());
        map.add("username", infosUser.getUsername());
        map.add("password", infosUser.getPassword());
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,httpRequest);

        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }





    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/stats")
    public ResponseEntity stats() {
        return ResponseEntity.ok(Map.of(
                "counter", 20,
                "allowed", true
        ));
    }




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/get")
    public ResponseEntity getUser(@RequestBody CreateAccountDTO request) {


        String user = accountService.getUser(request.getCurrentUsername(), request.getCurrentPassword());
        HttpHeaders httprequest = new HttpHeaders();
        httprequest.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        map.add("userInfos", user);

        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,httprequest);


        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);

    }












}
