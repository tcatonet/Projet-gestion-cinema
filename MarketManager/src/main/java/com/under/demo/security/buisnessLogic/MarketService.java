package com.under.demo.security.buisnessLogic;

import com.under.demo.security.database.Modele.Dashboard;
import com.under.demo.security.database.Modele.Resource;
import com.under.demo.security.database.Modele.Trade;
import com.under.demo.security.database.Modele.User;
import com.under.demo.security.buisnessLogic.DAO.MarketDAO;
import com.under.demo.security.buisnessLogic.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MarketService implements IUserService {
    private MarketDAO marketDAO;
    UserRepository userRepository;

    public String projectCreate() {

        boolean test = marketDAO.vefifyProject();

        if(test){
            String msg = "";
            msg = marketDAO.addRequiredTrade();
            msg = msg + marketDAO.addRequiredSkills();
            return "project create" + msg;
        }else{
            return "error project creation";
        }
    }

    public String projectClose() {

        boolean test = marketDAO.vefifyProjectClose();

        if(test){
            String msg = "";
            msg = marketDAO.releaseTradmen();
            msg = msg + marketDAO.closeProject();
            return msg;
        }else{
            return "error project close";
        }
    }


    public String addProjectDuration() {

        boolean test = marketDAO.vefifyProjectDuration();

        if(test){
            String msg = "";
            msg = marketDAO.addProjectDuration();
            return msg ;
        }else{
            return "error add project duration";
        }
    }

    public String updateBillRate() {

        boolean test = marketDAO.vefifyBillRate();

        if(test){
            String msg = "";
            msg = marketDAO.updateBillRate();
            return msg;
        }else{
            return "error update bill rate";
        }    }

    public String projectActive() {

        boolean test = marketDAO.vefifyProjectActive();

        if(test){
            String msg = "";
            msg = marketDAO.projectActive();
            return msg;
        }else{
            return "error project active";
        }
    }

    public String projectTradsmenMatch() {

        boolean test = marketDAO.vefifyProjectTradsmenMatch();

        if(test){
            String tradsmen_skills = "";
            String list_candidate = "";
            String msg = "";

            tradsmen_skills = marketDAO.analyseTradsmenSkills();
            list_candidate = marketDAO.scearchProject(tradsmen_skills);
            msg = marketDAO.assignBestCandidate(list_candidate);


            return msg;
        }else{
            return "error project active";
        }
    }

    public String projectMatch() {

        boolean test = marketDAO.vefifyProjectMatch();

        if(test){
            String project_needs = "";
            String list_candidate = "";
            String msg = "";

            project_needs = marketDAO.analyseProjectNeed();
            list_candidate = marketDAO.scearchCandidate(project_needs);
            msg = marketDAO.assignBestProject(list_candidate);


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
