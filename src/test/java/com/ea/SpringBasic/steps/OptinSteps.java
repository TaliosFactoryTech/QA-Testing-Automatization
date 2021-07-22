package com.ea.SpringBasic.steps;

import com.ea.SpringBasic.Utilities.RequestHelper;
import com.ea.SpringBasic.Utilities.Util;
import com.ea.SpringBasic.models.Prospect;
import com.ea.SpringBasic.models.ProspectDetails;
import com.ea.SpringBasic.models.TestUserDetails;
import com.ea.SpringBasic.models.UserDetails;
import com.ea.SpringBasic.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

public class OptinSteps {

    @Autowired
    public BOHomePage boHomePage;

    @Autowired
    public BOLoginPage boLoginPage;

    @Autowired
    public BOProspectsPage boProspectsPage;

    @Autowired
    private ProspectDetails prospectDetails;

    @Autowired
    private TestUserDetails testUserDetails;

    @Autowired
    public Util utilities;

    public static String receiverVirtualNumber = "13213073701"; // Fixed because i will use a specific campaign to test the features.

    @Given("I start the flow by sending the Campaign Phrase from a SenderVirtualNumber to ReceiverVirtualNumber")
    public void iStartTheFlowBySendingTheCampaignPhraseFromASenderVirtualNumberToReceiverVirtualNumber() throws JSONException {

        Prospect prospect = utilities.getRandomProspectWithStatements();

        prospectDetails.setProspect(prospect);

        RequestHelper.sendOptinMessage("Class of 2026",prospectDetails.getProspect().getPhoneNumber(),receiverVirtualNumber);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I send the prospect name")
    public void iSendTheProspectName() throws JSONException  {
        RequestHelper.sendOptinMessage(prospectDetails.getProspect().getName(),prospectDetails.getProspect().getPhoneNumber(),receiverVirtualNumber);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I send the major selected")
    public void iSendTheMajorSelected() throws JSONException {
        RequestHelper.sendOptinMessage(prospectDetails.getProspect().getMajor(),prospectDetails.getProspect().getPhoneNumber(),receiverVirtualNumber);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I send the Statements")
    public void iSendTheStatements() throws JSONException {
        RequestHelper.sendOptinMessage(prospectDetails.getProspect().getStatements(),prospectDetails.getProspect().getPhoneNumber(),receiverVirtualNumber);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I accept the terms and conditions")
    public void iAcceptTheTermsAndConditions() throws JSONException {
        RequestHelper.sendOptinMessage(prospectDetails.getProspect().getAcceptTerms(),prospectDetails.getProspect().getPhoneNumber(),receiverVirtualNumber);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I Log into the BackOffice with a real user")
    public void iLogIntoTheBackOffice() {

        testUserDetails.setUserDetails(new UserDetails("eze@avemariasoftware.com", "avemaria1"));

        boLoginPage.navigate();

        boLoginPage.enterData(testUserDetails.getUserDetails().getUsername(), testUserDetails.getUserDetails().getPassword());

        boLoginPage.clickLogin();

    }

    @And("I enter into the Prospects Section")
    public void iEnterIntoTheProspectsSection() {
        boHomePage.navigateToProspects();
        boProspectsPage.validateNavigation();
    }


    @Then("I should see the new Prospect Created on the Backoffice")
    public void iShouldSeeTheNewProspectCreatedOnTheBackoffice(){
        boProspectsPage.validateProspect(prospectDetails);
    }

}
