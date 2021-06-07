package com.under.demo.security.ManageCapitalMicroservice;

import com.under.demo.security.ManageCapitalMicroservice.dataClass.Capital;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.logging.Logger;

@Repository
public class CapitalRepository {

    private static final Logger LOGGER = Logger.getLogger("LOG: ");


    CapitalRepository( ) { }

    private final Map<String, Capital> db = new HashMap<>();


    public void retrieveCapital() {
    }

    public void depositCapital() {
    }

    public void withdrawal() {
    }

    public void profitCapital() {
    }

    public void lossCapital() {
    }
    public void addAccount() {
    }

}
