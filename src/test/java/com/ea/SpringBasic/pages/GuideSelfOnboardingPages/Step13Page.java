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
public class Step13Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${Step13EnterThePaymentAccount}")
    private String enterPaymentAccountText;

    @Value("${Step13AccountInput}")
    private String accountInput;

    @Value("${SelfOnboardingNextButton}")
    private String nextButton;

    public boolean validateNavigation() {
        return driver.findElement(By.xpath(enterPaymentAccountText)).isDisplayed();
    }


    public void enterPaymentAddress(GuideDetails guideDetails){
        driver.findElement(By.xpath(nextButton)).sendKeys(guideDetails.getGuide().getPaymentAddress());
    }

    public void clickNext() {
        driver.findElement(By.xpath(nextButton)).click();
    }

}
