package com.under.demo.security.ManageCapital;

import com.under.demo.security.ManageCapital.dataClass.Capital;
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