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
public class BOLoginPage {

    @Autowired
    WebDriver webDriver;

    @Value("${BOLoginPageUrl}")
    private String url;

    @Value("${BOloginEmail}")
    private String emailInput;

    @Value("${BOloginPassword}")
    private String passwordInput;

    @Value("${BOloginButton}")
    private String btnLogin;

    public void navigate()
    {
        webDriver.navigate().to(url);
    }

    public void enterData(String userName, String password)
    {
        webDriver.findElement(By.xpath(emailInput)).sendKeys(userName);
        webDriver.findElement(By.xpath(passwordInput)).sendKeys(password);
    }

    public BOHomePage clickLogin() {
        webDriver.findElement(By.xpath(btnLogin)).click();
        return new BOHomePage();
    }



}
