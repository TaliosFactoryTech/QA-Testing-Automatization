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
public class Step14Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${Step14TermsText}")
    private String termsText;

    @Value("${Step14TermsCheck}")
    private String termsCheck;

    @Value("${Step14NextButton}")
    private String nextButton;

    public boolean validateNavigation() {
        return driver.findElement(By.xpath(termsCheck)).isDisplayed();
    }


    public void checkTerms(){
        driver.findElement(By.xpath(termsCheck)).click();
    }

    public void clickNext() {
        driver.findElement(By.xpath(nextButton)).click();
    }

}
