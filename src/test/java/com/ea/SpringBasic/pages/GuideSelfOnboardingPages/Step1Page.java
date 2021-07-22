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

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Step1Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${SelfOnboardingGuideHeader}")
    private String guidesRegistrationHeader;

    @Value("${Step1Text1}")
    private String getStartedText;

    @Value("${Step1Text2}")
    private String letsVerifyItsYouText;

    @Value("${Step1PhoneNumberInput}")
    private String phoneNumberInput;

    @Value("${SelfOnboardingNextButton}")
    private String nextButton;


    public boolean validateNavigation() {
        return (driver.findElement(By.xpath(guidesRegistrationHeader)).isDisplayed() && driver.findElement(By.xpath(getStartedText)).isDisplayed() && driver.findElement(By.xpath(letsVerifyItsYouText)).isDisplayed());
    }

    public void enterPhoneNumber(GuideDetails guideDetails) {

        driver.findElement(By.xpath(phoneNumberInput)).clear();
        driver.findElement(By.xpath(phoneNumberInput)).sendKeys(guideDetails.getGuide().getPhoneNumber());
    }

    public void clickNext() {
        driver.findElement(By.xpath(nextButton)).click();
    }
}
