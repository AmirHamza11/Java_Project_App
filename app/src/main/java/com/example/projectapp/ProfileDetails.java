package com.example.projectapp;

public class ProfileDetails {

    private String fullName;
    private String address;
    private String email;
    private String phone;
    private String firstPL;
    private String secondPL;

    public ProfileDetails() {
    }

    public ProfileDetails(String fullName, String address, String email, String phone, String firstPL, String secondPL) {
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.firstPL = firstPL;
        this.secondPL = secondPL;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstPL() {
        return firstPL;
    }

    public void setFirstPL(String firstPL) {
        this.firstPL = firstPL;
    }

    public String getSecondPL() {
        return secondPL;
    }

    public void setSecondPL(String secondPL) {
        this.secondPL = secondPL;
    }

    @Override
    public String toString() {
        return "ProfileDetails{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", firstPL='" + firstPL + '\'' +
                ", secondPL='" + secondPL + '\'' +
                '}';
    }
}
