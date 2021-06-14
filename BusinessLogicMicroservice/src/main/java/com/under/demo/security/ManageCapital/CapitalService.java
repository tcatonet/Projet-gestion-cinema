package com.under.demo.security.ManageCapital;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CapitalService {
    private final CapitalRepository capital;


    public void retrieveCapital() {
        capital.retrieveCapital();
    }

    public void depositCapital() {
        capital.depositCapital();
    }

    public void withdrawal() {
        capital.withdrawal();
    }

    public void profitCapital() {
        capital.profitCapital();
    }

    public void lossCapital() {
        capital.lossCapital();
    }

    public void addAccount() {
        capital.addAccount();
    }

}
