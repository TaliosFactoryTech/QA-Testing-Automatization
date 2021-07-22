package com.ea.SpringBasic.steps;

import com.ea.SpringBasic.models.TestUserDetails;
import com.ea.SpringBasic.models.UserDetails;
import com.ea.SpringBasic.pages.GuidesPage;
import com.ea.SpringBasic.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class LoginSteps {

    @Autowired
    public GuidesPage guidesPage;

    @Autowired
    public LoginPage loginPage;

    @Autowired
    private TestUserDetails testUserDetails;

    @Given("I enter the following for Login")
    public void iEnterDataForLoging(DataTable table) {

        testUserDetails.setUserDetails(new UserDetails("ezeuniversity@test.com", "avemaria1"));

        loginPage.enterData(testUserDetails.getUserDetails().getUsername(), testUserDetails.getUserDetails().getPassword());

    }

    @And("I click login button")
    public void iClickLoginButton() {
        loginPage.ClickLogin();
    }

    @And("I wait for {int} miliseconds")
    public void iWaitForMiliseconds(int arg0) {

        try {
            Thread.sleep(arg0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("I should see the Guides page")
    public void iShouldSeeTheGuidesPage() {
        guidesPage.closeLoginModal();
        Assert.assertEquals(guidesPage.validateNavigation() , true);
    }

    @And("I click logout link")
    public void iClickLogoutLink() {
        guidesPage.LogOff();
    }
}
