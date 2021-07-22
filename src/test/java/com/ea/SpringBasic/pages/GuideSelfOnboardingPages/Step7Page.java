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
public class Step7Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${Step7StudentLifeText}")
    private String sevenCategoriesText;

    @Value("${Step7StartButton}")
    private String startButton;

    public boolean validateNavigation() {
        return driver.findElement(By.xpath(sevenCategoriesText)).isDisplayed();
    }

    public void clickStart() {
        driver.findElement(By.xpath(startButton)).click();
    }
}
