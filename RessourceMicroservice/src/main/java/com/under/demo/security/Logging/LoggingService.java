package com.under.demo.security.Logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoggingService {
    private final LoggingRepository loggingRepository;


    public LoggingRepository createLogging(String content, String linkTo) {
        return loggingRepository.storeLogging(content, linkTo);
    }


    public LoggingRepository deleteLogging(String id) {
        return loggingRepository.deleteLogging(id);
    }


    public LoggingRepository retrieveLogging(String id){
        return loggingRepository.retrieveLogging(id);
    }

}
