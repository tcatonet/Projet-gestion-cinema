package com.under.demo.security.user;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionToken {
    private String token;

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return this.token;
    }

    public SessionToken(){
    }
}
