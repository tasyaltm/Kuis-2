package com.tasya.kuis_2.Model;

/**
 * Created by Tasya on 5/7/2018.
 */

public class Users {
    private String email, password, api_key;

    public Users() {
    }

    public Users(String email, String password, String api_key) {
        this.email = email;
        this.password = password;
        this.api_key = api_key;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }
}
