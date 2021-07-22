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
public class Step3Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${Step3HelloText}")
    private String helloText;

    @Value("${Step3AnswerQuestionText}")
    private String answerQuestionText;

    @Value("${Step3StartButton}")
    private String startButton;


    public boolean validateNavigation(GuideDetails guideDetails) {
        return driver.findElement(By.xpath(String.format(guideDetails.getGuide().getFirstName(),helloText))).isDisplayed()
                && driver.findElement(By.xpath(answerQuestionText)).isDisplayed();
    }

    public void clickNext() {
        driver.findElement(By.xpath(startButton)).click();
    }
}
