package com.ea.SpringBasic.pages.GuideSelfOnboardingPages;

import com.ea.SpringBasic.models.GuideDetails;
import com.ea.SpringBasic.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Step6Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${Step6WereYouUndecidedText}")
    private String wereYouUndecidedText;

    @Value("${Step6YesButton}")
    private String yesButton;

    @Value("${Step6NoButton}")
    private String noButton;

    public boolean validateNavigation() {
        return driver.findElement(By.xpath(wereYouUndecidedText)).isDisplayed();
    }

    public void selectYes() {
        driver.findElement(By.xpath(yesButton)).click();
    }

    public void selectNo() {
        driver.findElement(By.xpath(noButton)).click();
    }

    public void selectUndecided(GuideDetails guideDetails) {
        if(guideDetails.getGuide().isUndecided().equals("Yes"))
            selectYes();
        else
            selectNo();
    }
}
