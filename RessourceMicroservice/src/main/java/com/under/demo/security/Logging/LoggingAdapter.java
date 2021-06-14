package com.under.demo.security.Logging;

import com.under.demo.security.Logging.dataClass.Logging;
import org.springframework.stereotype.Component;


@Component
public class LoggingAdapter {

    public Logging map(Logging logging) {
        return new Logging()
                .setId(logging.getId())
                .setContent(logging.getContent())
                .setLinkTo(logging.getLinkTo());
    }
}