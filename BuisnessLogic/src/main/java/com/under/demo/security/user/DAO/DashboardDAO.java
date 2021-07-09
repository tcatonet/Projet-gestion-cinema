package com.under.demo.security.user.DAO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.under.demo.security.database.Modele.*;
import com.under.demo.security.user.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Date;
import java.util.*;
import java.util.logging.Logger;

@Repository
public class DashboardDAO {

    PasswordEncoder passwordEncoder;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private DashboardRepository dashboardRepository;

    private EntityManager entityManager;

    DashboardDAO(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    private final Map<String, User> db = new HashMap<>();
    public <Optional> User findBy(String username) {
        return userRepository.findByName(username);
    }


    public  List<Trade> getTrade(int id)   {
        LOGGER.info(String.valueOf(id));
        List<Trade> trades = tradeRepository.findAll();
        return trades;
    }

    public List<Dashboard>  getDashboard(String username)   {
        LOGGER.info(String.valueOf(username));
        User user = userRepository.findByName(username);

        List<Dashboard> dashboards = dashboardRepository.getDashboardsById((int) user.getId());
        String msg = "getDashboard";
        return dashboards;
    }


    public String openTrade(String name)   {
        LOGGER.info("test");
        LOGGER.info(name);

        User user = userRepository.findByName(name);
        Trade trade = new Trade(user.getId());
        tradeRepository.save(trade);
        String msg = "Trade open";
        return msg;
    }

    public String closeTrade(int id) {
        LOGGER.info(String.valueOf(id));
        String msg = "";
        List<Trade> listTrade = tradeRepository.findAllById(id);

        if (listTrade.size()==1) {
            Trade trade = tradeRepository.findById(id);
            java.sql.Date sqlDate = new Date(System.currentTimeMillis());
            trade.setDate_close(sqlDate);
            tradeRepository.save(trade);
            msg = "Trade close";
        }else{
            msg = "no trade";
        }
        return msg;
    }


    public String createRessource(String name) {
        Resource resource = new Resource(name, 1.0F);
        resourceRepository.save(resource);
        String msg = "Ressource create";
        return msg;
    }


    public String dashboardCreate(String userNanme, String dashboardName, String ressource) {
        LOGGER.info("test");

        User user = userRepository.findByName(userNanme);
        Dashboard dashboard = new Dashboard("dashboardName", "ressource", user.getId());

        dashboardRepository.save(dashboard);
        String msg = "Dashboard create";
        return msg;
    }

    public List<Resource> getRessource() {
        LOGGER.info(String.valueOf("Get ressource"));
        List<Resource> resource = resourceRepository.getResource();
        return resource;
    }


}
