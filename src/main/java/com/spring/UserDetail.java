package com.spring;

import org.springframework.stereotype.Component;

@Component
public class UserDetail {

    private String firstname;
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public UserDetail(String fname, String lname) {
        this.firstname = fname;
        this.lastname = lname;
    }
}
