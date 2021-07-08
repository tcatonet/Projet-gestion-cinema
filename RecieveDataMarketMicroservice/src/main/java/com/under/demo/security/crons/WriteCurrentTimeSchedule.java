package com.under.demo.security.crons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import com.under.demo.security.crons.DAO.CronDAO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WriteCurrentTimeSchedule {

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    private final CronDAO cronDAO;
    private float value;

    public WriteCurrentTimeSchedule(CronDAO cronDAO) {
        this.cronDAO = cronDAO;
    }


    // initialDelay = 3 second.
    // fixedDelay = 2 second.
    @Scheduled( initialDelay = 3 * 1000, fixedDelay = 10 * 1000)
    public void writeCurrentTime() {

        Date now = new Date();

        String nowString = df.format(now);
        LOGGER.info("doSomething");
        String name = "Oil barril";
        value = (float) (value + 0.1);
        cronDAO.updateValueRessource(name, value);
        System.out.println("Now is: "+ nowString);

    }

}