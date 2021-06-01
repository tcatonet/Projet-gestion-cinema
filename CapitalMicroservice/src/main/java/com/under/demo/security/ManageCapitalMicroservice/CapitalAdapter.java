package com.under.demo.security.ManageCapitalMicroservice;

import com.under.demo.security.ManageCapitalMicroservice.dataClass.Capital;
import org.springframework.stereotype.Component;


@Component
public class CapitalAdapter {

    public Capital map(Capital capital) {
        return new Capital()
                .setId(capital.getId())
                .setUsername(capital.getUsername())
                .setCapital(capital.getCapital());

    }
}