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
public class Step12Page extends BasePage {

    @Autowired
    WebDriver driver;

    @Value("${Step12ChooseYourPayMethod}")
    private String chooseYourPaymentMethodText;

    @Value("${Step12PaypalButton}")
    private String paypalButton;

    @Value("${Step12VenmoButton}")
    private String venmoButton;

    public boolean validateNavigation() {
        return driver.findElement(By.xpath(chooseYourPaymentMethodText)).isDisplayed();
    }


    public void choosePayment(GuideDetails guideDetails) {

        if(guideDetails.getGuide().getPaymentType().equals("Paypal")){
            driver.findElement(By.xpath(paypalButton)).click();
        }
        else
            driver.findElement(By.xpath(venmoButton)).click();
    }
}
