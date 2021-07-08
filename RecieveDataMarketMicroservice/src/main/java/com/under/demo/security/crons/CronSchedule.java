package com.under.demo.security.crons;

import com.under.demo.security.crons.DAO.CronDAO;
import com.under.demo.security.crons.Repository.ResourceRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CronSchedule {
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    private final CronDAO cronDAO;

    public CronSchedule(CronDAO cronDAO) {
        this.cronDAO = cronDAO;
    }

    @Scheduled(cron = "0 20 1 * * MON-THU")
    public void doSomething() {
        LOGGER.info("doSomething");


    }

}