package com.under.demo.security.user;

import com.under.demo.security.user.DTO.CreateAccountDTO;
import com.under.demo.security.user.DTO.UpdateCapitalDTO;
import com.under.demo.security.user.DTO.UpdateEmailDTO;
import com.under.demo.security.user.DTO.UpdatePasswordDTO;
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
    @PostMapping("/capital/deposit")
    public ResponseEntity depositUserCapital(@RequestBody UpdateCapitalDTO updateCapitalDTO) {



        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String response = userService.depositUserCapital(username, updateCapitalDTO.getAmount());

        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/capital/withdrawal")
    public ResponseEntity withdrawalUserCapital(@RequestBody UpdateCapitalDTO updateCapitalDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String response = userService.withdrawalUserCapital(username, updateCapitalDTO.getAmount());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);

    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/capital/get")
    public ResponseEntity getUserCapital() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        float response = userService.getUserCapital(username);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", String.valueOf(response));
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/name/get")
    public ResponseEntity getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String response = authentication.getName();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String response = userService.updateUserPassword(username, updatePasswordDTO.getPassword());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/email/get")
    public ResponseEntity getUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String response = userService.getUserEmail(username);

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String response = userService.updateUserEmail(username, updateEmailDTO.getEmail());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


}
