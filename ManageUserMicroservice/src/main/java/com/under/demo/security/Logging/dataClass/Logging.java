package com.under.demo.security.Logging.dataClass;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Logging {

    private String id;

    private String content;

    private String linkTo;


    public Logging(String id, String content, String linkTo) {
        this.id = id;
        this.content = content;
        this.linkTo = linkTo;
    }

    public Logging() {

    }
}
