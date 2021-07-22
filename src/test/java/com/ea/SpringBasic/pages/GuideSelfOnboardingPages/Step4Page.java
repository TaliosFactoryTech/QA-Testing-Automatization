package com.ea.SpringBasic.pages.GuideSelfOnboardingPages;

import com.ea.SpringBasic.models.GuideDetails;
import com.ea.SpringBasic.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Step4Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${Step4UpdateYourProfileText}")
    private String updateYourProfileText;

    @Value("${Step4PhoneNumberGuide}")
    private String phoneNumber;

    @Value("${Step4FirstNameInput}")
    private String firstName;

    @Value("${Step4LastNameInput}")
    private String lastName;

    @Value("${Step4EmailInput}")
    private String email;

    @Value("${SelfOnboardingNextButton}")
    private String nextButton;


    public boolean validateNavigation() {
        return driver.findElement(By.xpath(updateYourProfileText)).isDisplayed();
    }

    public void validateData(GuideDetails guideDetails) {

        Assert.assertEquals(driver.findElement(By.xpath(String.format(phoneNumber, guideDetails.getGuide().getPhoneNumber()))).getText(), guideDetails.getGuide().getPhoneNumber());
        Assert.assertEquals(driver.findElement(By.xpath(firstName)).getText(), guideDetails.getGuide().getFirstName());
        Assert.assertEquals(driver.findElement(By.xpath(lastName)).getText(), guideDetails.getGuide().getLastName());
        Assert.assertEquals(driver.findElement(By.xpath(email)).getText(), guideDetails.getGuide().getEmail());

    }

    public void clickNext() {
        driver.findElement(By.xpath(nextButton)).click();
    }
}
