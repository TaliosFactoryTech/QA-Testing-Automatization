package com.ea.SpringBasic.pages;


import com.ea.SpringBasic.models.GuideDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GuidesPage extends BasePage{

    @Autowired
    WebDriver driver;

    @Value("${FEGuidesAddButton}")
    private String addGuidesButton;

    @Value("${FEOrganizationProfile}")
    private String organizationProfileButton;

    @Value("${FECloseLoginSnackBarButton}")
    private String closeLoginSnackBarButton;

    @Value("${FELogoutButton}")
    private String logoutButton;

    @Value("${FEGuidesListHeader}")
    private String guidesListHeader;

    @Value("${FEGuidesFirstNameInput}")
    private String guideFirstNameInput;

    @Value("${FEGuidesLastNameInput}")
    private String guideLastNameInput;

    @Value("${FEGuidesPhoneInput}")
    private String guidePhoneInput;

    @Value("${FEGuidesSchoolEmailInput}")
    private String guideEmailInput;

    @Value("${FEGuidesCreateButton}")
    private String guideCreateButton;

    @Value("${FEGuidesCancelButton}")
    private String guideCancelButton;

    public void closeLoginModal(){
        driver.findElement(By.xpath(closeLoginSnackBarButton)).click();
    }

    public LoginPage LogOff() {

        driver.findElement(By.xpath(organizationProfileButton)).click();
        driver.findElement(By.xpath(logoutButton)).click();

        return new LoginPage();
    }

    public boolean validateNavigation() {

        WebElement element = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(guidesListHeader)));

        return element.isDisplayed();
    }

    public void addGuide() {

        WebElement element = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addGuidesButton)));

        element.click();
    }

    public void enterData(GuideDetails guide) {
        driver.findElement(By.xpath(guideFirstNameInput)).sendKeys(guide.getGuide().getFirstName());
        driver.findElement(By.xpath(guideLastNameInput)).sendKeys(guide.getGuide().getLastName());
        driver.findElement(By.xpath(guidePhoneInput)).sendKeys(guide.getGuide().getPhoneNumber());
        driver.findElement(By.xpath(guideEmailInput)).sendKeys(guide.getGuide().getEmail());
    }

    public void acceptGuide() {
        driver.findElement(By.xpath(guideCreateButton)).click();
    }

    public void validateGuideCreatedOk() {

    }
}
