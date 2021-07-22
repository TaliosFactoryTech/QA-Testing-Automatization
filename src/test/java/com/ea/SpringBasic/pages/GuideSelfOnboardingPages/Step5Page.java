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
import org.testng.Assert;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Step5Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${Step5TellUsYourMajorText}")
    private String tellUsYourMajorText;

    @Value("${Step5AcademicStandingSelect}")
    private String academicStandingSelect;

    @Value("${Step5MajorInput}")
    private String major;

    @Value("${SelfOnboardingNextButton}")
    private String nextButton;


    public boolean validateNavigation() {
        return driver.findElement(By.xpath(tellUsYourMajorText)).isDisplayed();
    }

    public void selectOption(String option){

         Select academicSelect = new Select(driver.findElement(By.xpath(academicStandingSelect)));

         academicSelect.selectByVisibleText(option);

    }

    public void enterMajor(String guideMajor) {
        driver.findElement(By.xpath(major)).sendKeys(guideMajor);
    }

    public void clickNext() {
        driver.findElement(By.xpath(nextButton)).click();
    }


}
