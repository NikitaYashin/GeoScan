package ru.mail.beans;

import lombok.Getter;

import java.util.Date;

public class User {
    private final String username;
    private final String lastName;
    private String password;
    private final String email;
    private final Date birthDate;
    private final int genderId;
    private final String phoneNumber;

    public User(String username, String lastName, String password, String email,
                Date birthDate, int genderId, String phoneNumber) {
        this.username = username;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.genderId = genderId;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getGenderId() {
        return genderId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

