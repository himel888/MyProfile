package com.example.kazi.myprofile.model;

/**
 * Created by Kazi on 1/31/2017.
 */

public class User {

    private String userName;
    private String userLocation;
    private String userMail;

    public User(String userName, String userLocation, String userMail) {
        this.userName = userName;
        this.userLocation = userLocation;
        this.userMail = userMail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}
