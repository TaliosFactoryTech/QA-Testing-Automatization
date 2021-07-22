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
public class Step11Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${Step11TypeAFriendlyText}")
    private String typeAFriendlyMessageText;

    @Value("${Step11TextArea}")
    private String introTextArea;

    @Value("${Step11iLikeItButton}")
    private String iLikeItButton;

    @Value("${SelfOnboardingNextButton}")
    private String nextButton;

    public boolean validateNavigation() {
        return driver.findElement(By.xpath(typeAFriendlyMessageText)).isDisplayed();
    }


    public void enterIntroMessage(GuideDetails guideDetails){
        driver.findElement(By.xpath(introTextArea)).sendKeys(guideDetails.getGuide().getIntroText());
    }

    public void clickILikeIt(){
        driver.findElement(By.xpath(iLikeItButton)).click();
    }


    public void clickNext() {
        driver.findElement(By.xpath(nextButton)).click();
    }
}
