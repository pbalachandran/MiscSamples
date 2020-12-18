package com.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoWiring {

    private final UserDetail userDetail;

    @Autowired
    public AutoWiring(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public UserDetail retrieveUserDetail() {
        return userDetail;
    }
}
