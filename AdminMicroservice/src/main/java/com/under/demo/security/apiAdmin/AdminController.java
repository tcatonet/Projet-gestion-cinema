package com.under.demo.security.apiAdmin;

import com.under.demo.security.apiAdmin.Modele.InfosAdmin;
import com.under.demo.security.apiAdmin.request.CreateAccountRequest;
import org.jdom.IllegalNameException;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    private final AdminService adminService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/users/get")
    public ResponseEntity getListUsers() {

        String usersList = adminService.getUsers();


        HttpHeaders request = new HttpHeaders();
        request.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("usersList", usersList);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);

    }




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/create")
    public ResponseEntity<?> createAdmin(@RequestBody CreateAccountRequest request) {
        if ("none".equalsIgnoreCase(request.getNewUsername())) {
            throw new IllegalNameException("Illegal name for none");
        }

        LOGGER.info("msg d'p1 " + request.getNewUsername());

        InfosAdmin infosUser = adminService.addAdmin(request.getNewUsername(), request.getNewPassword());

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
