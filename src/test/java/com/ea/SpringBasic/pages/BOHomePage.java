package com.ea.SpringBasic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BOHomePage {

    @Autowired
    WebDriver webDriver;

    @Value("${BOHomeProspectsButton}")
    private String prospects;

    @Value("${BOHomeGuidesButton}")
    private String guides;


    public BOProspectsPage navigateToProspects() {
        webDriver.findElement(By.xpath(prospects)).click();
        return new BOProspectsPage();
    }


    public BOGuidesPage navigateToGuides() {
        webDriver.findElement(By.xpath(guides)).click();
        return new BOGuidesPage();
    }
}
