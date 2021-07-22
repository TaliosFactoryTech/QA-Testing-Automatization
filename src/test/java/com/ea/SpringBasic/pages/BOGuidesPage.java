package com.ea.SpringBasic.pages;

import com.ea.SpringBasic.models.Guide;
import com.ea.SpringBasic.models.GuideDetails;
import com.ea.SpringBasic.models.ProspectDetails;
import com.ea.SpringBasic.Utilities.RequestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BOGuidesPage {

    @Autowired
    WebDriver driver;

    @Value("${BOGuidesUrl}")
    private String url;

    @Value("${BOGuidesTable}")
    private String table;

    @Value("${BOGuidesSelectGuideToChange}")
    private String selectGuideText;

    @Value("${BOGuideFullName}")
    private String guideFullName;

    @Value("${BOGuideContactEmail}")
    private String guideContactEmail;

    @Value("${BOGuidePhoneNumber}")
    private String guidePhoneNumber;

    @Value("${BOGuideRegistrationUrl}")
    private String guideRegistrationUrl;

    @Value("${BOGuideTermsAcceptedTrue}")
    private String termsAcceptedTrue;

    @Value("${BOGuideTermsAcceptedFalse}")
    private String termsAcceptedFalse;

    @Value("${BOSidebarGuidePrograms}")
    private String sidebarGuidePrograms;


    public boolean validateNavigation() {
        return driver.findElement(By.xpath(selectGuideText)).isDisplayed();
    }

    public void validateGuide(GuideDetails guideDetails) {

        WebElement row = getGuideRow(guideDetails.getGuide().getPhoneNumber());

        Assert.assertEquals(row.findElement(By.xpath(guideFullName)).getText(), (guideDetails.getGuide().getFirstName()+ " " +guideDetails.getGuide().getLastName()));
        Assert.assertEquals(row.findElement(By.xpath(guideContactEmail)).getText() , guideDetails.getGuide().getEmail());
        Assert.assertEquals(row.findElement(By.xpath(guidePhoneNumber)).getText() , "+"+guideDetails.getGuide().getPhoneNumber());

        if(guideDetails.getGuide().isTermsAccepted()){
            Assert.assertTrue(row.findElement(By.xpath(termsAcceptedTrue)).isDisplayed());
        }
        else{
            Assert.assertTrue(row.findElement(By.xpath(termsAcceptedFalse)).isDisplayed());
        }

    }

    public String getRegistrationUrl(GuideDetails guideDetails){

        WebElement row = getGuideRow(guideDetails.getGuide().getPhoneNumber());

        return row.findElement(By.xpath(guideRegistrationUrl)).getText();
    }

    private WebElement getGuideRow(String phoneNumber) {


        WebElement baseTable = driver.findElement(By.xpath(table));
        List<WebElement> rows = baseTable.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size() ; i++) {
            if(rows.get(i-1).findElement(By.xpath("//td[4]")).getText().equals("+"+phoneNumber)){
                return rows.get(i);
            }
        }
        return null;
    }

    public BOGuideProgramsPage goToGuidePrograms() {
        driver.findElement(By.xpath(sidebarGuidePrograms)).click();
        return new BOGuideProgramsPage();
    }

    public String getGuideId(GuideDetails guideDetails) {

        enterGuideDetails(guideDetails);

        String url = driver.getCurrentUrl();

        return url.substring(65,66);

    }

    public GuideDetailPage enterGuideDetails(GuideDetails guideDetails) {

        WebElement row = getGuideRow(guideDetails.getGuide().getPhoneNumber());

        row.click();

        return new GuideDetailPage();

    }

    public void navigate() {
        driver.navigate().to(url);
    }
}
