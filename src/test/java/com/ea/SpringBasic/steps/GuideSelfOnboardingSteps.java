package com.ea.SpringBasic.steps;

import com.ea.SpringBasic.Enums.AcademicStanding;
import com.ea.SpringBasic.Utilities.Util;
import com.ea.SpringBasic.models.Guide;
import com.ea.SpringBasic.models.GuideDetails;
import com.ea.SpringBasic.models.TestUserDetails;
import com.ea.SpringBasic.models.UserDetails;
import com.ea.SpringBasic.pages.*;
import com.ea.SpringBasic.pages.GuideSelfOnboardingPages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class GuideSelfOnboardingSteps {


    @Autowired
    WebDriver webDriver;

    @Autowired
    public GuidesPage guidesPage;

    @Autowired
    public Step1Page step1Page;

    @Autowired
    public Step2Page step2Page;

    @Autowired
    public Step3Page step3Page;

    @Autowired
    public Step4Page step4Page;

    @Autowired
    public Step5Page step5Page;

    @Autowired
    public Step6Page step6Page;

    @Autowired
    public Step7Page step7Page;

    @Autowired
    public StatementsPage statementsPage;

    @Autowired
    public Step9Page step9Page;

    @Autowired
    public Step10Page step10Page;

    @Autowired
    public Step11Page step11Page;

    @Autowired
    public Step12Page step12Page;

    @Autowired
    public Step13Page step13Page;

    @Autowired
    public Step14Page step14Page;

    @Autowired
    public Step15Page step15Page;

    @Autowired
    public GuideDetailPage guideDetailPage;

    @Autowired
    public LoginPage loginPage;

    @Autowired
    public BOLoginPage boLoginPage;

    @Autowired
    public BOGuidesPage boGuidesPage;

    @Autowired
    public BOGuideProgramsPage boGuideProgramsPage;

    @Autowired
    public BOHomePage boHomePage;

    @Autowired
    private TestUserDetails testUserDetails;

    @Autowired
    private GuideDetails guideDetails;

    @Autowired
    private Util utilities;

    private String url;
    private String code;
    private String guideId;


    @Given("I Log into the frontend with a valid client")
    public void iLogIntoTheFrontendWithAValidClient() {

        testUserDetails.setUserDetails(new UserDetails("ezeuniversity@test.com", "avemaria1"));

        loginPage.enterData(testUserDetails.getUserDetails().getUsername(), testUserDetails.getUserDetails().getPassword());

        loginPage.ClickLogin();

        guidesPage.validateNavigation();

    }

    @And("I add a new Guide with Random Valid Data")
    public void iAddANewGuideWithRandomValidData() {

        Guide guide = utilities.getRandomGuide();

        guideDetails.setGuide(guide);

        guidesPage.addGuide();

        guidesPage.enterData(guideDetails);

        guidesPage.acceptGuide();

        guidesPage.validateGuideCreatedOk();

    }

    @And("I enter into the Guides Section")
    public void iEnterIntoTheGuidesSection() {

        boHomePage.navigateToGuides();
        boGuidesPage.validateNavigation();
    }

    @And("I validate the Guide Created")
    public void iValidateTheGuideCreated() {
        boGuidesPage.validateGuide(guideDetails);
    }

    @And("I Get the URL for the SelfOnboarding Registration")
    public void iGetTheURLForTheSelfOnboardingRegistration() {
        this.url = boGuidesPage.getRegistrationUrl(guideDetails);
    }

    @And("I Get the ID for that Guide")
    public void iGetTheIDForThatGuide() {
        this.guideId = boGuidesPage.getGuideId(guideDetails);
    }

    @Then("I Navigate into the Guide Programs Page")
    public void iNavigateIntoTheGuideProgramsPage() {
        boGuidesPage.goToGuidePrograms();
    }

    @And("I Get the confirmation code for that Guide")
    public void iGetTheConfirmationCodeForThatGuide() {
        this.code = boGuideProgramsPage.getGuideCode(guideDetails);
    }

    @And("I enter into the SelfOnboarding url for that Guide")
    public void iEnterIntoTheSelfOnboardingUrlForThatGuide() {
        webDriver.navigate().to(url);
    }

    @And("I complete the registration with valid data")
    public void iCompleteTheRegistrationWithValidData() {

        step1Page.validateNavigation();
        step1Page.enterPhoneNumber(guideDetails);
        step1Page.clickNext();

        step2Page.validateNavigation();
        step2Page.enterCode(code);
        step2Page.clickNext();

        step3Page.validateNavigation(guideDetails);
        step3Page.clickNext();

        step4Page.validateNavigation();
        step4Page.validateData(guideDetails);
        step4Page.clickNext();

        step5Page.validateNavigation();
        step5Page.selectOption(AcademicStanding.Junior.getName());
        step5Page.enterMajor(guideDetails.getGuide().getMajor());
        step5Page.clickNext();

        step6Page.validateNavigation();
        step6Page.selectUndecided(guideDetails);

        step7Page.validateNavigation();
        step7Page.clickStart();

        statementsPage.selectStatements(guideDetails);

        step9Page.validateNavigation();
        step9Page.clickNext();

        step10Page.validateNavigation();
        step10Page.clickNext();

        step11Page.validateNavigation();
        step11Page.enterIntroMessage(guideDetails);
        step11Page.clickNext();
        step11Page.clickILikeIt();

        step12Page.validateNavigation();
        step12Page.choosePayment(guideDetails);

        step13Page.validateNavigation();
        step13Page.enterPaymentAddress(guideDetails);
        step13Page.clickNext();

        step14Page.validateNavigation();
        step14Page.checkTerms();
        step14Page.clickNext();

        step15Page.validateNavigation();
        step15Page.clickFinished();

    }

    @Then("I should see the Guide with the accepted Terms on the Backoffice")
    public void iShouldSeeTheGuideWithTheAcceptedTermsOnTheBackoffice() {

        boGuidesPage.navigate();
        boGuidesPage.validateGuide(guideDetails);
        boGuidesPage.enterGuideDetails(guideDetails);

        guideDetailPage.validateNavigation();
        guideDetailPage.validateGuide(guideDetails);
    }
}
