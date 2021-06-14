package com.under.demo.security.Logging;

import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class LoggingRepository {

    private static final Logger LOGGER = Logger.getLogger("LOG: ");


    LoggingRepository() {
            }



    public LoggingRepository storeLogging(String content, String linkTo) {
        return null;
    }

    public LoggingRepository deleteLogging(String id) {
        return null;
    }

    public LoggingRepository retrieveLogging(String id) {
        return null;
    }



}
