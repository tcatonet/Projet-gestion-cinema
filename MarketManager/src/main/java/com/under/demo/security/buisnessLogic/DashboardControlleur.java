package com.under.demo.security.buisnessLogic;

import com.under.demo.security.database.Modele.Dashboard;
import com.under.demo.security.database.Modele.Resource;
import com.under.demo.security.database.Modele.Trade;
import com.under.demo.security.buisnessLogic.DTO.DashboardDTO;
import com.under.demo.security.buisnessLogic.DTO.RessourceDTO;
import com.under.demo.security.buisnessLogic.DTO.TradeDTO;
import com.under.demo.security.buisnessLogic.DTO.UserDTO;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/market")
public class DashboardControlleur {

    public DashboardControlleur(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }


    private final DashboardService dashboardService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/project/create/request")
    public ResponseEntity projectRequestCreate() {

        String response = dashboardService.projectCreate();
        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/project/close/request")
    public ResponseEntity projectRequestClose() {

        String response = dashboardService.projectClose();
        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/project/date/update")
    public ResponseEntity projectUpdateDate() {

        String response = dashboardService.addProjectDuration();
        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/project/billRate/update")
    public ResponseEntity projectUpdateBillRate() {

        String response = dashboardService.updateBillRate();
        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/project/active")
    public ResponseEntity projectActive() {

        String response = dashboardService.projectActive();
        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/project/tradsmen/match")
    public ResponseEntity projectTradsmenMatch() {

        String response = dashboardService.projectTradsmenMatch();
        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/project/match")
    public ResponseEntity projectMatch() {

        String response = dashboardService.projectMatch();
        LOGGER.info(response);

        HttpHeaders request_ = new HttpHeaders();
        request_.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("msg", response);
        HttpEntity<MultiValueMap<String, String>> requeteHttp = new HttpEntity<MultiValueMap<String, String>>(map,request_);
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }
}
