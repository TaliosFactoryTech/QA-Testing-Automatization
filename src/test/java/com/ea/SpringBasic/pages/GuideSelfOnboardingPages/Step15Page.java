package com.ea.SpringBasic.pages.GuideSelfOnboardingPages;

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
public class Step15Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${Step15YouAreRegisteredText}")
    private String youAreRegisteredText;

    @Value("${Step15WeWillFollowUpText}")
    private String weWillFollowUpText;

    @Value("${Step15FinishedButton}")
    private String finishedButton;

    public boolean validateNavigation() {
        return driver.findElement(By.xpath(weWillFollowUpText)).isDisplayed()
                && driver.findElement(By.xpath(youAreRegisteredText)).isDisplayed();
    }


    public void clickFinished() {
        driver.findElement(By.xpath(finishedButton)).click();
    }

}
