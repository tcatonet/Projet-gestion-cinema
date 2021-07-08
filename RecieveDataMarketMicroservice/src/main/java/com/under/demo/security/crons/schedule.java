package com.under.demo.security.crons;

@interface Scheduled {

    String cron() default "";

    String zone() default "";

    long fixedDelay() default -1;

    String fixedDelayString() default "";

    long fixedRate() default -1;

    String fixedRateString() default "";

    long initialDelay() default -1;

    String initialDelayString() default "";

}