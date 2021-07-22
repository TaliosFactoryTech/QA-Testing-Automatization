package com.ea.SpringBasic.models;

import java.util.List;

public class Guide {

    private String type;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean undecided;
    private String academicStanding;
    private String major;
    private String paymentType;
    private String paymentAddress;
    private List<String> statements;
    private String introText;
    private boolean termsAccepted;

    public String getType() {
        return type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String isUndecided() {
        if(undecided){
            return "Yes";
        }
        else
            return "No";
    }

    public String getAcademicStanding() {
        return academicStanding;
    }

    public String getMajor() {
        return major;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getPaymentAddress() {
        return paymentAddress;
    }

    public List<String> getStatements() {
        return statements;
    }

    public String getIntroText() {
        return introText;
    }

    public boolean isTermsAccepted() {
        return termsAccepted;
    }

    public Guide(String type, String firstName, String lastName, String email, String phoneNumber, boolean undecided, String academicStanding, String major, String paymentType, String paymentAddress, List<String> statements, String introText, boolean termsAccepted) {
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.undecided = undecided;
        this.academicStanding = academicStanding;
        this.major = major;
        this.paymentType = paymentType;
        this.paymentAddress = paymentAddress;
        this.statements = statements;
        this.introText = introText;
        this.termsAccepted = termsAccepted;
    }
}
