package com.under.demo.security.user;

import com.under.demo.security.user.DTO.DashboardDTO;
import com.under.demo.security.user.DTO.RessourceDTO;
import com.under.demo.security.user.DTO.TradeDTO;
import com.under.demo.security.user.DTO.UserDTO;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/dashboard")
public class DashboardControlleur {

    public DashboardControlleur(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }


    private final DashboardService dashboardService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/trade/open")
    public ResponseEntity openTrade(@RequestBody TradeDTO tradeDTO) {

        String response = dashboardService.openTrade(tradeDTO.getId());
        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/trade/close")
    public ResponseEntity closeTrade(@RequestBody TradeDTO tradeDTO) {
        String response = dashboardService.closeTrade(tradeDTO.getId());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);

    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/create")
    public ResponseEntity dashboardCreate(@RequestBody DashboardDTO dashboardDTO) {

        String response = dashboardService.dashboardCreate(dashboardDTO.getUserName(), dashboardDTO.getName(), dashboardDTO.getRessource());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", String.valueOf(response));
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/ressource/price/get")
    public ResponseEntity getRessource() {
        String response = dashboardService.getRessource();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", String.valueOf(response));
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/trade/get")
    public ResponseEntity getTrade(@RequestBody TradeDTO tradeDTO) {
        String response = dashboardService.getTrade(tradeDTO.getId());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", String.valueOf(response));
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/get")
    public ResponseEntity getDashboard(@RequestBody UserDTO userDTO) {

        String response = dashboardService.getDashboard(userDTO.getName());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", String.valueOf(response));
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/ressource/create")
    public ResponseEntity createRessource(@RequestBody RessourceDTO ressourceDTO) {
        String response = dashboardService.createRessource(ressourceDTO.getName());

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", String.valueOf(response));
        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


}
