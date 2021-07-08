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
    private static final Logger LOGGER = Logger.getLogger("LOG: ");

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/users/get")
    public ResponseEntity getUsers() {

        String response = userService.getUsers();
        HttpHeaders request = new HttpHeaders();
        request.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/create")
    public ResponseEntity createAdmin(@RequestBody CreateAccountDTO createAccountDTO) {
        if ("none".equalsIgnoreCase(createAccountDTO.getName())) {
            throw new IllegalNameException("Illegal name for none");
        }
        if ("none".equalsIgnoreCase(createAccountDTO.getPassword())) {
            throw new IllegalNameException("Illegal name for none");
        }
        if ("none".equalsIgnoreCase(createAccountDTO.getEmail())) {
            throw new IllegalNameException("Illegal name for none");
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String response = userService.createAdmin(createAccountDTO.getName(),  createAccountDTO.getEmail(), createAccountDTO.getPassword());
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }
}
