package com.under.demo.security.Logging;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoggingControlleur {



    public LoggingControlleur() {

    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("logging/createLogg")
    @PostMapping
    public ResponseEntity createLogg() {

        Object requeteHttp = null;
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("logging/deleteLogg")
    public ResponseEntity<?> deleteLogg() throws IOException {

        Object requeteHttp = null;
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }



    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("logging/retrieveLogg")
    public ResponseEntity<?> retrieveLogg() throws IOException {

        Object requeteHttp = null;
        return new ResponseEntity<>(requeteHttp, HttpStatus.OK);
    }

}
