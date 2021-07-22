package com.under.demo.security.buisnessLogic;

import com.under.demo.security.database.Modele.Dashboard;
import com.under.demo.security.database.Modele.Resource;
import com.under.demo.security.database.Modele.Trade;
import com.under.demo.security.database.Modele.User;
import com.under.demo.security.buisnessLogic.DAO.DashboardDAO;
import com.under.demo.security.buisnessLogic.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DashboardService implements IUserService {
    private final DashboardDAO dashboardDAO;
    UserRepository userRepository;

    public String subscribeFormation() {

        boolean test = dashboardDAO.vefifySubscribeFormation();

        if(test){
            String msg = "";
            msg = dashboardDAO.subscribeFormation();
            return msg;
        }else{
            return "error subscribe formation";
        }


    }

    public String quitFormation() {

        boolean test = dashboardDAO.vefifyQuitFormation();

        if(test){
            String msg = "";
            msg = dashboardDAO.quitFormation();
            return msg;
        }else{
            return "error quit formation";
        }
    }


    public String findFromation() {

        boolean test = dashboardDAO.vefifyFindFromation();

        if(test){
            String msg = "";
            msg = dashboardDAO.findFromation();
            return msg ;
        }else{
            return "error find formation";
        }
    }

    public String closeFromation() {

        boolean test = dashboardDAO.vefifyCloseFromation();

        if(test){
            String msg = "";
            msg = dashboardDAO.closeFromation();
            return msg;
        }else{
            return "error close formation";
        }
    }

    public String giveCertification() {

        List<String> test = dashboardDAO.getUserWithSucessExam();

        String msg = "";
        msg = dashboardDAO.giveCertification(test);
        return msg;

    }


    @Override
    public void addUser(User user) {

        User usermodele = new User(user.getName(), user.getEmail() , user.getPassword());
        userRepository.save(usermodele);
    }
}
