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

    public String projectCreate() {

        boolean test = dashboardDAO.vefifyProject();

        if(test){
            String msg = "";
            msg = dashboardDAO.addRequiredTrade();
            msg = msg + dashboardDAO.addRequiredSkills();
            return "project create" + msg;
        }else{
            return "error project creation";
        }
    }

    public String projectClose() {

        boolean test = dashboardDAO.vefifyProjectClose();

        if(test){
            String msg = "";
            msg = dashboardDAO.releaseTradmen();
            msg = msg + dashboardDAO.closeProject();
            return msg;
        }else{
            return "error project close";
        }
    }


    public String addProjectDuration() {

        boolean test = dashboardDAO.vefifyProjectDuration();

        if(test){
            String msg = "";
            msg = dashboardDAO.addProjectDuration();
            return msg ;
        }else{
            return "error add project duration";
        }
    }

    public String updateBillRate() {

        boolean test = dashboardDAO.vefifyBillRate();

        if(test){
            String msg = "";
            msg = dashboardDAO.updateBillRate();
            return msg;
        }else{
            return "error update bill rate";
        }    }

    public String projectActive() {

        boolean test = dashboardDAO.vefifyProjectActive();

        if(test){
            String msg = "";
            msg = dashboardDAO.projectActive();
            return msg;
        }else{
            return "error project active";
        }
    }

    public String projectTradsmenMatch() {

        boolean test = dashboardDAO.vefifyProjectTradsmenMatch();

        if(test){
            String tradsmen_skills = "";
            String list_candidate = "";
            String msg = "";

            tradsmen_skills = dashboardDAO.analyseTradsmenSkills();
            list_candidate = dashboardDAO.scearchProject(tradsmen_skills);
            msg = dashboardDAO.assignBestCandidate(list_candidate);


            return msg;
        }else{
            return "error project active";
        }
    }

    public String projectMatch() {

        boolean test = dashboardDAO.vefifyProjectMatch();

        if(test){
            String project_needs = "";
            String list_candidate = "";
            String msg = "";

            project_needs = dashboardDAO.analyseProjectNeed();
            list_candidate = dashboardDAO.scearchCandidate(project_needs);
            msg = dashboardDAO.assignBestProject(list_candidate);


            return msg;
        }else{
            return "error project active";
        }
    }



    @Override
    public void addUser(User user) {

        User usermodele = new User(user.getName(), user.getEmail() , user.getPassword());
        userRepository.save(usermodele);
    }
}
