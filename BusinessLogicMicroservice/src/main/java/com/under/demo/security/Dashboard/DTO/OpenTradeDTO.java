package com.under.demo.security.Dashboard.DTO;

import lombok.Data;
import java.util.Date;

@Data
public class OpenTradeDTO {
    private int id;
    private Date start;
    private String resource;

}
