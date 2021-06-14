package com.under.demo.security.ManageCapital;

import com.under.demo.security.ManageCapital.DTO.*;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController()
public class CapitalController {

    public CapitalController(CapitalService capitalService) {
        this.capitalService = capitalService;
    }

    private final CapitalService capitalService;
    private static final Logger LOGGER = Logger.getLogger("LOG: ");


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/resource/capital/deposit")
    public void depositCapital(@RequestBody CapitalDepositDTO capitalDepositDTO) {
        capitalService.depositCapital();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/resource/capital/withdrawal")
    public void withdrawalCapital(@RequestBody CapitalWithdrawalDTO capitalWithdrawalDTO) {
        capitalService.withdrawal();
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/resource/capital/trade/profit")
    public void profitCapital(@RequestBody CapitalProfitDTO capitalProfitDTO) {
        capitalService.profitCapital();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/resource/capital/trade/loss")
    public void lossCapital(@RequestBody CapitalLossDTO capitalLossDTO) {
        capitalService.lossCapital();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/resource/capital/retrieve")
    public void retrieveCapital(@RequestBody CapitalDTO capitalDTO) {
        capitalService.retrieveCapital();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/resource/capital/account/add")
    public void addAcccount(@RequestBody CapitalDTO capitalDTO) {
        capitalService.addAccount();
    }




}
