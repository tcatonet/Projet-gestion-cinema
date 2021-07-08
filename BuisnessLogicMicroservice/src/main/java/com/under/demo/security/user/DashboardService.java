package com.under.demo.security.user;

import com.under.demo.security.database.Modele.User;
import com.under.demo.security.user.DAO.DashboardDAO;
import com.under.demo.security.user.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DashboardService implements IUserService {
    private final DashboardDAO dashboardDAO;
    UserRepository userRepository;

    public String openTrade(int dashboardID) {
        return dashboardDAO.openTrade(dashboardID);
    }

    public String createRessource(String name) {
        return dashboardDAO.createRessource(name);
    }

    public String closeTrade(int id ) {
        return dashboardDAO.closeTrade(id);
    }

    public String dashboardCreate(String userName,  String name, String ressource) {

        return dashboardDAO.dashboardCreate(userName, name, ressource);
    }

    public String getRessource() {
        return dashboardDAO.getRessource();
    }


    public String getDashboard(String username) {
        return dashboardDAO.getDashboard(username);
    }

    public String getTrade(int id) {
        return dashboardDAO.getTrade(id);
    }


    @Override
    public void addUser(User user) {

        User usermodele = new User(user.getName(), user.getEmail() , user.getPassword());
        userRepository.save(usermodele);
    }
}
