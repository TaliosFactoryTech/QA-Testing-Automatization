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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class StatementsPage extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${StatementsAnswer1}")
    private String imVeryComfortableButton;

    @Value("${StatementsAnswer2}")
    private String imComfortableButton;

    @Value("${StatementsAnswer3}")
    private String imNeutralButton;

    @Value("${StatementsAnswer4}")
    private String imWeakButton;

    @Value("${StatementsAnswer5}")
    private String iDontWantToAnswerButton;

    @Value("${Statement1Text}")
    private String question1;

    @Value("${Statement2Text}")
    private String question2;

    @Value("${Statement3Text}")
    private String question3;

    @Value("${Statement4Text}")
    private String question4;

    @Value("${Statement5Text}")
    private String question5;

    @Value("${Statement6Text}")
    private String question6;

    @Value("${Statement7Text}")
    private String question7;

    List<String> questions = new ArrayList<>(Arrays.asList(question1,question2,question3,question4,question5,question6,question7));

    public void selectStatements(GuideDetails guideDetails){

        for (int i = 0; i < guideDetails.getGuide().getStatements().size(); i++) {

            //Validate Question Text
            driver.findElement(By.xpath(questions.get(i))).isDisplayed();

            switch (guideDetails.getGuide().getStatements().get(i)){
                case "1": driver.findElement(By.xpath(iDontWantToAnswerButton)).click();
                    break;
                case "2": driver.findElement(By.xpath(imWeakButton)).click();
                    break;
                case "3": driver.findElement(By.xpath(imNeutralButton)).click();
                    break;
                case "4": driver.findElement(By.xpath(imComfortableButton)).click();
                    break;
                case "5": driver.findElement(By.xpath(imVeryComfortableButton)).click();
                    break;
            }

        }

    }

}
