package com.example.test;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String password;

    private String dob;

    public User(String name, String password, String dob) {
        this.name = name;
        this.password = password;
        this.dob = dob;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
