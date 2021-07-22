package com.ea.SpringBasic.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LoginPage extends BasePage{

    @FindBy(how = How.NAME, using = "email")
    public WebElement txtEmail;
    @FindBy(how = How.NAME, using = "password")
    public WebElement txtPassword;
    @FindBy(how = How.XPATH, using = "//span[.='Login']")
    public WebElement btnLogin;

    public void enterData(String userName, String password)
    {
        txtEmail.sendKeys(userName);
        txtPassword.sendKeys(password);
    }

    public GuidesPage ClickLogin() {
        btnLogin.click();
        return new GuidesPage();
    }

}
