package com.under.demo.security;

import com.under.demo.security.user.AccountService;
import com.under.demo.security.user.InfosUser;
import com.under.demo.security.user.request.CreateAccountRequest;
import org.jdom.IllegalNameException;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class AccessControlDemoController {

    public AccessControlDemoController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity hello() {
        return ResponseEntity.ok("Hello world");
    }

    private final AccountService accountService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateAccountRequest request) {
        if ("none".equalsIgnoreCase(request.getNewUsername())) {
            throw new IllegalNameException("Illegal name for none");
        }
        if ("none".equalsIgnoreCase(request.getNewPassword())) {
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

        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/user/update")
    public ResponseEntity<?> updateUser(@RequestBody CreateAccountRequest request) {
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
    @GetMapping("/user/stats")
    public ResponseEntity stats() {
        return ResponseEntity.ok(Map.of(
                "counter", 20,
                "allowed", true
        ));
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/admin/watcher")
    public ResponseEntity adminWatch() {
        return ResponseEntity.ok(Map.of(
                "view", "admin"
        ));
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/admin/users/get")
    public ResponseEntity getListUsers() {

        String usersList = accountService.getUsers();


        HttpHeaders request = new HttpHeaders();
        request.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("usersList", usersList);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request);

        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/user/get")
    public ResponseEntity getUsers(@RequestBody CreateAccountRequest request) {


        String user = accountService.getUser(request.getCurrentUsername(), request.getCurrentPassword());
        HttpHeaders httprequest = new HttpHeaders();
        httprequest.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        map.add("userInfos", user);

        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,httprequest);


        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);

    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/admin/create")
    public ResponseEntity<?> createAdmin(@RequestBody CreateAccountRequest request) {
        if ("none".equalsIgnoreCase(request.getNewUsername())) {
            throw new IllegalNameException("Illegal name for none");
        }

        LOGGER.info("msg d'p1 " + request.getNewUsername());

        InfosUser infosUser = accountService.addAdmin(request.getNewUsername(), request.getNewPassword());

        HttpHeaders httpRequest = new HttpHeaders();
        httpRequest.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        map.add("message", infosUser.getMessage());
        map.add("username", infosUser.getUsername());
        map.add("password", infosUser.getPassword());

        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,httpRequest);

        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }
}
