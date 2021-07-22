package com.ea.SpringBasic.pages;


import com.ea.SpringBasic.Utilities.RequestHelper;
import com.ea.SpringBasic.models.GuideDetails;
import com.ea.SpringBasic.models.ProspectDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GuideDetailPage extends BasePage{

    @Autowired
    WebDriver driver;

    @Value("${BOGuideDetailText}")
    private String changeGuideText;

    @Value("${BOGuideDetailType}")
    private String detailType;

    @Value("${BOGuideDetailFirstName}")
    private String firstName;

    @Value("${BOGuideDetailLastName}")
    private String lastName;

    @Value("${BOGuideDetailContactEmail}")
    private String email;

    @Value("${BOGuideDetailPhoneNumber}")
    private String phoneNumber;

    @Value("${BOGuideDetailUndecided}")
    private String undecided;

    @Value("${BOGuideDetailAcademicStanding}")
    private String academicStanding;

    @Value("${BOGuideDetailMajor}")
    private String major;

    @Value("${BOGuideDetailPaymentType}")
    private String paymentType;

    @Value("${BOGuideDetailPaymentAddress}")
    private String paymentAddress;

    public boolean validateNavigation() {
        return driver.findElement(By.xpath(changeGuideText)).isDisplayed();
    }

    public void validateGuide(GuideDetails guideDetails) {

        Assert.assertEquals(driver.findElement(By.xpath(detailType)).getText(), guideDetails.getGuide().getType());
        Assert.assertEquals(driver.findElement(By.xpath(firstName)).getText(), guideDetails.getGuide().getFirstName());
        Assert.assertEquals(driver.findElement(By.xpath(lastName)).getText(), guideDetails.getGuide().getLastName());
        Assert.assertEquals(driver.findElement(By.xpath(email)).getText(), guideDetails.getGuide().getEmail());
        Assert.assertEquals(driver.findElement(By.xpath(phoneNumber)).getText(), guideDetails.getGuide().getPhoneNumber());
        Assert.assertEquals(driver.findElement(By.xpath(undecided)).getText(), guideDetails.getGuide().isUndecided());
        Assert.assertEquals(driver.findElement(By.xpath(academicStanding)).getText(), guideDetails.getGuide().getAcademicStanding());
        Assert.assertEquals(driver.findElement(By.xpath(major)).getText(), guideDetails.getGuide().getMajor());
        Assert.assertEquals(driver.findElement(By.xpath(paymentType)).getText(), guideDetails.getGuide().getPaymentType());
        Assert.assertEquals(driver.findElement(By.xpath(paymentAddress)).getText(), guideDetails.getGuide().getPaymentAddress());

    }
}
