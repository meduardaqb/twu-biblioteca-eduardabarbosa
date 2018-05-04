package com.twu.biblioteca.model;

public class User {
    private String name;
    private String registration;
    private String email;
    private String address;
    private String phoneNumber;
    private String password;


    public User(String name, String registration, String email, String address, String phoneNumber, String password) {
        this.name = name;
        this.registration = registration;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getRegistration() {
        return registration;
    }
}
