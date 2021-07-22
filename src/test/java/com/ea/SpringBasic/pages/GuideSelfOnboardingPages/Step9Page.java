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
public class Step9Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${Step9WriteYourIntroMessageText}")
    private String introMessageText;

    @Value("${Step9ThisWillAutomaticallyBeSent}")
    private String automaticallyBeSentText;

    @Value("${SelfOnboardingNextButton}")
    private String nextButton;

    public boolean validateNavigation() {
        return driver.findElement(By.xpath(introMessageText)).isDisplayed() &&
                driver.findElement(By.xpath(automaticallyBeSentText)).isDisplayed();
    }

    public void clickNext() {
        driver.findElement(By.xpath(nextButton)).click();
    }
}
