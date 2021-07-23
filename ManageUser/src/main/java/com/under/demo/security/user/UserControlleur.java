package com.under.demo.security.user;

import com.under.demo.security.user.DTO.*;
import org.jdom.IllegalNameException;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserControlleur {

    public UserControlleur(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity hello() {
        return ResponseEntity.ok("Hello world");
    }

    private final UserService userService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");




    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/name/get")
    public ResponseEntity getUserName(@RequestBody UserDTO userDTO) {


        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", userDTO.getName());
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/password/update")
    public ResponseEntity updateUserPassword(@RequestBody UpdatePasswordDTO updatePasswordDTO) {
        if ("none".equalsIgnoreCase(updatePasswordDTO.getPassword())) {
            throw new IllegalNameException("Illegal name for none");
        }

        String response = userService.updateUserPassword(updatePasswordDTO.getName(), updatePasswordDTO.getPassword());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/email/get")
    public ResponseEntity getUserEmail(@RequestBody UserDTO userDTO) {

        String response = userService.getUserEmail(userDTO.getName());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/email/update")
    public ResponseEntity updateUserEmail(@RequestBody UpdateEmailDTO updateEmailDTO) {
        if ("none".equalsIgnoreCase(updateEmailDTO.getEmail())) {
            throw new IllegalNameException("Illegal name for none");
        }

        String response = userService.updateUserEmail(updateEmailDTO.getName(), updateEmailDTO.getEmail());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/project/join")
    public ResponseEntity projectJoin() {

        String response = userService.projectJoin();
        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/project/left")
    public ResponseEntity projectLeft() {

        String response = userService.projectLeft();
        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/contractorMembership/apply")
    public ResponseEntity contractorMembershipApply() {

        String response = userService.contractorMembershipApply();
        response = response + userService.tradsmenMembershipApply();

        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/paymentHistorique/get")
    public ResponseEntity paymentHistorique() {

        String response = userService.paymentHistorique();

        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

}
