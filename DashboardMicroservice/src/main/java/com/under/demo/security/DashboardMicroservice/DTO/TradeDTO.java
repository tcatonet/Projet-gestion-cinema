package com.under.demo.security.DashboardMicroservice.DTO;

import lombok.Data;
import java.util.Date;

@Data
public class TradeDTO {
    private int id;
    private Date start;
    private Date stop;
    private String ressource;

}
