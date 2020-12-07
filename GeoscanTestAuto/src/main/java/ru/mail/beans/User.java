package ru.mail.beans;

import java.util.Date;

public class User {
    private String username;
    private String lastName;
    private String password;
    private String email;
    private Date birthDate;
    private int genderId;
    private String phoneNumber;

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

    public void setFirstName(String firstName) {
        this.username = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

