package com.under.demo.security.user;

import com.under.demo.security.database.Modele.User;
import com.under.demo.security.user.DAO.UserDAO;
import com.under.demo.security.user.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserDAO userDAO;
    UserRepository userRepository;

    public String createUser(String username, String password, String email) {
        return userDAO.createUser(username,password,email);
    }


    public String depositUserCapital(String userName, int amountDeposit ) {
        return userDAO.depositUserCapital(userName, amountDeposit);
    }

    public String withdrawalUserCapital(String userName, int amountDeposit ) {
        return userDAO.withdrawalUserCapital(userName, amountDeposit);
    }

    public float getUserCapital(String userName) {
        return userDAO.getUserCapital(userName);
    }


    public String updateUserPassword(String userName, String password) {

        return userDAO.updateUserPassword(userName, password);
    }

    public String getUserEmail(String userName) {
        return userDAO.getUserEmail(userName);
    }

    public String updateUserEmail(String userName, String email) {

        return userDAO.updateUserEmail(userName, email);
    }

    public String getUsers(){
        return userDAO.getUsers();
    }

    public String createAdmin(String name, String email, String password){
        return userDAO.createAdmin(name, email, password);
    }


    public String projectLeft() {

        boolean available = userDAO.vefifyLeftProject();
        boolean verifRequest = userDAO.vefifyAvailabilityTradsmen();

        if(available && verifRequest){
            String msg = "";
            msg = userDAO.leftProject();
            return msg;
        }else{
            return "error left project";
        }
    }

    public String projectJoin() {

        boolean test = userDAO.vefifyJoinProject();

        if(test){
            String msg = "";
            msg = userDAO.joinProject();
            return msg;
        }else{
            return "error join project";
        }
    }


    public String tradsmenMembershipApply() {

        boolean test = userDAO.vefifyTradsmenMembershipApply();

        if(test){
            String msg = "";
            msg = userDAO.processPaymentTradsmen();
            msg = msg + userDAO.tradsmenMembershipApply();
            return msg;
        }else{
            return "error apply tradsmen membership";
        }
    }

    public String contractorMembershipApply() {

        boolean test = userDAO.vefifyContractorMembershipApply();

        if(test){
            String msg = "";
            msg = userDAO.processPaymentContractor();
            msg = msg + userDAO.contractorMembershipApply();

            return msg;
        }else{
            return "error  apply contractor membership";
        }
    }

    public String paymentHistorique() {

        String msg = "";
        msg = userDAO.paymentHistorique();
        return msg;
    }





    @Override
    public void addUser(User user) {

        User usermodele = new User(user.getName(), user.getEmail() , user.getPassword());
        userRepository.save(usermodele);
    }
}
