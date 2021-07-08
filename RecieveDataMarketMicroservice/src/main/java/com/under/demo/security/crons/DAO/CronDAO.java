package com.under.demo.security.crons.DAO;


import com.under.demo.security.crons.Repository.ResourceRepository;
import com.under.demo.security.database.Modele.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.logging.Logger;
import java.sql.Date;




@Repository
public class CronDAO {

    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    CronDAO( ) {
    }



    public void updateValueRessource( String name, float value) {
        Resource resource = new Resource(name, value);
        resourceRepository.save(resource);
    }

}