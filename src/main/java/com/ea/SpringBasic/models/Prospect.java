package com.ea.SpringBasic.models;

public class Prospect {

    private String name;
    private String phoneNumber;
    private String major;
    private String statements;
    private String acceptTerms;

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMajor() {
        return major;
    }

    public String getStatements() {
        return statements;
    }

    public String getAcceptTerms() {
        return acceptTerms;
    }

    public Prospect(String name, String phoneNumber, String major, String statements, String acceptTerms) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.statements = statements;
        this.acceptTerms = acceptTerms;
    }


}
